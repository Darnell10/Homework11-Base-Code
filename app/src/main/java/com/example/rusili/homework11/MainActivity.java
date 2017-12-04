package com.example.rusili.homework11;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rusili.homework11.pokedexActivity.view.PokedexFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poke_fragment);
        Log.d("Main one", "is running .......: ");

        PokedexFragment pokedexFragment = new PokedexFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, pokedexFragment).commit();


    }

}
