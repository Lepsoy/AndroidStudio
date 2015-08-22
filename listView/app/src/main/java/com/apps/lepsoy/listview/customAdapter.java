package com.apps.lepsoy.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row, foods); //alt+insert, constructor and replace
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater lepsoysInflater = LayoutInflater.from(getContext());
        View customView = lepsoysInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView lepsoysText = (TextView) customView.findViewById(R.id.lepsoysText);
        ImageView lepsoysImage = (ImageView) customView.findViewById(R.id.lepsoysImage);

        lepsoysText.setText(singleFoodItem);
        lepsoysImage.setImageResource(R.drawable.fb1);

        return customView;
    }
}
