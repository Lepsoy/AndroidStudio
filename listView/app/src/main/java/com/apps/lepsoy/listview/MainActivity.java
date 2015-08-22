package com.apps.lepsoy.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] foods = {"Bacon", "Ham", "Cheese", "Pizza", "Taco"};
        ListAdapter myAdapter = new CustomAdapter(this, foods);
        //ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods); // Converts array items into list items
        ListView lepsoysListView = (ListView)findViewById(R.id.lepsoysListView);
        lepsoysListView.setAdapter(myAdapter);

        lepsoysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    //Parent is the list, position tells which button was pressed in that list.
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }



}
