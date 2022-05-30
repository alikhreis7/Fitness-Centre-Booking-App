package com.example.seg2105_finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Admin extends AppCompatActivity {

    private static final String TAG = "Admin";
    ProgressDialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button signoutBtn = findViewById(R.id.adminSignout);
        Button AdminCreateClass = findViewById(R.id.adminCreateClass);
        Button deletebtn = findViewById(R.id.adminDelete);
        EditText users = findViewById(R.id.adminEmail);
        dialog=new ProgressDialog(this);



        signoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity((new Intent(getApplicationContext(),LoginActivity.class)));

                finish();
            }
        });

        AdminCreateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START[go to register page]
                startActivity(new Intent(getApplicationContext(), CreateClass.class));
                // END[go to register page]
            }
        });



    }

   // public void deactivate(View v){


    //}

}
/**
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
}**/