package com.example.samue.interactivefamilystory.main.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samue.interactivefamilystory.R;
import com.example.samue.interactivefamilystory.main.model.Choice;
import com.example.samue.interactivefamilystory.main.model.Page;
import com.example.samue.interactivefamilystory.main.model.Story;

import java.util.Stack;


public class StoryActivity extends AppCompatActivity {

    private String name;
    private Bitmap usersPicture = null;

    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1button;
    private Button choice2button;
    private Stack<Integer> pageStack = new Stack<Integer>();

    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.story_image_view);
        storyTextView = findViewById(R.id.story_text_view);
        choice1button = findViewById(R.id.next_page_button1);
        choice2button = findViewById(R.id.next_page_button2);



        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if (name == null || name.isEmpty()){
            name = "Baby";
        }
        Log.d(TAG,name);
        //get picture from mainactivity.
        usersPicture = intent.getExtras().getParcelable("picture");

        story = new Story();
        loadPage(0);


    }

    private void loadPage(int pageNumber) {

        //build pagestack to navigate pages.
        pageStack.push(pageNumber);

        final Page page = story.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this, page.getImageID());
        storyImageView.setImageDrawable(image);

        //get string from page then set the format special characters to name taken from edit text.
        String pageText = getString(page.getTextID());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);


        if (page.isFinalPage()) {
            if (usersPicture == null) {
                storyImageView.setImageResource(R.drawable.baby);
            } else {

                storyImageView.setImageBitmap(usersPicture);
            }
            choice1button.setVisibility(View.INVISIBLE);
            choice2button.setText("I see...");
            loadLastPage();

        }else if(page.isEndStory()) {



        }else {

            loadButtons(page);
        }

    }

    private void loadLastPage() {

        choice2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(StoryActivity.this, EndStory1.class);
                startActivity(intent);
            }
        });

    }

    private void loadButtons(final Page page) {
        String buttonText = getString(page.getChoice1().getmTextID());
        buttonText = String.format(buttonText,name);
        choice1button.setText(buttonText);
        choice1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getmNextPage();
                loadPage(nextPage);
            }
        });
        String buttonText2 = getString(page.getChoice2().getmTextID());
        buttonText2 = String.format(buttonText2, name);
        choice2button.setText(buttonText2);
        choice2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getmNextPage();
                loadPage(nextPage);
            }

        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()) {
            super.onBackPressed();
        } else {
            loadPage(pageStack.pop());
        }
    }
}
