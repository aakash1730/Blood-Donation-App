package com.example.anujanjirwala.blooddonation;


/**
 * Created by Anuj Anjirwala on 19-Oct-16.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {  //android resource id. values is a string array from the link we provided.

        private String[] names;
        private String[] contact;
        private Integer[] imageid;
        private Activity context;

        public CustomListView(Activity context, String[] names, String[] contact, Integer[] imageid) {
            super(context, R.layout.list_layout, names);
            this.context = context;
            this.names = names;
            this.contact = contact;
            this.imageid = imageid;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //Syntax : getView(int position, View convertView, ViewGroup parent)
                                                                                //Get a View that displays the data at the specified position in the data set, viewgroups are grid/linear layouts.

            LayoutInflater inflater = context.getLayoutInflater();  //It instantiates a layout XML file into its corresponding View objects. It is never used directly. Instead, use getLayoutInflater() to retrieve a standard LayoutInflater instance that is already hooked up to the current context and correctly configured for the device you are running on.
            View listViewItem = inflater.inflate(R.layout.list_layout, null, true); //When you write an XML layout, it will be inflated by the Android OS which basically means that it will be rendered. Let's call that implicit inflation (the OS will inflate the view for you)

            TextView NameOfDonor = (TextView) listViewItem.findViewById(R.id.NameOfDonor);
            TextView ContactNumber = (TextView) listViewItem.findViewById(R.id.ContactNumber);
            ImageView image = (ImageView) listViewItem.findViewById(R.id.imageView);

            NameOfDonor.setText(names[position]);
            ContactNumber.setText(contact[position]);
            image.setImageResource(imageid[position]);

            return  listViewItem;
        }
    }

