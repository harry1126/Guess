package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    int secret = new Random().nextInt(10)+1;
    private ImageView result;
    String TAG = MainActivity.class.getSimpleName();
    private TextView guess;
    private int num;
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guess = findViewById(R.id.guess_number);
        result = findViewById(R.id.happy);
        Log.d(TAG,"secret:"+secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count= "";
                guess.setText(count);
            }
        });
    }       public void Button(View view){
                num = Integer.parseInt(guess.getText().toString());
                if(num ==secret){
                Toast.makeText(MainActivity.this,"got it",Toast.LENGTH_LONG).show();
                result.setImageResource(R.drawable.happy);
                result.setVisibility(view.VISIBLE);
                }else if (secret>num){
                Toast.makeText(MainActivity.this,"bigger",Toast.LENGTH_LONG).show();
                result.setImageResource(R.drawable.upset);
                result.setVisibility(view.VISIBLE);

                }else if (secret < num){
                    Toast.makeText(MainActivity.this,"smaller",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.upset);
                    result.setVisibility(view.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
