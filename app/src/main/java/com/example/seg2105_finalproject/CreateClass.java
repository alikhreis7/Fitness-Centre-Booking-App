package com.example.seg2105_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class CreateClass extends AppCompatActivity {

    EditText className;
    EditText email;
    EditText description;

    Button createClass;
    Button returnAdmin;

    //FirebaseAuth authentication;
    //FirebaseFirestore firestone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        className = findViewById(R.id.ClassName);
        email = findViewById(R.id.Email);
        description = findViewById(R.id.Description);

        Button createClass = findViewById(R.id.CreateClass);
        Button returnAdmin = findViewById(R.id.returnAdmin);

        //authentication = FirebaseAuth.getInstance();
        //firestone = FirebaseFirestore.getInstance();

        returnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity((new Intent(getApplicationContext(), Admin.class)));

                finish();
            }
        });
        createClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START[extract the data from the fields]
                String userName = className.getText().toString();
                String userEmail = email.getText().toString();
                String userPassword = description.getText().toString();
                // END[extract the data from the fields]

                // START[validate the data]
                if (userName.isEmpty()) {
                    className.setError("You cannot enter an invalid class name");

                    return;
                }
                if (userEmail.isEmpty()) {
                    email.setError("You cannot enter an invalid email");

                    return;
                }
                if (userPassword.isEmpty()) {
                    description.setError("please give a brief description of the class");

                    return;
                }
                // END[validate the data]
                finish();

            }

        });

    }
}
/**
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CreateClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
    }
}**/