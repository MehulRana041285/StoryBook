package com.example.samue.interactivefamilystory.main.ui;

import android.content.Intent;
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
import com.example.samue.interactivefamilystory.main.model.Page;
import com.example.samue.interactivefamilystory.main.model.Story;


public class StoryActivity extends AppCompatActivity {

    private String name;

    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1button;
    private Button choice2button;

    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.story_image_view);
        storyTextView = (TextView) findViewById(R.id.story_text_view);
        choice1button = (Button) findViewById(R.id.next_page_button1);
        choice2button = (Button) findViewById(R.id.next_page_button2);



        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if (name == null || name.isEmpty()){
            name = "children";
        }
        Log.d(TAG,name);

        story = new Story();
        loadPage(0);


    }

    private void loadPage(int pageNumber) {
        final Page page = story.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this, page.getImageID());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextID());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);
        choice1button.setText(page.getChoice1().getmTextID());
        choice1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getmNextPage();
                loadPage(nextPage);
            }
        });
        choice2button.setText(page.getChoice2().getmTextID());
        choice2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getmNextPage();
                    loadPage(nextPage);
                }

        });

    }
}
