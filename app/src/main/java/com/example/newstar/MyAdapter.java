package com.example.newstar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private Context context;
    private ArrayList match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni,
            domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p;

    public MyAdapter(Context context, ArrayList match_id, ArrayList domaci, ArrayList gosti, ArrayList domaci_goli, ArrayList gosti_goli, ArrayList domaci_rumeni, ArrayList gosti_rumeni, ArrayList domaci_rdeci, ArrayList gosti_rdeci, ArrayList domaci_streli, ArrayList gosti_streli, ArrayList domaci_p, ArrayList gosti_p) {
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
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.match_id.setText(String.valueOf(match_id.get(position)));
        holder.domaci.setText(String.valueOf(domaci.get(position)));
        holder.gosti.setText(String.valueOf(gosti.get(position)));
        holder.domaci_goli.setText(String.valueOf(domaci_goli.get(position)));
        holder.gosti_goli.setText(String.valueOf(gosti_goli.get(position)));
        holder.domaci_rumeni.setText(String.valueOf(domaci_rumeni.get(position)));
        holder.gosti_rumeni.setText(String.valueOf(gosti_rumeni.get(position)));
        holder.domaci_rdeci.setText(String.valueOf(domaci_rdeci.get(position)));
        holder.gosti_rdeci.setText(String.valueOf(gosti_rdeci.get(position)));
        holder.domaci_streli.setText(String.valueOf(domaci_streli.get(position)));
        holder.gosti_streli.setText(String.valueOf(gosti_streli.get(position)));
        holder.domaci_p.setText(String.valueOf(domaci_p.get(position)));
        holder.gosti_p.setText(String.valueOf(gosti_p.get(position)));

    }

    @Override
    public int getItemCount() {
        return domaci.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni, domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            match_id = itemView.findViewById(R.id.match_id);
            domaci = itemView.findViewById(R.id.domaci);
            gosti = itemView.findViewById(R.id.gosti);
            domaci_goli = itemView.findViewById(R.id.d_gol);
            gosti_goli = itemView.findViewById(R.id.g_gol);
            domaci_rumeni = itemView.findViewById(R.id.d_ru);
            gosti_rumeni = itemView.findViewById(R.id.g_ru);
            domaci_rdeci = itemView.findViewById(R.id.d_rd);
            gosti_rdeci = itemView.findViewById(R.id.g_rd);
            domaci_streli = itemView.findViewById(R.id.d_s);
            gosti_streli = itemView.findViewById(R.id.g_s);
            domaci_p = itemView.findViewById(R.id.d_p);
            gosti_p = itemView.findViewById(R.id.g_p);
        }
    }
}
