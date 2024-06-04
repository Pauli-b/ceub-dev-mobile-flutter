package br.com.ceub.projeto.aulas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ceub.projeto.aulas.ui.theme.CorCeub
import br.com.ceub.projeto.aulas.ui.theme.MeuPrimeiroAppComposeTheme
import java.text.NumberFormat
import java.util.Locale

class CalculadoraAlcoolGasolinaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeuPrimeiroAppComposeTheme {
                Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
                    CalculadoraApp()
                }
            }
        }
    }
}

@Composable
fun CalculadoraApp() {
    var valorGasolinaEntrada by remember { mutableStateOf("5,39") }
    var valorEtanolEntrada by remember { mutableStateOf("3,86") }
    var usarSetentaCincoPorCento by remember { mutableStateOf(false) }

    val formatadorNumero = NumberFormat.getNumberInstance(Locale("pt", "BR"))
    val valorGasolinaNumerico = formatadorNumero.parse(valorGasolinaEntrada)?.toDouble() ?: 0.0
    val valorEtanolNumerico = formatadorNumero.parse(valorEtanolEntrada)?.toDouble() ?: 0.0
    val textoResultado = calcularEtanolVersusGasolina(
        valorGasolina = valorGasolinaNumerico,
        valorEtanol = valorEtanolNumerico,
        usarSetentaCincoPorCento = usarSetentaCincoPorCento
    )

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.titulo),
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.titleLarge
        )
        CampoNumerico(valor = valorGasolinaEntrada, onValorAlterado = { valorGasolinaEntrada = it }, label = stringResource(id = R.string.gasolina_label), iconResId = R.drawable.gasolina_icon)
        CampoNumerico(valor = valorEtanolEntrada, onValorAlterado = { valorEtanolEntrada = it }, label = stringResource(id = R.string.etanol_label))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.usar_75_percent_label),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = usarSetentaCincoPorCento,
                onCheckedChange = { usarSetentaCincoPorCento = it },
                colors = androidx.compose.material3.SwitchDefaults.colors(
                    checkedThumbColor = Color.Magenta
                )
            )
        }
        
        Text(
            text = textoResultado,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge
        )

    }

    }

@Composable
fun CampoNumerico(
    valor: String,
    onValorAlterado: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
        .padding(bottom = 32.dp)
        .fillMaxWidth(),
    iconResId: Int? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        iconResId?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier.size(30.dp).padding(end = 8.dp),
                tint = Color.Magenta
            )
        }
        TextField(
            label = { Text(text = label) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = valor,
            onValueChange = onValorAlterado,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun calcularEtanolVersusGasolina(
    valorGasolina: Double,
    valorEtanol: Double,
    usarSetentaCincoPorCento: Boolean
): String {
    val limite = if (usarSetentaCincoPorCento) 0.75 else 0.7
    val porcentagem = valorEtanol / valorGasolina
    val porcentagemFmt = NumberFormat.getPercentInstance().format(porcentagem)
    return if (porcentagem > limite) {
        stringResource(id = R.string.vantagem_gasolina, porcentagemFmt)
    } else {
        stringResource(id = R.string.vantagem_etanol, porcentagemFmt)
    }
}

@Preview
@Composable
fun CalculadoraAppPreview() {
    MeuPrimeiroAppComposeTheme {
        Surface(color = CorCeub, modifier = Modifier.fillMaxSize()) {
            CalculadoraApp()
        }
    }
}
