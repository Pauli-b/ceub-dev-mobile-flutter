package br.com.ceub.projeto.aulas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ceub.projeto.aulas.ui.theme.MeuPrimeiroAppComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Método chamado quando a atividade é criada
        Log.i("TELA", "ACESSANDO onCreate")

        setContent {
            MeuPrimeiroAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cabecalho(nome = "Pauliany", sobreNome = "Bentes")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // Método chamado quando a atividade fica visível para o usuário
        Log.i("TELA", "ACESSANDO onStart")
    }

    override fun onResume() {
        super.onResume()
        // Método chamado quando a atividade está interagindo ativamente com o usuário
        Log.i("TELA", "ACESSANDO onResume")
    }

    override fun onPause() {
        super.onPause()
        // Método chamado quando a atividade está prestes a entrar no estado de pausa
        Log.i("TELA", "ACESSANDO onPause")
    }

    override fun onStop() {
        super.onStop()
        // Método chamado quando a atividade é completamente obscurecida por outra atividade
        Log.i("TELA", "ACESSANDO onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Método chamado quando a atividade é destruída
        Log.i("TELA", "ACESSANDO onDestroy")
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Magenta) {
        Text(
            text = "Olá Mundo $name!",
            fontSize = 60.sp,
            lineHeight = 50.sp,
            modifier = modifier.padding(32.dp)
        )
    }
}

@Composable
fun ItemCard(valor: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .width(120.dp)
            .height(50.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.Blue
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = valor,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Cabecalho(nome: String, sobreNome: String) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_app),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.TopStart)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = "Ícone do usuário",
                        modifier = Modifier
                            .size(60.dp)
                    )
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(
                            text = nome,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = sobreNome,
                            fontSize = 12.sp,
                            textAlign = TextAlign.End
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(8.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White, RoundedCornerShape(8.dp))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    // Define o alinhamento horizontal dos elementos na linha como centralizado
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth() // Modificador para preencher o máximo disponível horizontalmente
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    ItemCard(valor = "Confirmar")
                    ItemCard(valor = "Cancelar")
                    Spacer(modifier = Modifier.weight(1f))
                }

            }
        }
    }
}

@Preview(name = "Preview Cabeçalho")
@Composable
fun CabecalhoPreview() {
    MeuPrimeiroAppComposeTheme {
        Cabecalho(nome = "Pauliany", sobreNome = "Bentes")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MeuPrimeiroAppComposeTheme {
//        Greeting("Android")
//    }
//}