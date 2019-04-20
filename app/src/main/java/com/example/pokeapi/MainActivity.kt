package com.example.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pokeapi.Pokemon.Pokemon
import com.example.pokeapi.Utilities.LogNames
import com.example.pokeapi.Utilities.NetworkUtils
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    val networkUtils:NetworkUtils = NetworkUtils()
    var pokemons:ArrayList<Pokemon> = ArrayList()

    lateinit var gridLayoutManager:GridLayoutManager
    lateinit var pokemonAdapter: PokemonAdapter
    lateinit var my_rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Haciendo la peticion
        networkUtils.getResponse(null) {
            val queue = Volley.newRequestQueue(this)
            val request = StringRequest(Request.Method.GET,it.toString(),Response.Listener { response ->run{
                val pokeInfo = networkUtils.getPokemonInformation(response)
                for( i in 0 until pokeInfo.results.size){
                    //Log.d(LogNames.customLog,pokeInfo.results[i].name)
                    val pokeRequest = StringRequest(Request.Method.GET,pokeInfo.results[i].url,Response.Listener {
                        response->run{
                            //Log.d(LogNames.customLog,response.toString())
                            try{
                                val gson= Gson()
                                val pokemon = gson.fromJson(response.toString(),Pokemon::class.java)

                                pokemons.add(pokemon)
                                if(i == pokeInfo.results.size -1){

                                    //Log.i(LogNames.customLog,"yes")
                                    my_rv = findViewById(R.id.my_rv)
                                    gridLayoutManager = GridLayoutManager(this,3)
                                    pokemonAdapter = PokemonAdapter(pokemons){

                                    }
                                    my_rv.apply {
                                        setHasFixedSize(true)
                                        layoutManager = gridLayoutManager
                                        adapter = pokemonAdapter
                                    }

                                }
                                else{ }
                                //Log.d(LogNames.customLog,pokemons[0].types[0].type.name)
                            }
                            catch (e:Exception){
                                Log.e(LogNames.customError,e.toString())
                            }


                        }
                    },Response.ErrorListener {
                        Log.e(LogNames.customError,it.toString())

                    })
                    queue.add(pokeRequest)
                }

            }

            },Response.ErrorListener {
                Log.e(LogNames.customError,it.toString())
            })
            queue.add(request)

        }


    }


}
