package com.example.rusili.homework11.pokedexActivity.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rusili.homework11.R;

import java.util.zip.Inflater;

public class PokemonMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace((R.id.fragment_container),new PokedexFragment()).addToBackStack("pokeback").commit();

        //  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container),new Fragment().addToBackStack().commit();
    }
}
