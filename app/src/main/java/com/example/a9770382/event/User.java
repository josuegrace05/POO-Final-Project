package com.example.a9770382.event;

import android.util.Log;

import java.sql.ResultSet;

/**
 * Created by 9770382 on 14/06/2017.
 */

public class User {
    private  String username;
    private  String email;
    private  String password;

    //TODO falta ver se precisa da senha

    public User(String username, String email, String password){

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static String selectUserName(String email, String password){
        // Retorna uma string com o nome do usuário dado. Ou NULL caso o usuário não exista.
        int id;
        String em, pas;
        Log.e("RS", "LEU RS");
        Database db = new Database();
        Log.e("RS", "LEU RS");
        String name = null;
        try{
            //ResultSet rs = db.select("SELECT nm_usuario FROM tb_usuario WHERE nm_email = '" + email + "' AND nm_senha = '" + password + "'");
            //ResultSet rs = db.select("SELECT nm_usuario FROM tb_usuario WHERE nm_email = 'ronaldo@gmail' and nm_senha = '1234'");
            ResultSet rs = db.select("SELECT * FROM tb_usuario;");
            Log.e("RS", "LEU RS");

            if(rs != null){
                Log.e("RS", "ENTROU RS");
                while(rs.next()) {
                    id = rs.getInt("cd_usuario");
                    name = rs.getString("nm_usuario");
                    em = rs.getString("nm_email");
                    pas = rs.getString("nm_senha");
                    if(name != null)
                        Log.e("RS", "RETORNA CAMPO RS");
                }
            }
        }catch(Exception e){
            Log.e("RS", "PROBLEMA RS");
            e.printStackTrace();
            Log.e("error ", e.getMessage());
        }

        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
