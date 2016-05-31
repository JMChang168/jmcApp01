package com.jmc.jmcapp01;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jmc.jmcapp01.R;

/**
 * Created by User on 2016/5/31.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleBack=(Button) findViewById(R.id.title_back);
        Button titleEdit=(Button) findViewById(R.id.title_edit);

        titleBack.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish(); //back 關閉本活動
            }
        });

        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "你按了 Edit 鍵!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
