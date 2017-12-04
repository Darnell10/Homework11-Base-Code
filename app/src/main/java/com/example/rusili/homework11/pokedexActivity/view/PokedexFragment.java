package com.example.rusili.homework11.pokedexActivity.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.RecycleView.PokAdapter;
import com.example.rusili.homework11.network.RetrofitFactory;
import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusi.li on 11/22/17.
 */

public class PokedexFragment extends Fragment {
    private RetrofitFactory.PokedexNetworkListener pokedexNetworkListener;
    private List<PokemonEntries> pokeList = new ArrayList<>();
    private PokAdapter pokAdapter;
    private PokemonEntries pokemonEntries;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        Log.d("Fregment ", "is running .......: ");
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        pokemonEntries = new PokemonEntries();
        getPokedexList();
        Log.d("pokeLis size onCre is: ", "" + pokeList.size());
        return view;
    }

    private void getPokedexList() {
        pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
            @Override
            public void pokedexCallback(Pokedex pokedex) {
                //    Each pokemon is in the Pokemon_Species object.
                Log.d("getPokedexList..: ", "pokeLis size " + pokeList.size());
                pokeList.clear();
                for (int i = 0; i < pokedex.getPokemon_entries().length; i++) {
                    pokeList.add((pokedex.getPokemon_entries())[i]);

                }
                Log.d("pokeLis size now is: ", "" + pokeList.size());
                pokAdapter = new PokAdapter(pokeList);
                recyclerView.setAdapter(pokAdapter);

            }
        };
        RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
        RetrofitFactory.getInstance().getPokedex(2);
    }

}
