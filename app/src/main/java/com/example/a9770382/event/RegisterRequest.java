package com.example.a9770382.event;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 9770382 on 14/06/2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String RegisterRequestURL = "https://joekbg5.000webhostapp.com/registerTest.php";
    private HashMap<String, String> params;

    public RegisterRequest(String username, String email, String password, Response.Listener<String> listener){
        super(Method.POST, RegisterRequestURL, listener, null);
        params = new HashMap<>();
        params.put("name", username);
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
