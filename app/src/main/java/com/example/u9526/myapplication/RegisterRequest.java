package com.example.u9526.myapplication;

//註冊程式碼
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest{
private static final String REGISTER_REQUEST_URL ="https://zaq2344321.000webhostapp.com/Register2.php";
private Map<String , String> params;

public RegisterRequest(String name, String username, String password, Response.Listener<String>listener){
    super(Method.POST, REGISTER_REQUEST_URL, listener, null);
    params = new HashMap<>();
    params.put("U_Name", name);
    params.put("U_Username", username);
    params.put("U_Password", password);
}

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}