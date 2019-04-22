package com.example.pokeapi

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PokemonViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_viewer)
        if(resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }
        if(savedInstanceState==null){
            val contentFragment = PokemonInfoFragment()
            contentFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction().add(R.id.container,contentFragment).commit()
        }
    }
}
