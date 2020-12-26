package com.example.projetandroid4a.presentation.retrofit

import com.example.projetandroid4a.data.remote.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon:Observable<Pokedex>


}