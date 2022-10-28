package com.example.latihanuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.latihanuts.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BookAdapter bookAdapter;
    DatabaseHelper databaseHelper;
    ArrayList<String> arrayid, arrayIsbn, arrayJudul, arrayDeskripsi, arrayKategori, arrayHarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(MainActivity.this);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });



    }

    private void getAllData() {
        Cursor cursor = databaseHelper.getAllBook();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "Data buku tidak ada", Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()) {
                arrayid.add(cursor.getString(0));
                arrayIsbn.add(cursor.getString(1));
                arrayJudul.add(cursor.getString(2));
                arrayDeskripsi.add(cursor.getString(3));
                arrayKategori.add(cursor.getString(4));
                arrayHarga.add(cursor.getString(5));
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayid = new ArrayList<>();
        arrayHarga = new ArrayList<>();
        arrayKategori = new ArrayList<>();
        arrayIsbn = new ArrayList<>();
        arrayDeskripsi = new ArrayList<>();
        arrayJudul = new ArrayList<>();
        getAllData();
        bookAdapter = new BookAdapter(MainActivity.this, arrayid, arrayIsbn, arrayJudul, arrayKategori, arrayDeskripsi, arrayHarga);
        binding.rvBook.setAdapter(bookAdapter);
        binding.rvBook.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
}