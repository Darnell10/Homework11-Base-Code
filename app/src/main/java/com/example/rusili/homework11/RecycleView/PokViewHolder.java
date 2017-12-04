package com.example.rusili.homework11.RecycleView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rusili.homework11.R;
import com.example.rusili.homework11.detailscreen.model.Pokemon;
import com.example.rusili.homework11.detailscreen.model.objects.Sprites;
import com.example.rusili.homework11.detailscreen.view.PokemonDetailActivity;
import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.squareup.picasso.Picasso;


/**
 * Created by c4q on 12/2/17.
 */

public class PokViewHolder extends RecyclerView.ViewHolder {
    public static String POKEMON_KEY = "pokemon";

    public PokViewHolder(View itemView) {
        super(itemView);

    }

    public void bind(final PokemonEntries pokemonEntries) {
        final TextView pokName = (TextView) itemView.findViewById(R.id.pok_name);
        final ImageView imageView = (ImageView) itemView.findViewById(R.id.imge_view_holder);
        StringBuilder stringBuilder = new StringBuilder("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/");
        stringBuilder.append(pokemonEntries.getEntry_number()).append(".png");
        Glide.with(itemView.getContext()).load(stringBuilder.toString()).into(imageView);


        pokName.setText(pokemonEntries.getPokemon_species().getName());
        pokName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pokName.getContext(), PokemonDetailActivity.class);
                intent.putExtra(POKEMON_KEY, pokemonEntries.getPokemon_species().getName());
                pokName.getContext().startActivity(intent);
            }
        });


    }
}
