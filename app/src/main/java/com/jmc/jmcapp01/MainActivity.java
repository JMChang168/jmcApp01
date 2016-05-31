package com.jmc.jmcapp01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Button button_01_01 = (Button) findViewById(R.id.button_01_01);
        button_01_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "開啟第二頁 !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com.tw"));
                startActivity(intent);
            }
        });


        Button button_01_02 = (Button) findViewById(R.id.button_01_02);
        final EditText editText1=(EditText) findViewById(R.id.editText_01_01);
        final TextView textView=(TextView)findViewById(R.id.textView_01_02);
        button_01_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data =editText1.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("extra_data", data);

                //要求回傳值
                startActivityForResult(intent, 1);
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
