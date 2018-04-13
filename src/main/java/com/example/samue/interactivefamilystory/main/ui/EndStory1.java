package com.example.samue.interactivefamilystory.main.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.samue.interactivefamilystory.R;
import com.example.samue.interactivefamilystory.main.StoryAdapter;
import com.example.samue.interactivefamilystory.main.model.Page;

import java.util.ArrayList;

public class EndStory1 extends AppCompatActivity {

    private GridView gridView;
    private StoryAdapter mStoryAdapter;
    private Button readAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_grid);

        gridView = (GridView) findViewById(R.id.grid_list);
        ArrayList<Page> pages = new ArrayList<>();

        pages.add(new Page(R.drawable.daddy,
                R.string.daddy_last_page));

        pages.add(new Page(R.drawable.mom,
                R.string.mommy_last_page));

        pages.add(new Page(R.drawable.grandpa, R.string.grandpa_last_page));

        pages.add(new Page(R.drawable.grandma2, R.string.grandma_last_page));

        pages.add(new Page(R.drawable.brother, R.string.brother_last_page));

        pages.add(new Page(R.drawable.daughter, R.string.sister_last_page));

        pages.add(new Page(R.drawable.baby,R.string.player_last_page));


        mStoryAdapter = new StoryAdapter(this,pages);
        gridView.setAdapter(mStoryAdapter);

        readAgainButton = (Button) findViewById(R.id.readAgain);

        readAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
