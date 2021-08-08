package com.example.anujanjirwala.blooddonation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainSplashScreen extends Activity {
    @Override
    //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity.
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen); //xml layout is passed and view hierarchy is created.

        Thread timerThread = new Thread() {
            public void run(){
                try{
                    sleep(3000);       //to pause/sleep thread or processs
                }
                catch(InterruptedException e){
                    e.printStackTrace();    //It prints the stack trace of the Exception to System.err. It's a tool for diagnosing an Exception. It tells what happened and where in the code this happened.
                }
                finally{
                    Intent intent = new Intent(MainSplashScreen.this,MainActivity.class);   //a messaging object to request an action from another app component
                    startActivity(intent);  //to start a Activity from the resulted object "intent" from the above statement.
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}