package com.example.a9770382.event;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 9770382 on 14/06/2017.
 */

public class ExecuteDataBase extends AsyncTask<String, Void, ResultSet> {
    private Connection con;
    private String query;

    public ExecuteDataBase(Connection con, String query){
        this.con = con;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... params) {
        ResultSet resultSet = null;
        try{
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery(query);
            stmt.close();
        }catch (Exception e){
            Log.e("RS", "NOT RS EXECUTE");
            e.printStackTrace();
        }
        finally {
            try{
                con.close();
            }catch (Exception ex){
                Log.e("RS", "NOT CLOSE");
                ex.printStackTrace();
            }
        }
        return resultSet;
    }
}
