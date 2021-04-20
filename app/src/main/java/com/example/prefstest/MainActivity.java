package com.example.prefstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.prefstest.ValuesHolder.APP_PREFERENCES;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    ValuesHolder valuesHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        valuesHolder = new ValuesHolder(this);
    }

    public void toSave(View view){
        System.out.println(editText.getText().toString());
        //valuesHolder.saveValue(1, editText.getText().toString());
        valuesHolder.saveInt(Integer.parseInt(editText.getText().toString()));
    }

    public void toLoad(View view){
        //textView.setText(valuesHolder.loadValue(1));
        textView.setText("Integer: " + valuesHolder.loadInt());
    }
}