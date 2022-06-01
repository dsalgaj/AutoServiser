package com.example.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.models.Rezervacija;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CekanjeRVAdapter extends RecyclerView.Adapter<CekanjeRVAdapter.ViewHolder>{

    private ArrayList<Rezervacija> rezervacijaArrayList;
    private Context context;

    public CekanjeRVAdapter(ArrayList<Rezervacija> rezervacijaArrayList, Context context) {
        this.rezervacijaArrayList = rezervacijaArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CekanjeRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cekanje_rv_item, parent,
                false);

        return new CekanjeRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CekanjeRVAdapter.ViewHolder holder, int position) {
        Rezervacija rezervacije = rezervacijaArrayList.get(position);

        holder.mTipServisa.setText("Tip servisa: " + rezervacije.getTip());
        holder.mDatumServisa.setText("Datum servisa: " + rezervacije.getDatum());
        holder.mVrijemeServisa.setText("Vrijeme servisa: " + rezervacije.getVrijeme());
        holder.mImePrezime.setText("Ime i prezime: " + rezervacije.getIme() + " " + rezervacije.getPrezime());
        holder.mMobitel.setText("Mobitel: " + rezervacije.getMobitel());

        holder.mBtnCekanjeObavljeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Test", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return rezervacijaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTipServisa;
        private TextView mDatumServisa;
        private TextView mVrijemeServisa;
        private TextView mImePrezime;
        private TextView mMobitel;
        private Button mBtnCekanjeObavljeno;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTipServisa = itemView.findViewById(R.id.tvTipCekanje);
            mDatumServisa = itemView.findViewById(R.id.tvDatumCekanje);
            mVrijemeServisa = itemView.findViewById(R.id.tvVrijemeCekanje);
            mImePrezime = itemView.findViewById(R.id.tvImePrezimeCekanje);
            mMobitel = itemView.findViewById(R.id.tvMobitelCekanje);
            mBtnCekanjeObavljeno = itemView.findViewById(R.id.btnCekanjeObavljeno);
        }
    }

}
