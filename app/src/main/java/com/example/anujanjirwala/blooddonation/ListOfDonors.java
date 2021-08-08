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

public class ListOfDonors extends Activity implements View.OnClickListener {
    ImageView backbutton;
    ListView listView;
    private String names[] = {
            "Raj Patel",
            "Yash Patel",
            "Akash Patel",
            "Meet Patel",
            "Viren Rakholiya"
    };

    private String contact[] = {
            "+919442143214",
            "+919889242858",
            "+918933245312",
            "+917928365832",
            "+917036372817"
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
        listView = (ListView) findViewById(R.id.listView);

        backbutton.setOnClickListener(this);

        CustomListView customList = new CustomListView(this, names, contact, imageid);

        listView.setAdapter(customList);
    }
    public void onClick(View v) {
         if (v == backbutton) {
             Intent i = new Intent(ListOfDonors.this, FindDonor.class);
             ListOfDonors.this.startActivity(i);
             finish();
         }
    }
    public void onBackPressed() {
        this.finish();
    }
}