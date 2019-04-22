package com.example.pokeapi.Utilities

import android.content.Intent
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue

interface Helper{
    fun getIsContainerVisible():Boolean?
    fun getPokemonListRecyclerView():RecyclerView?
    fun getLayoutManager():RecyclerView.LayoutManager?
    fun getFragmentTransaction():FragmentTransaction?
    fun getAcIntent():Intent?
    fun getRequestQueue():RequestQueue?

}

/*class Helper(
    var isContainerVisible:Boolean? = null,
    var pokemonListRecyclerView: RecyclerView? = null,
    var layoutManager:RecyclerView.LayoutManager? = null,
    var fragmentTransaction: FragmentTransaction? =null,
    var intent:Intent? = null,
    var setReceivedText:String? = null,
    var requestQueue: RequestQueue? = null
    ) {

    data class Builder(
        var isContainerVisible:Boolean? = null,
        var pokemonListRecyclerView: RecyclerView? = null,
        var layoutManager:RecyclerView.LayoutManager? = null,
        var fragmentTransaction: FragmentTransaction? =null,
        var intent:Intent? = null,
        var setReceivedText:String? = null,
        var requestQueue: RequestQueue? = null


    ){
        fun isContainerVisible(isContainerVisible: Boolean) = apply {
            this.isContainerVisible = isContainerVisible
        }
        fun pokemonListRecyclerView(pokemonListRecyclerView:RecyclerView) = apply {
            this.pokemonListRecyclerView = pokemonListRecyclerView
        }
        fun layoutManager(layoutManager:RecyclerView.LayoutManager) = apply {
            this.layoutManager = layoutManager
        }
        fun fragmentTransaction(fragmentTransaction:FragmentTransaction) = apply {
            this.fragmentTransaction = fragmentTransaction
        }

        fun intent(intent:Intent) = apply {
            this.intent = intent
        }
        fun setReceivedText(setReceivedText:String) = apply {
            this.setReceivedText = setReceivedText
        }

        fun requestQueue(requestQueue:RequestQueue) = apply {
            this.requestQueue = requestQueue
        }

        fun build() = Helper(isContainerVisible,pokemonListRecyclerView,layoutManager,fragmentTransaction,intent,setReceivedText,requestQueue)


    }
}*/