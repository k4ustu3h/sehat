package jkz.sehat.ui.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jkz.sehat.ui.components.CardGrid
import jkz.sehat.ui.components.home.Greeting

@Composable
fun Home() {
    Column(Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        Greeting(name = "Ramprasad")
        CardGrid()
    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}