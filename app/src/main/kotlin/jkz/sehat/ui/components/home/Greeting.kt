package jkz.sehat.ui.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun Greeting(name: String) {
    Column(Modifier.padding(all = 8.dp)) {
        Text(text = "Hello $name!", fontSize = 4.em)
        Text(
            text = "How are you feeling today?",
            fontSize = 12.em,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.em
        )
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Greeting(name = "Ramprasad")
}