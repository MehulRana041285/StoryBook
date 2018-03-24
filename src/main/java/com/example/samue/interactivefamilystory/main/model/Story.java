package com.example.samue.interactivefamilystory.main.model;

import com.example.samue.interactivefamilystory.R;

/**
 * Created by samue on 3/22/2018.
 */

public class Story {

private Page [] pages;

public Story(){

    pages = new Page[7];

    pages[0] = new Page(R.drawable.daddy,
            R.string.daddy,
            new Choice(R.string.daddy_choice1, 1),
            new Choice(R.string.daddy_choice2, 3));

    pages[1] = new Page (R.drawable.mom,
            R.string.mommy,
            new Choice(R.string.mommy_choice1,2),
            new Choice(R.string.mommy_choice2,3));

    pages[2] = new Page (R.drawable.grandma2,
            R.string.grandma,
            new Choice(R.string.grandma_choice1,3),
            new Choice(R.string.grandma_choice2,5));

    pages[3] = new Page (R.drawable.grandpa,
            R.string.grandpa,
            new Choice(R.string.grandpa_choice1,2),
            new Choice(R.string.grandpa_choice2,4));

    pages[4] = new Page(R.drawable.daughter,
            R.string.sister,
            new Choice(R.string.sister_choice1,5),
            new Choice(R.string.sister_choice2,6));

    pages[5] = new Page(R.drawable.brother,
            R.string.brother,
            new Choice(R.string.brother_choice1, 4),
            new Choice(R.string.brother_choice2,6));

    pages[6] = new Page(R.drawable.baby, R.string.player);


}

    public Page getPage(int pageNumber) {
    if (pageNumber >= pages.length){
        pageNumber = 0;
    }
    return pages[pageNumber];

    }
}
