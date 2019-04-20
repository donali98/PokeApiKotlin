package com.example.pokeapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapi.Pokemon.Pokemon

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

        fun bind(item:Pokemon,clickListener: (Pokemon) -> Unit) = with(itemView){
            txtName = findViewById(R.id.txt_name)
            txtType = findViewById(R.id.txt_type)
            txtName.text = item.name
            if(item.types.size>1) txtType.text = "${item.types[0].type.name}${item.types[1].type.name}"
            else txtType.text = "${item.types[0].type.name}"
            this.setOnClickListener{clickListener(item)}

        }
    }
}