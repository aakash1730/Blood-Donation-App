package com.example.anujanjirwala.blooddonation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Anuj Anjirwala on 13-Sep-16.
 */
public class FindDonor extends Activity implements View.OnClickListener {
    ImageView backbutton;
    Button ab1,ab2,a1,a2,b1,b2,o1,o2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_screen);

        backbutton=(ImageView)findViewById(R.id.back) ;
        ab1=(Button) findViewById(R.id.abplus) ;
        ab2=(Button) findViewById(R.id.abnegative) ;
        a1=(Button) findViewById(R.id.apositive) ;
        a2=(Button) findViewById(R.id.anegative) ;
        o1=(Button)findViewById(R.id.opositive) ;
        o2=(Button)findViewById(R.id.onegative) ;
        b1=(Button) findViewById(R.id.bpositive) ;
        b2=(Button) findViewById(R.id.bnegative) ;

        backbutton.setOnClickListener(this);
        ab1.setOnClickListener(this);
        ab2.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        o1.setOnClickListener(this);
        o2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v == backbutton)  {
            Intent i = new Intent(FindDonor.this, HomeScreen.class);
            FindDonor.this.startActivity(i);
            finish();
        }
        else if (v==ab1 || v==ab2 || v==a1 || v==b1 || v==a2 || v==b2 || v==o1 || v==o2)  {
            Intent i = new Intent(FindDonor.this, ListOfDonors.class);
            FindDonor.this.startActivity(i);
        }

    }
    public void onBackPressed() {
        this.finish();
    }
}
