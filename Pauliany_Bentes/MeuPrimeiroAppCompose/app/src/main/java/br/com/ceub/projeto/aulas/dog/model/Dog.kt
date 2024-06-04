package br.com.ceub.projeto.aulas.dog.model
import br.com.ceub.projeto.aulas.R

data class Dog(
    val img: Int,
    val nome: String,
    val idade: Int,
    val hobbie: String
)

val listaDogs = listOf(
    Dog(R.drawable.koda, "Koda", 2, "Comer Terra"),
    Dog(R.drawable.lola, "lola", 4, "Brincar"),
    Dog(R.drawable.frankie, "frankie", 6, "Se esconder"),
    Dog(R.drawable.nox, "nox", 4, "Conhecer novos animais"),
    Dog(R.drawable.faye, "faye", 1, "Cagar no jardim"),
    Dog(R.drawable.bella, "bella", 4, "Surfar"),
    Dog(R.drawable.moana, "moana", 6, "Andar de Skate"),
    Dog(R.drawable.tzeitel, "tzeitel", 8, "Tomar banho"),
    Dog(R.drawable.leroy, "leroy", 12, "Dormir"),
)