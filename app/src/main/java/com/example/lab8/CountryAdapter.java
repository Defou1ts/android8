package com.example.lab8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }

    private final List<Country> countries;
    private final OnItemClickListener listener;

    public CountryAdapter(List<Country> countries, OnItemClickListener listener) {
        this.countries = countries;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, capitalTextView, populationTextView;
        ImageView flagImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.country_name);
            capitalTextView = itemView.findViewById(R.id.country_capital);
            populationTextView = itemView.findViewById(R.id.country_population);
            flagImageView = itemView.findViewById(R.id.country_flag);
        }

        public void bind(final Country country, final OnItemClickListener listener) {
            nameTextView.setText(country.getName());
            capitalTextView.setText(country.getCapital());
            populationTextView.setText(String.valueOf(country.getPopulation()));
            flagImageView.setImageResource(country.getFlagResource());

            itemView.setOnClickListener(v -> listener.onItemClick(country));
        }
    }
}
