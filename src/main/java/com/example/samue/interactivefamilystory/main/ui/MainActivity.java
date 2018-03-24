package com.example.samue.interactivefamilystory.main.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.samue.interactivefamilystory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.edit_name_text);
        startButton = (Button) findViewById(R.id.start_button);

        //Set button click listener and set name to use for resource.

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = nameField.getText().toString();
               startStory(name);
            }
        });

    }

    public void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        intent.putExtra("name", name);
        startActivity(intent);

    }

}
