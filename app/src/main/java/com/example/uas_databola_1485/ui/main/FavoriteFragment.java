package com.example.uas_databola_1485.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uas_databola_1485.R;
import com.example.uas_databola_1485.adapter.NextMatchAdapter;
import com.example.uas_databola_1485.adapter.PreviousMatchAdapter;
import com.example.uas_databola_1485.helper.DataHelper;
import com.example.uas_databola_1485.model.EventsItem;

import java.util.ArrayList;
import java.util.List;


public class FavoriteFragment extends Fragment {

    private List<EventsItem> listEvents;
    private RecyclerView rvFavorites;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        rvFavorites = view.findViewById(R.id.rv_favorite);
        rvFavorites.setHasFixedSize(true);
        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));

        DataHelper db = new DataHelper(getContext());

        listEvents = db.getAllFavorite();
        if (listEvents.size() != 0){
            PreviousMatchAdapter adapter = new PreviousMatchAdapter(listEvents);
            rvFavorites.setAdapter(adapter);
        }

        return view;
    }
}