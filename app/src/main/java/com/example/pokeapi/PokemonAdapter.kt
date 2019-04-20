package com.example.pokeapi

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.Pokemon.Pokemon
import com.example.pokeapi.Utilities.LogNames
import com.squareup.picasso.Picasso

class PokemonAdapter(val items:ArrayList<Pokemon>,val clickListener:(Pokemon)->Unit):RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position],clickListener)


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        lateinit var  txtName: TextView
        lateinit var  txtType: TextView
        lateinit var  imgPokemon: ImageView

        fun bind(item:Pokemon,clickListener: (Pokemon) -> Unit) = with(itemView){
            txtName = findViewById(R.id.txt_name)
            txtType = findViewById(R.id.txt_type)
            imgPokemon = findViewById(R.id.img_pokemon)

            txtName.text = item.name
            if(item.types.size>1) txtType.text = "${item.types[0].type.name}   ${item.types[1].type.name}"
            else txtType.text = "${item.types[0].type.name}"
            try{
                Picasso.get()
                    .load(item.sprites.front_default)
                    .resize(50,50)
                    .centerCrop()
                    .into(imgPokemon)
            }catch (e:Exception){
                Log.e(LogNames.customError,e.toString())
            }
            this.setOnClickListener{clickListener(item)}


        }
    }
}