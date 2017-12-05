package com.earl.labexerno4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etParagraph;
    TextView tvDisplay;
    Button btn_save, btn_clear, btn_display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etParagraph = findViewById(R.id.paragraph);
        tvDisplay = findViewById(R.id.displayData);
        btn_save = findViewById(R.id.save);
        btn_clear = findViewById(R.id.clear);
        btn_display = findViewById(R.id.display);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveToSharedPreferences (View view ) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("paragraph", etParagraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data saved in Shared Preferences!", Toast.LENGTH_SHORT).show();

    }

    public void clearData (View view) {
        etParagraph.setText(null);
        tvDisplay.setText(null);
    }

    public void displaySharedPreferences (View view) {
        String data = preferences.getString("paragraph", "");
        tvDisplay.setText(data);
    }
}
