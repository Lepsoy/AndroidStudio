package com.lepsoy.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText lepsoysInput;
    TextView lepsoysText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lepsoysInput = (EditText)findViewById(R.id.lepsoysInput);
        lepsoysText = (TextView)findViewById(R.id.lepsoysText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addClick(View view){
        Products product = new Products(lepsoysInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete a product from the database
    public void deleteClick(View view){
        String inputText = lepsoysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        lepsoysText.setText(dbString);
        lepsoysInput.setText("");
    }


}
