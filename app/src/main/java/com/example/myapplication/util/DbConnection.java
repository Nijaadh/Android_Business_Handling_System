package com.example.myapplication.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DbConnection {

    private static Connection conn = null;
    private static final String CLASSES = "net.sourceforge.jtds.jdbc.Driver";
    private static final String URL = "sql12.freesqldatabase.com";
    private static final String PORT = "3306";
    private static final String DB = "sql12748351";
    private static final String USERNAME = "sql12748351";
    private static final String PASSWORD = "Shx8sttKTE";

    public static void connectToDb(Context context) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                // Attempt to establish a connection
                Class.forName("com.mysql.jdbc.Driver");
                String connUrl = "jdbc:mysql://" + URL + ":" + PORT + "/" + DB;
                conn = DriverManager.getConnection(connUrl, USERNAME, PASSWORD);

                // Notify the result via Toast
                String message = (conn == null) ? "Error in connection" : "Connected to SQL server";
                //showToast(context, message);

            } catch (Exception e) {
                String errorMessage = "Connection failed: " + e.getMessage();
                Log.e("SQL_ERROR", errorMessage);
                showToast(context, errorMessage);
            }
        });
    }

    private static void showToast(Context context, String message) {
        // Ensure the Toast is shown on the main thread
        //new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
    }

    public static Connection getConnection() {
        return conn; // Return the connection object
    }
}
