package com.example.acer.billgenerator;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.io.File;

public class MainActivity extends Activity implements TabFragment2.OnFragmentInteractionListener {

    SQLiteDatabase contactsDB = null;

    Button addContactButton, deleteContactButton;
    EditText nameEditText, deleteEditText;
    TextView displayNames;
    String nowes;
    static int totals=0;
    ActionBar.Tab tab1, tab2, tab3;

    Fragment fragment1= new TabFragment1();
    Fragment fragment2= new TabFragment2();
    Fragment fragment3= new TabFragment3();


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        tab1 = actionBar.newTab().setText("Introduction");
        tab2 = actionBar.newTab().setText("Add People");
        tab3 = actionBar.newTab().setText("Add Amount");


        tab1.setTabListener(new TabListener(fragment1));
        tab2.setTabListener(new TabListener(fragment2));
        tab3.setTabListener(new TabListener(fragment3));


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        addContactButton=(Button)findViewById(R.id.addButton);
       // deleteContactButton=(Button)findViewById(R.id.deleteButton);
        nameEditText=(EditText)findViewById(R.id.enterName);
        deleteEditText=(EditText)findViewById(R.id.deleteName);
        displayNames=(TextView)findViewById(R.id.amountDisplay);



    }



    @Override
    public void onFragmentInteraction(String userContent, String amountContent) {
        nowes=userContent;
        int foo=0;
        try {
            foo = Integer.parseInt(amountContent);
        } catch (NumberFormatException e) {
            foo=0;
        }
        // foo = Integer.parseInt(amountContent);
        totals= totals+foo;
       // Toast.makeText(this, nowes+" Got it!", Toast.LENGTH_SHORT).show();

        if(contactsDB==null) {
            contactsDB = this.openOrCreateDatabase("MyContacts.db", MODE_PRIVATE, null);
            contactsDB.execSQL("CREATE TABLE IF NOT EXISTS contacts " +
                    "(id integer primary key, name VARCHAR);");
           // contactName = "komal";
            File database = getApplicationContext().getDatabasePath("MyContacts.db");

            // Check if the database exists
            if (database.exists()) {
                Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Database Missing", Toast.LENGTH_SHORT).show();
            }

            contactsDB.execSQL("INSERT INTO contacts (name) VALUES ('" +
                    userContent + "');");
        }
        else {
            contactsDB.execSQL("INSERT INTO contacts (name) VALUES ('" +
                    nowes + "');");
        }

    }

    public String getMyData() {
        // A Cursor provides read and write access to database results

        if(contactsDB!=null) {
            Cursor cursor = contactsDB.rawQuery("SELECT * FROM contacts", null);
          //  contactsDB.execSQL("DELETE * FROM contacts");

            // Get the index for the column name provided
            int idColumn = cursor.getColumnIndex("id");
            int nameColumn = cursor.getColumnIndex("name");

            // Move to the first row of results
            cursor.moveToFirst();

            String contactList = "";

            // Verify that we have results
            if (cursor != null && (cursor.getCount() > 0)) {

                do {
                    // Get the results and store them in a String
                    String id = cursor.getString(idColumn);
                    String name = cursor.getString(nameColumn);

                    contactList = contactList + id + " : " + name + "\n";

                    // Keep getting results as long as they exist
                } while (cursor.moveToNext());

                // displayNames.setText(contactList);
                cursor.close();
               // contactList = "";
                return contactList;



            } else {

                Toast.makeText(this, "No Results to Show", Toast.LENGTH_SHORT).show();
                contactList = "";
                // displayNames.setText("Yellow");
                return "No database available";

            }
           // cursor.close();
        }
        return "No database available";
       // cursor.close();
    }

    public String getMyData1()
    {
        String foo= ""+totals;
        return foo;
    }

    @Override
    protected void onDestroy() {

        contactsDB.close();

        super.onDestroy();
    }

}


