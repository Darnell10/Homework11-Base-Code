package com.example.rusili.homework11;

import android.graphics.ColorSpace;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

/**
 * Created by D on 12/1/17.
 */

public class PokeHolder extends RecyclerView.ViewHolder {


    private ImageView poke1;
    private TextView  pokeText;

    public PokeHolder(View itemView) {
        super(itemView);
        poke1 =(ImageView) itemView.findViewById(R.id.poke_model);
        pokeText=(TextView) itemView.findViewById(R.id.poke_name);
    }


    public void onbind(PokemonEntries poke){
      //  final PokemonEntries thisPokedex =poke;
        // I want to add a get name
        pokeText.setText(poke.getPokemon_species().getName());
    }


}
