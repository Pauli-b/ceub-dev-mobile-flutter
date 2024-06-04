package br.com.ceub.projeto.aulas.lista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.aulas.lista.data.PaisagemDataSource
import br.com.ceub.projeto.aulas.lista.model.Paisagem
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import br.com.ceub.projeto.aulas.ui.theme.CorCeub
import br.com.ceub.projeto.aulas.ui.theme.MeuPrimeiroAppComposeTheme

class ListaPaisagemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeuPrimeiroAppComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    AppLista()
                }
            }
        }
    }
}

@Composable
fun AppLista() {
    PaisagemLista(lista = PaisagemDataSource().consultarPaisagens())
}

@Composable
fun PaisagemCard(paisagem: Paisagem, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = paisagem.idImg),
                contentDescription = paisagem.descricao,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = paisagem.descricao,
                modifier = modifier
                    .padding(all = 16.dp),
                style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Composable
fun PaisagemLista(lista : List<Paisagem>,
                  modifier: Modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp)) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(lista) { index, paisagem ->
            if (index % 2 == 0) {
                Column {
                    PaisagemCard(paisagem = paisagem, modifier = modifier)
                    Spacer(modifier = Modifier.height(16.dp))
                    if (index + 1 < lista.size) {
                        PaisagemCard(paisagem = lista[index + 1], modifier = modifier)
                    }
                }
            }
        }
    }
}


//@Composable
//fun PaisagemLista(lista : List<Paisagem>,
//                  modifier: Modifier = Modifier
//                      .fillMaxWidth()
//                      .padding(16.dp)) {
//    LazyColumn {
//        items(lista) { paisagem ->
//            PaisagemCard(paisagem = paisagem,
//                modifier = modifier)
//        }
//    }
//
//}

@Preview
@Composable
fun AppListaPreview() {
    AppLista()
}
