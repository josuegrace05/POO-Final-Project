package com.example.a9770382.event;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by 9770382 on 14/06/2017.
 */

public class Database extends myExceptions implements  Runnable{
    private Connection con;
    private String host = "172.26.184.189";
    private String db = "db_event";
    private int port = 3306;
    private String user = "android";
    private String password = "root";
    private String url = "jdbc:mysql://%s:%d/%s";
    private String driver = "com.mysql.jdbc.Driver";
    public int test = 0;

    public Database(){

        super(true, "");
        this.url = String.format(this.url,this.host,this.port,this.db);
    }

    @Override
    public void run() {
        try{
            Class.forName(this.driver);
        }catch(Exception e){
            Log.e("Erro", "Erro em CLass.forname");
        }

        try{
            Log.e("Erro", "Vai conectar");
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            if(con == null) {
                Log.e("Erro", "não conectou");
                this.test = 1;
            }
            else
                Log.e("Erro", "CONECTOU");
            Log.e("Erro", "Erro em CLass.forname");

        }catch(Exception e){
            this.message = e.getMessage();
            this.status = false;
            Log.d("Erro", "Erro na conexão " + e.getMessage());
        }
    }

    private void connect(){

        Thread thread = new Thread(this);
        thread.start();

        try{
            thread.join();
        }catch(Exception e){
            this.message = e.getMessage();
            this.status = false;
        }
    }

    private void disconnect(){
        if(this.con != null){
            try{
                this.con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                this.con = null;
            }
        }
    }

    public ResultSet select(String query){
        this.connect();
        ResultSet resultSet = null;
        try {
            ExecuteDataBase eDB = new ExecuteDataBase(this.con, query);
            resultSet = eDB.execute().get();
        }catch (Exception e){
            this.message = e.getMessage();
            this.status = false;
            Log.e("RS", "Dtabase RS");
        }
        return resultSet;
    }
    public ResultSet insert(String query){
        this.connect();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDataBase(this.con, query).execute().get();
        }catch (Exception e){
            this.message = e.getMessage();
            this.status = false;

        }
        return resultSet;
    }

}
