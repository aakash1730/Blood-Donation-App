package com.example.anujanjirwala.blooddonation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Anuj Anjirwala on 13-Sep-16.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    EditText User, password;
    Button Login,SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);   //view is created here.It provides hierarchy.

        User= (EditText) findViewById(R.id.username);   // It looks through view hierarchy and returns reference to a view with requested viewId. View is already created and exists.
        password =(EditText) findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.login);
        SignUp = (Button) findViewById(R.id.signup1);

        Login.setOnClickListener(this); //When the user clicks the button, the onClick function of the assigned OnClickListener is called.
        SignUp.setOnClickListener(this);    //We have to implement methods which comes with the OnClickListner interface.
    }

    @Override
    public void onClick(View v) {
        if(v == Login)  {
            if(!User.getText().toString().equals("") && !password.getText().toString().equals(""))  {
                Intent i = new Intent(MainActivity.this, HomeScreen.class);
                MainActivity.this.startActivity(i);
            }
            else {
                Toast.makeText(this,"Please fill required fields!", Toast.LENGTH_SHORT).show();  //A toast provides simple feedback about an operation in a small popup.it wraps the content required for the written text
                //Syntax : Toast.makeText(context, text, duration).show();
                //The Context object is used across the application to do many things like access resources that the Android OS has allocated for the particular app.
            }
        }
        else if(v==SignUp)  {
            Intent i = new Intent(MainActivity.this, SignupScreen.class);
            MainActivity.this.startActivity(i);
        }
    }



    public void onBackPressed() {
        finish();
    }
}
