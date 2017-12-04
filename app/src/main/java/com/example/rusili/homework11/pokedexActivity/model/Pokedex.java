package com.example.rusili.homework11.pokedexActivity.model;

import com.example.rusili.homework11.pokedexActivity.model.objects.PokemonEntries;
import com.example.rusili.homework11.pokedexActivity.model.objects.Region;
import com.example.rusili.homework11.pokedexActivity.model.objects.VersionGroups;

/**
 * Created by rusi.li on 11/22/17.
 */

public class Pokedex {
    private int id;
    private Region region;
    private VersionGroups[] version_groups;
    private PokemonEntries[] pokemon_entries;

    //TODO: Create getters  ...done

    public Pokedex(int id, Region region, VersionGroups[] version_groups, PokemonEntries[] pokemon_entries) {
        this.id = id;
        this.region = region;

        this.version_groups = version_groups;
        this.pokemon_entries = pokemon_entries;
    }


    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public VersionGroups[] getVersion_groups() {
        return version_groups;
    }

    public PokemonEntries[] getPokemon_entries() {
        return pokemon_entries;
    }
}
