package com.example.anujanjirwala.blooddonation;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anuj Anjirwala on 24-Dec-16.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://studenthost1.cf/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String username, String password, int contactnumber, String email, String bloodgroup, Response.Listener<String> listener)    {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("contactnumber", contactnumber+"");
        params.put("email", email);
        params.put("bloodgroup", bloodgroup);
    }
    public Map<String,String> getParams()   {
        return params;
    }
}
