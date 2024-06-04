package br.com.ceub.projeto.aulas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.aulas.ui.theme.CorCeub
import br.com.ceub.projeto.aulas.ui.theme.MeuPrimeiroAppComposeTheme

class JogarDadosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MeuPrimeiroAppComposeTheme {
                Surface(
                    color = CorCeub,
                    modifier = Modifier.fillMaxSize()
                ) {
                    JogarDadosApp()
                }
            }
        }
    }
}

@Composable
fun JogarDadosApp() {
    ImagemDadoComBotao()
}

@Composable
fun ImagemDadoComBotao(
    meuModifier: Modifier =
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
) {

    var valorDado by remember {
        mutableIntStateOf(1)
    }

    val imagemResource = when (valorDado) {
        1 -> R.drawable.dado_1
        2 -> R.drawable.dado_2
        3 -> R.drawable.dado_4
        4 -> R.drawable.dado_4
        5 -> R.drawable.dado_5
        else -> R.drawable.dado_6
    }

    Column(
        modifier = meuModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = imagemResource),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            valorDado = (1..6).random()
        }) {
            Text(text = "Jogar")
        }
    }

}

@Preview
@Composable
fun JogarDadosAppPreview() {
    ImagemDadoComBotao()
}
