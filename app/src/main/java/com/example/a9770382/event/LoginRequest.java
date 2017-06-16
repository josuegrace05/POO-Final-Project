package com.example.a9770382.event;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 9770382 on 15/06/2017.
 */

public class LoginRequest extends StringRequest {
    private static final String LoginRequestURL = "https://joekbg5.000webhostapp.com/login.php";
    private HashMap<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST, LoginRequestURL, listener, null);
        params = new HashMap<>();
        params.put("name", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
