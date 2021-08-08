package com.example.anujanjirwala.blooddonation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Anuj Anjirwala on 14-Oct-16.
 */

public class GiveBlood extends Activity implements View.OnClickListener {
    ImageView backbutton;

    private String names[] = {
            "Varun Shah",
            "Rahul patel",
            "Jaydeep Ram",
            "Abhay Rathod",
            "Manan Patel"
    };

    private String contact[] = {
            "+918497927483",
            "+918947483838",
            "+917927728373",
            "+918348494949",
            "+917037373838"
    };


    private Integer imageid[] = {
            R.drawable.male,
            R.drawable.male,
            R.drawable.male,
            R.drawable.male,
            R.drawable.male
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_donors);
        backbutton = (ImageView) findViewById(R.id.back);
        backbutton.setOnClickListener(this);

        CustomListView customList = new CustomListView(this, names, contact, imageid);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customList);
    }
    public void onClick(View v) {
        if (v == backbutton) {
            Intent i = new Intent(GiveBlood.this, HomeScreen.class);
            GiveBlood.this.startActivity(i);
            finish();
        }
    }
    public void onBackPressed() {
        this.finish();
    }


}
