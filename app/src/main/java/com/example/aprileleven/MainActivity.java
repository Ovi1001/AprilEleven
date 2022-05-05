package com.example.aprileleven;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int numAstro = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void upClick(View v)
    {
        Toast.makeText(this, "You clicked the up button", Toast.LENGTH_SHORT).show();
        numAstro++;
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        updateTextView();

        //Log.i("info", "Testing info button 1");
    }//end up count button handler

    public void downClick(View v)
    {
        Toast.makeText(this, "You clicked the bottom button", Toast.LENGTH_SHORT).show();
        numAstro--;
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        updateTextView();
        //Log.i("info", "Testing info button 2");
    }//end down count button handler

    public void openDialog(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reset?");
        builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
               numAstro = 0;
               //need to update text again
               updateTextView();
            }//end onClick overriden    
        });//end set positive or "Yes" button handler

        builder.setNegativeButton("aint no way", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Method is empty because all it needs to do is close the dialog
            }//end onClick
        });//end set negative button

        AlertDialog resetDialog = builder.create();
        resetDialog.show();
    }//end open reset dialog handler

    public void updateTextView()
    {
        TextView countTextView = (TextView) findViewById(R.id.countLabelView);
        countTextView.setText("Number of Astronauts: " + numAstro);
    }
}//end mainActivity class