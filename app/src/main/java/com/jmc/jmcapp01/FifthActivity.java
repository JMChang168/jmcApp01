package com.jmc.jmcapp01;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class FifthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fifth);

        //執行save按鈕
        Button button=(Button)findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name", "張炯明");
                editor.putInt("age", 55);
                editor.putBoolean("married", true);
                editor.commit();
            }
        });

        //執行Restore按鈕
        Button buttonRestore=(Button) findViewById(R.id.buttonRestore);
        buttonRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("data", MODE_PRIVATE);
                String name=pref.getString("name","");
                int age=pref.getInt("age", 0);
                boolean married=pref.getBoolean("married",false);
                Log.d("FifthActivatity","name is:" + name);
                Log.d("FifthActivatity","age is:" + age);
                Log.d("FifthActivatity","married is:" + married);
            }
        });
    }
}
