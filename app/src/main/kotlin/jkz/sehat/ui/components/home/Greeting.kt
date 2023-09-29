package jkz.sehat.ui.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import jkz.sehat.R

@Composable
fun Greeting(name: String) {
    Column(Modifier.padding(all = 8.dp)) {
        Text(text = stringResource(id = R.string.hello) + " " + name + "!", fontSize = 4.em)
        Text(
            text = stringResource(id = R.string.greeting),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 12.em,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.em
        )
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Greeting(name = stringResource(id = R.string.user_name))
}