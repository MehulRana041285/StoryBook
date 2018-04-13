package com.example.samue.interactivefamilystory.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.samue.interactivefamilystory.R;
import com.example.samue.interactivefamilystory.main.model.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samue on 3/30/2018.
 */

public class StoryAdapter extends ArrayAdapter<Page> {

    private Context mContext;
    private List<Page> pageList = new ArrayList<>();

    public StoryAdapter(@NonNull Context context, ArrayList<Page> list) {
        super(context,0,list);
        mContext = context;
        pageList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null){
            listItem = LayoutInflater.from(mContext)
                    .inflate(R.layout.activity_end_story1,parent,false);
        }

        Page currentPage = pageList.get(position);

        ImageView currentImage = listItem.findViewById(R.id.icon_image);
        currentImage.setImageResource(currentPage.getImageID());

        TextView currentText = listItem.findViewById(R.id.text_icon);
        currentText.setText(currentPage.getTextID());



        return listItem;
    }
}
