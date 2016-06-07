package com.jmc.jmcapp01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 2016/5/31.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int postition, View convertView, ViewGroup parent){

        Fruit fruit=getItem(postition); //獲取當前的 Fruit 實例

        View view;
        ViewHolder viewHolder;

        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder=new ViewHolder();
            viewHolder.fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName=(TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//將viewHolder 存在view中
        } else {
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();//重新獲取ViewHolder
        }
//        ImageView fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName=(TextView) view.findViewById(R.id.fruit_name);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }

}
