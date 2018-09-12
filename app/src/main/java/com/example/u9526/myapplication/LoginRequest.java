package com.example.u9526.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL ="https://zaq2344321.000webhostapp.com/Login2.php";
    private Map<String , String> params;

    public LoginRequest(String username, String password, Response.Listener<String>listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("U_Username", username);
        params.put("U_Password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
