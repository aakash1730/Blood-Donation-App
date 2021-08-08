package com.example.anujanjirwala.blooddonation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Anuj Anjirwala on 13-Sep-16.
 */
public class HomeScreen extends Activity implements View.OnClickListener {

    Button LogOut, finddonor, giveblood;
    boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        LogOut = (Button) findViewById(R.id.logout);
        finddonor = (Button) findViewById(R.id.find);
        giveblood = (Button) findViewById(R.id.give);

        finddonor.setOnClickListener(this);
        giveblood.setOnClickListener(this);
        LogOut.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v == finddonor) {
            Intent i = new Intent(HomeScreen.this, FindDonor.class);
            HomeScreen.this.startActivity(i);
        } else if (v == giveblood) {
            Intent i = new Intent(HomeScreen.this, GiveBlood.class);
            HomeScreen.this.startActivity(i);
        } else if (v == LogOut) {
            Intent i = new Intent(HomeScreen.this, MainActivity.class);
            HomeScreen.this.startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please tap BACK again to Logout.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {  //A Handler allows us to send and process Message and Runnable objects associated with a thread's MessageQueue.
        //Syntax : postDelayed(Runnable r, long delayMilliseconds)
        //Causes the Runnable to be added to the message queue, to be run after the specified amount of time elapses.
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 5000);

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();  //finishing the current activity.
            return;
        }
    }
}
