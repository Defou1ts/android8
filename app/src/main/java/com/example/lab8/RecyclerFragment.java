package com.example.lab8;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerFragment extends Fragment {

    private SharedViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        // Определение ориентации и настройка LayoutManager
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.HORIZONTAL, false));
        }

        // Получение ViewModel
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Получение списка стран
        List<Country> countries = CountryData.getCountries();

        // Создание адаптера с обработчиком кликов
        CountryAdapter adapter = new CountryAdapter(countries, country -> {
            sharedViewModel.selectCountry(country);
        });

        recyclerView.setAdapter(adapter);

        // Установка выбора по умолчанию, если ни одна страна не выбрана
        if (sharedViewModel.getSelectedCountry().getValue() == null && !countries.isEmpty()) {
            sharedViewModel.selectCountry(countries.get(0));
        }

        return view;
    }
}
