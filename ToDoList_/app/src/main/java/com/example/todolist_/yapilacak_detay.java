package com.example.todolist_;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class yapilacak_detay extends AppCompatActivity {
    yapilacak yapilan;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yapilacak_detay);
        Button sil = (Button) findViewById(R.id.sil);
        Context context = this;
        DataBaseHelper db = new DataBaseHelper(context);
        Intent i = getIntent();
        int id = i.getIntExtra("yapilacak",-1);
        yapilan = db.yapilacakal(id);

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.kitapSil(yapilan);
            }
        });

    }
}
