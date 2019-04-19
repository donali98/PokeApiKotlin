package com.example.pokeapi.Utilities

import android.net.Uri
import android.util.Log
import com.example.pokeapi.Pokemon.PokeInfoList
import com.google.gson.Gson
import java.net.URL

class NetworkUtils(private val BASE_URL: String = "https://pokeapi.co/api/v2/pokemon/") {

    private lateinit var  finalUrl:URL

    private fun buildUrl(receivedUri:String?){
        this.finalUrl = if(receivedUri.isNullOrEmpty()){
            val uri = Uri.parse(this.BASE_URL)
                .buildUpon()
                .appendQueryParameter("limit","20")
                .appendQueryParameter("offset","1")
            .build()
            URL(uri.toString())
        }
        else{
            val uri = Uri.parse(receivedUri)
                .buildUpon()
            .build()
            URL(uri.toString())
        }
        Log.d(LogNames.customLog,finalUrl.toString())
    }

    fun getResponse(receivedUri: String?, function:(url:URL)->Unit){
        buildUrl(receivedUri)
        return function(this.finalUrl)
    }
    fun getPokemonInformation (response:String):PokeInfoList{
        val gson = Gson()
        return gson.fromJson(response,PokeInfoList::class.java)
    }
}