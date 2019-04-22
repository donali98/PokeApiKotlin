package com.example.pokeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pokeapi.Pokemon.Pokemon
import com.example.pokeapi.Utilities.Helper
import com.example.pokeapi.Utilities.LogNames
import com.example.pokeapi.Utilities.NetworkUtils
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(),Helper {


    var framePokemonInfo: FrameLayout? = null
    lateinit var fragmentRecyclerView:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        framePokemonInfo = findViewById(R.id.pokeInfoContainer)
        fragmentRecyclerView = findViewById(R.id.pokemon_list_rv)


    }

    override fun getIsContainerVisible(): Boolean? {
        return framePokemonInfo!=null && framePokemonInfo?.visibility == View.VISIBLE

    }

    override fun getPokemonListRecyclerView(): RecyclerView? {
        return fragmentRecyclerView
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return LinearLayoutManager(this)
    }

    override fun getFragmentTransaction(): FragmentTransaction? {
        return supportFragmentManager.beginTransaction()
    }
    override fun getAcIntent(): Intent? {
        return Intent(this, PokemonViewer::class.java)
    }

    override fun getRequestQueue(): RequestQueue? {
        return Volley.newRequestQueue(this)
    }


}
