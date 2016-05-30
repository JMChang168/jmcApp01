package com.jmc.jmcapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        Button btn_02_01= (Button) findViewById(R.id.button_02_01);
        final TextView textView1=(TextView) findViewById(R.id.editText_02_01);
        final TextView textView2=(TextView) findViewById(R.id.editText_02_02);

        btn_02_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=getIntent();
                String data=intent1.getStringExtra("extra_data");
                Log.d("SecondActivity", data);
                textView1.setText(data);


                //返回第二頁資料到上一頁
                Intent intent2=new Intent();
                intent2.putExtra("data_return",textView2.toString());
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }
}
