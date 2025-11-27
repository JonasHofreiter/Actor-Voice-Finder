package com.example.voiceactorfinder;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonFindVA = (Button) findViewById(R.id.find_VA_Button);
        buttonFindVA.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Log.d("BUTTONS", "User tapped Finde deinen Synchronsprecher");
                Intent intent =  new Intent(getBaseContext(), finde_Synchronsprecher.class);
                startActivity(intent );
            }
        });

        Button buttonEditFav = (Button) findViewById(R.id.editFav);
        buttonEditFav.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Log.d("BUTTONS", "User Tapped Favoriten bearbeiten");
                Intent intent =  new Intent(getBaseContext(), activity_favoriten_bearbeiten.class);
                startActivity(intent );
            }
        });
    }

}