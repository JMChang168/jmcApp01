package com.jmc.jmcapp01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

//定義父活動傳遞過來的參數值
//    public static void actionStart(Context context, String data1, String data2){
//        Intent intent=new Intent(context, SecondActivity.class);
//        intent.putExtra("param1",data1);
//        intent.putExtra("param2",data2);
//        context.startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second);

        //第一頁傳過來的訊息
        final TextView textView=(TextView) findViewById(R.id.textView_02_03);
        Intent intent=getIntent(); //取得第一頁的 intent
        String data=intent.getStringExtra("extra_data");
        textView.setText(data);

        //返回按鈕
        Button btn_02_01= (Button) findViewById(R.id.button_02_01);
        btn_02_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回第二頁資料回上一頁
                final EditText editText=(EditText) findViewById(R.id.editText_02_01);
                Intent intent=new Intent();
                intent.putExtra("data_return",editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    //按系統返回鍵
    @Override
    public void onBackPressed() {
        final EditText editText=(EditText) findViewById(R.id.editText_02_01);
        Intent intent=new Intent();
        intent.putExtra("data_return",editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
