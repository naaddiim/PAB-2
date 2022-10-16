package com.if5b.roomdatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.if5b.roomdatabase.databinding.ActivityShowDataBinding;
import com.if5b.roomdatabase.db.Book;
import com.if5b.roomdatabase.loaders.GetBookLoader;

import java.util.List;

public class ShowDataActivity extends AppCompatActivity {
    public static final int DATA_LOADER_CODE = 122;
    ActivityShowDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getBook();
    }

    private void getBook() {
        showProgressBar();
        LoaderManager.getInstance(this).restartLoader(DATA_LOADER_CODE, null, new LoaderManager.LoaderCallbacks<List<Book>>() {

            @NonNull
            @Override
            public Loader<List<Book>> onCreateLoader(int id, @Nullable Bundle args) {
                return new GetBookLoader(ShowDataActivity.this);
            }

            @Override
            public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> data) {
                hideProgressBar();
                initAdapter(data);
            }

            @Override
            public void onLoaderReset(@NonNull Loader<List<Book>> loader) {

            }
        }).forceLoad();
        hideProgressBar();
    }

    private void initAdapter(List<Book> data) {
        BookAdapter bookAdapter = new BookAdapter(this, data);
        binding.rvBook.setLayoutManager(new LinearLayoutManager(this));
        binding.rvBook.setAdapter(bookAdapter);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}