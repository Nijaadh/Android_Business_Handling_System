package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.util.DbConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Call the database connection method from DbConnection
        DbConnection.connectToDb(this);

        // Optional: Use the connection later if needed
        if (DbConnection.getConnection() != null) {
            // You can perform database queries here using the connection
        }
    }
}
