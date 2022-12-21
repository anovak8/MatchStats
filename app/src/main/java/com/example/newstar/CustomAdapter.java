package com.example.newstar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private ArrayList match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni, domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p;

    CustomAdapter(Context context, ArrayList match_id, ArrayList domaci, ArrayList gosti, ArrayList domaci_goli, ArrayList gosti_goli, ArrayList domaci_rumeni,ArrayList gosti_rumeni, ArrayList domaci_rdeci, ArrayList gosti_rdeci, ArrayList domaci_streli, ArrayList gosti_streli, ArrayList domaci_p, ArrayList gosti_p){
        this.context = context;
        this.match_id = match_id;
        this.domaci = domaci;
        this.gosti = gosti;
        this.domaci_goli = domaci_goli;
        this.gosti_goli = gosti_goli;
        this.domaci_rumeni = domaci_rumeni;
        this.gosti_rumeni = gosti_rumeni;
        this.domaci_rdeci = domaci_rdeci;
        this.gosti_rdeci = gosti_rdeci;
        this.domaci_streli = domaci_streli;
        this.gosti_streli = gosti_streli;
        this.domaci_p = domaci_p;
        this.gosti_p = gosti_p;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.match_id_txt.setText(String.valueOf(match_id.get(position)));
        holder.domaci_txt.setText(String.valueOf(domaci.get(position)));
        holder.gosti_txt.setText(String.valueOf(gosti.get(position)));
        holder.d_gol_txt.setText(String.valueOf(domaci_goli.get(position)));
        holder.g_gol_txt.setText(String.valueOf(gosti_goli.get(position)));
        holder.d_ru_txt.setText(String.valueOf(domaci_rumeni.get(position)));
        holder.g_ru_txt.setText(String.valueOf(gosti_rumeni.get(position)));
        holder.d_r_txt.setText(String.valueOf(domaci_rdeci.get(position)));
        holder.g_r_txt.setText(String.valueOf(gosti_rdeci.get(position)));
        holder.d_streli.setText(String.valueOf(domaci_streli.get(position)));
        holder.g_streli.setText(String.valueOf(gosti_streli.get(position)));
        holder.d_p.setText(String.valueOf(domaci_p.get(position)));
        holder.g_p.setText(String.valueOf(gosti_p.get(position)));
    }

    @Override
    public int getItemCount() {
        return match_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView match_id_txt, domaci_txt, gosti_txt, d_gol_txt, g_gol_txt, d_ru_txt, g_ru_txt, d_r_txt, g_r_txt, d_streli, g_streli, d_p, g_p;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            match_id_txt = itemView.findViewById(R.id.match_id_txt);
            domaci_txt = itemView.findViewById(R.id.domaci_txt);
            gosti_txt= itemView.findViewById(R.id.gosti_txt);
            d_gol_txt = itemView.findViewById(R.id.d_gol_txt);
            g_gol_txt = itemView.findViewById(R.id.g_gol_txt);
            d_ru_txt = itemView.findViewById(R.id.d_ru_txt);
            g_ru_txt = itemView.findViewById(R.id.g_ru_txt);
            d_r_txt = itemView.findViewById(R.id.d_r_txt);
            g_r_txt = itemView.findViewById(R.id.g_r_txt);
            d_streli = itemView.findViewById(R.id.d_streli);
            g_streli = itemView.findViewById(R.id.g_streli);
            d_p = itemView.findViewById(R.id.d_p);
            g_p = itemView.findViewById(R.id.g_p);
        }
    }
}
