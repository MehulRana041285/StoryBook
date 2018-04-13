package com.example.samue.interactivefamilystory.main.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.samue.interactivefamilystory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;
    private ImageButton cameraButton;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap thumbnailImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.edit_name_text);
        startButton = findViewById(R.id.start_button);

        //Set button click listener and set name to use for resource.

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = nameField.getText().toString();
               startStory(name);
            }
        });

        cameraButton = findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePictureIntent();

            }
        });

    }
    //start the story intent
    public void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        intent.putExtra("name", name);
        intent.putExtra("picture",thumbnailImage);
        startActivity(intent);

    }
    //take picture intent method.
    public void takePictureIntent(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            thumbnailImage = (Bitmap) extras.get("data");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
