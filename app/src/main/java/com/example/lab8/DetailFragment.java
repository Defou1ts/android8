// DetailFragment.java
package com.example.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Получение ссылок на UI элементы
        ImageView flagImageView = view.findViewById(R.id.detail_country_flag);
        TextView nameTextView = view.findViewById(R.id.detail_country_name);
        TextView capitalTextView = view.findViewById(R.id.detail_country_capital);
        TextView populationTextView = view.findViewById(R.id.detail_country_population);
        TextView languageTextView = view.findViewById(R.id.detail_country_language);

        // Получение ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Наблюдение за выбранной страной
        sharedViewModel.getSelectedCountry().observe(getViewLifecycleOwner(), new Observer<Country>() {
            @Override
            public void onChanged(Country country) {
                if (country != null) {
                    nameTextView.setText(country.getName());
                    capitalTextView.setText(getString(R.string.country_capital_label) + " " + country.getCapital());
                    populationTextView.setText(getString(R.string.country_population_label) + " " + String.valueOf(country.getPopulation()));
                    languageTextView.setText(getString(R.string.country_language_label) + " " + country.getLanguage());
                    flagImageView.setImageResource(country.getFlagResource());
                }
            }
        });

        return view;
    }
}
