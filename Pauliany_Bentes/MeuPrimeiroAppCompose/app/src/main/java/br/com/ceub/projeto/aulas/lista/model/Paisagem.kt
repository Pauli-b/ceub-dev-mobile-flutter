package br.com.ceub.projeto.aulas.lista.model

import androidx.annotation.DrawableRes

data class Paisagem(
    @DrawableRes val idImg: Int,
    val descricao: String
)
