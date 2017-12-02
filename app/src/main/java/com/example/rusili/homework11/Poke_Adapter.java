package com.example.rusili.homework11;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.homework11.pokedexActivity.model.Pokedex;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;

import java.util.List;

import static com.example.rusili.homework11.R.layout.poke_layout;

/**
 * Created by D on 12/1/17.
 */

public class Poke_Adapter extends RecyclerView.Adapter<PokeHolder> {
    // place holder for array list.
    List<PokemonEntries> pokeList;

   public Poke_Adapter(List<PokemonEntries> pokeList) {
       this.pokeList=pokeList;
   }


   @Override
    public PokeHolder onCreateViewHolder(ViewGroup parent,int viewType) {
       View childView= LayoutInflater.from(parent.getContext()).inflate(poke_layout,parent,false);
       return new PokeHolder(childView);
   }

    @Override
    public void onBindViewHolder(PokeHolder holder, int position) {
       PokemonEntries poke = pokeList.get(position);
       holder.onbind(poke);

    }

   public int getItemCount() {
       return pokeList.size();
   }

}
