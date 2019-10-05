package com.espelita.practicalexam2_espelitamorris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FileInputStream reader = null;
        try {
            reader = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = reader.read()) != -1){
                temp = temp + ((char)token);
            }
            try {
                String[] list = temp.split("_");
                try {
                    ((TextView) (findViewById(R.id.textView5))).setText(list[0]);
                    ((TextView) (findViewById(R.id.textView6))).setText(list[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reader.close();
            } catch (FileNotFoundException e) {
                Log.d("error", "file not found...");
            } catch (IOException e) {
                Log.d("error", "IO error...");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(View view) {
        Toast.makeText(this, "registration sent...", Toast.LENGTH_SHORT).show();
    }

    public void previousPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
