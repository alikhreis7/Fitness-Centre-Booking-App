package com.example.seg2105_finalproject;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Member extends AppCompatActivity {

    TextView idView;
    EditText ClassesBox;
    EditText TimeBox;
    ListView Classeslist;
    ArrayList<String> listItem;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idView = (TextView) findViewById(R.id.ClassesID);
        ClassesBox = (EditText) findViewById(R.id.ClassesName);
        TimeBox = (EditText) findViewById(R.id.ClassesTime);
        Classeslist = (ListView) findViewById(R.id.ClassesListView);

        DB_handler dbHandler = new DB_handler (this);
        listItem = new ArrayList <>();

        viewData();

        Classeslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String text = Classeslist.getItemAtPosition(i).toString();
                Toast.makeText(Member.this, ""+text, Toast.LENGTH_SHORT).show();

            }
        });
    }



    public void newClasses (View view) {

        DB_handler dbHandler = new DB_handler (this);
        double price = Double.parseDouble(TimeBox.getText().toString());
        Classes classes = new Classes(ClassesBox.getText().toString(), price);
        dbHandler.addClasses(classes);
        ClassesBox.setText("");
        TimeBox.setText("");
        listItem.clear();
        viewData();

    }


    public void lookupClasses (View view) {

       DB_handler dbHandler= new DB_handler(this);
        Classes classes= dbHandler.findClasses(ClassesBox.getText().toString());
        if (classes != null) {
            idView.setText(String.valueOf(classes.getID()));
            TimeBox.setText(String.valueOf(classes.getTime()));
        } else {
            idView.setText("No Match Found");
        }
    }


    public void removeClasses (View view) {

        DB_handler dbHandler = new DB_handler(this);
        boolean result = dbHandler.deleteClasses(ClassesBox.getText().toString());
        listItem.clear();
        viewData();

        if (result) {
            idView.setText("Record Deleted");
            ClassesBox.setText("");
            TimeBox.setText("");
        } else {
            idView.setText("No Match Found");
        }
    }
    private void viewData() {
        DB_handler dbHandler = new DB_handler(this);
        Cursor cursor = dbHandler.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Not data to show", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()) {
                listItem.add(cursor.getString(1));
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);

            Classeslist.setAdapter(adapter);
        }
    }
}
/**
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Member extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
    }
}**/