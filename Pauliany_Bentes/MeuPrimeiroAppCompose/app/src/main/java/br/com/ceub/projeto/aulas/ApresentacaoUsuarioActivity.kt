package br.com.ceub.projeto.aulas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ceub.projeto.aulas.ui.theme.CorCeub
import br.com.ceub.projeto.aulas.ui.theme.MeuPrimeiroAppComposeTheme

class ApresentacaoUsuarioActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeuPrimeiroAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CorCeub
                ) {
                    AppApresentacao()
                }
            }

        }

    }
}

@Composable
fun CardApresentacao() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = "",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "NOME",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "Cargo",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun CardContato() {
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        ItemContato(image = R.drawable.ic_email,
            descricaoContato = "fulano@gmail.com")
        Spacer(modifier = Modifier.height(16.dp))
        ItemContato(image = R.drawable.ic_phone,
            descricaoContato = "+55 61 9999-88888")
    }
}

@Composable
fun ItemContato(@DrawableRes image : Int, descricaoContato : String) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(35.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = descricaoContato, color = Color.White)
    }
}

@Composable
fun AppApresentacao(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        CardApresentacao()
        CardContato()
    }
}


@Preview
@Composable
fun CardApresentacaoPreview() {
    MeuPrimeiroAppComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = CorCeub
        ) {
            AppApresentacao()
        }
    }
}
