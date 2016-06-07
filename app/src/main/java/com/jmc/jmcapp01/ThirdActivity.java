package com.jmc.jmcapp01;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends BaseActivity {

    private String [] data={"蘋果","柳丁","草莓","香蕉","大西瓜","木瓜","葡萄","火龍果","橘子","甘蔗","冰棒","哈密瓜"};

    private List<Fruit> fruitList=new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third);

        //預設的 adapter
//        ArrayAdapter <String> adapter=new ArrayAdapter<String>(
//                ThirdActivity.this, android.R.layout.simple_list_item_1, data);
//        ListView listView=(ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        initFruits();
        FruitAdapter adapter=new FruitAdapter(ThirdActivity.this, R.layout.fruit_item, fruitList);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit=fruitList.get(position);
                Toast.makeText(ThirdActivity.this, fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initFruits() {
        Fruit apple=new Fruit("蘋果", R.drawable.apple);
        fruitList.add(apple);
        Fruit banana=new Fruit("香蕉", R.drawable.banana);
        fruitList.add(banana);
        Fruit orange=new Fruit("柳橙", R.drawable.orange);
        fruitList.add(orange);
    }

}

