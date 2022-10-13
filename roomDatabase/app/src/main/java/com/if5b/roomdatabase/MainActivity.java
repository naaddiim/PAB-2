package com.if5b.roomdatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.if5b.roomdatabase.databinding.ActivityMainBinding;
import com.if5b.roomdatabase.db.Book;
import com.if5b.roomdatabase.loaders.InsertLoader;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    binding.btnSimpan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(validateFields()) {
                insertBook();
            }
        }
    });
    }

    private void insertBook() {
        Book book = new Book();
        book.setTitle(binding.etJudul.getText().toString());
        book.setAuthor(binding.etPenulis.getText().toString());
        book.setYear(Integer.parseInt(binding.etTahun.getText().toString()));
        showProgressBar();
        Bundle args = new Bundle();
        args.putParcelable("book", book);
        LoaderManager.getInstance(this)
                .restartLoader(0, args, new LoaderManager.LoaderCallbacks<Boolean>() {
                    @NonNull
                    @Override
                    public Loader<Boolean> onCreateLoader(int id, @Nullable Bundle args) {
                        return new InsertLoader(MainActivity.this, args.getParcelable("book"));
                    }

                    @Override
                    public void onLoadFinished(@NonNull Loader<Boolean> loader, Boolean data) {
                        hideProgressBar();
                        if(data){
                            bookInserted();
                        }
                    }

                    @Override
                    public void onLoaderReset(@NonNull Loader<Boolean> loader) {
                    }
                }).forceLoad();
    }

    private void bookInserted() {
        binding.etJudul.setText("");
        binding.etPenulis.setText("");
        binding.etTahun.setText("");
        Toast.makeText(this, "Book added to database", Toast.LENGTH_SHORT).show();
    }

    private void showProgressBar() {
        binding.pb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.pb.setVisibility(View.GONE);
    }

    private boolean validateFields() {
        if(binding.etJudul.getText().toString().equals("")||binding.etPenulis.getText().toString().equals("")
        ||binding.etTahun.getText().toString().equals("")){
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}