package com.example.rusili.homework11.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.R;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

/**
 * Created by c4q on 12/2/17.
 */

public class PokAdapter extends RecyclerView.Adapter<PokViewHolder> {

    List<PokemonEntries> pokemonEntrieslist;

    public PokAdapter(List<PokemonEntries> pokeList) {
        this.pokemonEntrieslist=pokeList;
    }


    @Override
    public PokViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new PokViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokViewHolder holder, int position) {
    holder.bind(pokemonEntrieslist.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonEntrieslist.size();
    }
}
