package com.teamtreehouse.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teamtreehouse.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = (EditText) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                // to refer this to the main class not onClick method
//                Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                startStory(name);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        //The intent of this Intent is to start another Activity.
        Intent intent = new Intent(this, StoryActivity.class);
        // to get accessing Resources
        Resources resources = getResources();
        // to store the string we
        String key = resources.getString(R.string.key_name);
        // intent can be used to transfer data like the name entered in the main activity
        intent.putExtra(key, name);
        // to start out another activity
        startActivity(intent);

    }
}
