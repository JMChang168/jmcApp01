package com.jmc.jmcapp01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first);

        Button button_01_01 = (Button) findViewById(R.id.button_01_01);
        button_01_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "開啟第二頁 !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com.tw"));
                startActivity(intent);
            }
        });

        //開啟第二頁
        Button button_01_02 = (Button) findViewById(R.id.button_01_02);
        button_01_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText1=(EditText) findViewById(R.id.editText_01_01);
                final TextView textView=(TextView)findViewById(R.id.textView_01_02);
                String data =editText1.getText().toString();


                //傳遞參數給 SecondActivity
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);

                //要求回傳值的呼叫
                startActivityForResult(intent, 1);
            }
        });

        //開啟第三頁
        Button btnListView=(Button) findViewById(R.id.button_ListView);
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });


        //開啟第四頁
        Button button_01_04=(Button) findViewById(R.id.button_01_04);
        button_01_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });


        //開啟第五頁
        Button buttonSharedPref=(Button) findViewById(R.id.buttonSharedPref);
        buttonSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,FifthActivity.class);
                startActivity(intent);
            }
        });


        //開啟登入頁
        Button buttonLogin=(Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SixthActivity.class);
                startActivity(intent);
            }
        });


    }


    //處理第二頁的回傳數據
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        TextView textView=(TextView) findViewById(R.id.textView_01_02);

        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    textView.setText(returnedData);
                }
                break;
            default:
        }
    }
}
