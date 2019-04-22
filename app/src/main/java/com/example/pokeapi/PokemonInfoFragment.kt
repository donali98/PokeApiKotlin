package com.example.pokeapi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class PokemonInfoFragment : Fragment() {

    lateinit var tvPokemonName:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pokemon_info, container, false)
        tvPokemonName = view.findViewById(R.id.tv_poke_name)
        tvPokemonName.text = arguments!!.getString("name","none")
        return view
    }

    companion object {

        fun newInstance(param1: String) =
            PokemonInfoFragment ().apply {
                arguments = Bundle().apply {
                    putString("name", param1)
                }
            }
    }


}
