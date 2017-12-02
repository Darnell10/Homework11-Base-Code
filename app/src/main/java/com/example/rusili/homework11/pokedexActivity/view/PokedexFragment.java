package com.example.rusili.homework11.pokedexActivity.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.Poke_Adapter;
import com.example.rusili.homework11.R;
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

	private RecyclerView pokeRecyclerView;

	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_poke_,container,false);

        pokeRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        GridLayoutManager pokeGrid = new GridLayoutManager(getContext(),3);
        pokeRecyclerView.setLayoutManager(pokeGrid);


		getPokedexList();

		return view;
	}

	private void getPokedexList () {
		pokedexNetworkListener = new RetrofitFactory.PokedexNetworkListener() {
			@Override
			public void pokedexCallback (Pokedex pokedex) {
				// TODO: show Pokemon
				// Each pokemon is in the Pokemon_Species object.

				List<PokemonEntries> pokies = new ArrayList<>();
                for (int i = 0; i < 151 ; i++) {
                    pokies.add(pokedex.getPokemon_entries()[i]);
                }

                Poke_Adapter pokeAdapter = new Poke_Adapter(pokies);
                pokeRecyclerView.setAdapter(pokeAdapter);

            }

		};

		RetrofitFactory.getInstance().setPokedexListener(pokedexNetworkListener);
		RetrofitFactory.getInstance().getPokedex(2);
	}
}
