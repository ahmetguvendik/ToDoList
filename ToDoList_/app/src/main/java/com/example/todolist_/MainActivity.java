package com.example.todolist_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText yapiacak = (EditText) findViewById(R.id.editTextTextPersonName);
        Button kaydet = (Button) findViewById(R.id.ekle);
        Button goster = (Button) findViewById(R.id.goster);
        DataBaseHelper ddataBase = new DataBaseHelper(MainActivity.this);
        ListView listele = (ListView) findViewById(R.id.listele);
        Context context = this;

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yapilacak yap = new yapilacak(-1,yapiacak.getText().toString());
                boolean islem = ddataBase.yapilacakEkle(yap);
                Toast.makeText(MainActivity.this, "İşlem: " + islem, Toast.LENGTH_SHORT).show();

            }
        });

        goster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<yapilacak> item = ddataBase.yapilacakgetir();
            //    Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
               ArrayAdapter<yapilacak> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,item);
                listele.setAdapter(adapter);
            }
        });
        List<yapilacak> item = ddataBase.yapilacakgetir();
        listele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,yapilacak_detay.class);
              //  intent.putExtra("yapilacak",item.get(position).getId());
               // startActivityForResult(intent,1);
                   startActivity(intent);
            }
        });

    }


}