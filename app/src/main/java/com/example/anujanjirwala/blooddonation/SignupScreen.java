package com.example.anujanjirwala.blooddonation;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Anuj Anjirwala on 14-Oct-16.
 */

public class SignupScreen extends Activity implements View.OnClickListener {
    Button SignUp ;
    ImageView backbutton ;
    EditText User,password,repassword,Contact,Emailid;
    Spinner list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        backbutton=(ImageView)findViewById(R.id.back) ;
        User= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.pass);
        Contact= (EditText) findViewById(R.id.number);
        Emailid= (EditText) findViewById(R.id.email);
        repassword= (EditText) findViewById(R.id.repass);
        SignUp = (Button) findViewById(R.id.signup2);
        list = (Spinner) findViewById(R.id.list);

        backbutton.setOnClickListener(this);
        SignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backbutton) {
            Intent i = new Intent(SignupScreen.this, MainActivity.class);
            SignupScreen.this.startActivity(i);
            finish();
        }
        else if (v == SignUp) {
            //if (!User.getText().toString().equals("") && !password.getText().toString().equals("") && !repassword.getText().toString().equals("") && !Contact.getText().toString().equals("") &&
                    //!Emailid.getText().toString().equals("")) {
                //if(password.getText().equals(repassword.getText().toString())) {
                    final String username=User.getText().toString();
                    final String password=this.password.getText().toString();
                    final int contactnumber=Integer.parseInt(Contact.getText().toString());
                    final String email=Emailid.getText().toString();
                    final String bloodgroup=list.getSelectedItem().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Intent i = new Intent(SignupScreen.this, MainActivity.class);
                                    SignupScreen.this.startActivity(i);
                                    }
                                else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupScreen.this);
                                    builder.setMessage("Register Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                    }
                                }
                            catch (JSONException e) { e.printStackTrace();}
                        }
                    };
                    RegisterRequest registerRequest = new RegisterRequest(username, password, contactnumber, email, bloodgroup, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(SignupScreen.this);
                //}
                //else    {
                 //   Toast.makeText(this, "Password in both fields must be same.", Toast.LENGTH_SHORT).show();
                //}
            //}
          //  else {
            //    Toast.makeText(this, "Please fill required fields!", Toast.LENGTH_SHORT).show();
            //}
        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

}
