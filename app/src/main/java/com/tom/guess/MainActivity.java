package com.tom.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    int secret;
    private ImageView result;
    private TextView guess;
    private int num;
    private TextView information;
    int counter;
    private TextView edcounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guess = findViewById(R.id.guess_number);
        result = findViewById(R.id.result_image);
        information = findViewById(R.id.information);
        edcounter = findViewById(R.id.counter);
        secret = new Random().nextInt(10)+1;
        Log.d(TAG,"secret:"+secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
            public void reset(){
                counter = 0;
                edcounter.setText(counter+"");
                guess.setText("");
                result.setVisibility(View.GONE);
                information.setText("");
                secret = new Random().nextInt(10)+1;
            }
             public void Button(View view){
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     reset();
                 }
             };
                counter++;
                edcounter.setText(counter+"");
                num = Integer.parseInt(guess.getText().toString());
                if(num == secret){
                    information.setText("got it !");
                    //Toast.makeText(MainActivity.this,"got it",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.happy);
                    result.setVisibility(view.VISIBLE);
                    information.setText("猜了"+String.valueOf(counter)+"次答對");
                    new  AlertDialog.Builder(MainActivity.this)
                            .setTitle("Got it")
                            .setMessage("Bingo")
                            .setPositiveButton("Ok",listener)
                            .show();
                } else if (secret > num){
                    information.setText("bigger !");
                    //Toast.makeText(MainActivity.this,"bigger",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.upset);
                    result.setVisibility(view.VISIBLE);
                    new  AlertDialog.Builder(MainActivity.this)
                            .setTitle("Got it")
                            .setMessage("Bingo")
                            .setPositiveButton("Ok",listener)
                            .show();
                    listener = null;
                }else if (secret < num){
                    information.setText("smaller !");
                    //Toast.makeText(MainActivity.this,"smaller",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.upset);
                    result.setVisibility(view.VISIBLE);
                    listener = null;
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
