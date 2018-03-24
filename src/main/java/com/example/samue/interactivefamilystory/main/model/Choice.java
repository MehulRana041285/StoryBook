package com.example.samue.interactivefamilystory.main.model;

/**
 * Created by samue on 3/22/2018.
 */

public class Choice {

    int mTextID;
    int mNextPage;

    public Choice(int textID, int nextPage ){
        mTextID = textID;
        mNextPage = nextPage;
    }

    public int getmTextID() {
        return mTextID;
    }

    public void setmTextID(int mTextID) {
        this.mTextID = mTextID;
    }

    public int getmNextPage() {
        return mNextPage;
    }

    public void setmNextPage(int mNextPage) {
        this.mNextPage = mNextPage;
    }
}
