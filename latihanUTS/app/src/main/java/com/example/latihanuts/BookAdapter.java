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
    private ArrayList arrayId, arrayISBN, arrayJudul, arrayKategori, arrayDeskripsi, arrayHarga;

    public BookAdapter(Context ctx, ArrayList arrayId, ArrayList arrayISBN, ArrayList arrayJudul, ArrayList arrayKategori, ArrayList arrayDeskripsi, ArrayList arrayHarga) {
        this.ctx = ctx;
        this.arrayId = arrayId;
        this.arrayISBN = arrayISBN;
        this.arrayJudul = arrayJudul;
        this.arrayKategori = arrayKategori;
        this.arrayDeskripsi = arrayDeskripsi;
        this.arrayHarga = arrayHarga;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        holder.tvId.setText(arrayId.get(position).toString());
        holder.tvIsbn.setText(arrayISBN.get(position).toString());
        holder.tvJudul.setText(arrayJudul.get(position).toString());
        holder.tvKategori.setText(arrayKategori.get(position).toString());
        holder.tvDeskripsi.setText(arrayDeskripsi.get(position).toString());
        holder.tvHarga.setText(arrayHarga.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayId.size();
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
