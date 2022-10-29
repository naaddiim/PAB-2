package com.example.latihanuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context ctx;
    private ArrayList<Book> arrayBook;
//    private ArrayList arrayId, arrayIsbn, arrayJudul, arrayKategori, arrayDeskripsi, arrayHarga;

    public BookAdapter(Context ctx, ArrayList<Book> arrayBook) {
        this.ctx = ctx;
        this.arrayBook = arrayBook;
//        this.arrayId = arrayId;
//        this.arrayIsbn = arrayIsbn;
//        this.arrayJudul = arrayJudul;
//        this.arrayKategori = arrayKategori;
//        this.arrayDeskripsi = arrayDeskripsi;
//        this.arrayHarga = arrayHarga;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        holder.tvId.setText(arrayBook.get(position).getId());
        holder.tvIsbn.setText(arrayBook.get(position).getIsbn());
        holder.tvJudul.setText(arrayBook.get(position).getJudul());
        holder.tvKategori.setText(arrayBook.get(position).getKategori());
        holder.tvDeskripsi.setText(arrayBook.get(position).getDeskripsi());
        holder.tvHarga.setText(arrayBook.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return arrayBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvIsbn, tvJudul, tvKategori, tvDeskripsi, tvHarga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvIsbn = itemView.findViewById(R.id.tvISBN);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            tvHarga = itemView.findViewById(R.id.tvHarga);
        }
    }
}
