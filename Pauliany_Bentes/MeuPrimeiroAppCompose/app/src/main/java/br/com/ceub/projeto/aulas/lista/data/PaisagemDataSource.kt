package br.com.ceub.projeto.aulas.lista.data
import br.com.ceub.projeto.aulas.R
import br.com.ceub.projeto.aulas.lista.model.Paisagem

    class PaisagemDataSource {

        fun consultarPaisagens(): List<Paisagem> {

            val listaPaisagens = listOf(
                Paisagem(R.drawable.image1, "Imagem 1"),
                Paisagem(R.drawable.image2, "Imagem 2"),
                Paisagem(R.drawable.image3, "Imagem 3"),
                Paisagem(R.drawable.image4, "Imagem 4"),
                Paisagem(R.drawable.image5, "Imagem 5"),
                Paisagem(R.drawable.image6, "Imagem 6"),
                Paisagem(R.drawable.image7, "Imagem 7"),
                Paisagem(R.drawable.image8, "Imagem 8"),
                Paisagem(R.drawable.image9, "Imagem 9"),
                Paisagem(R.drawable.image10, "Imagem 10")
            )
            return listaPaisagens
        }
    }
