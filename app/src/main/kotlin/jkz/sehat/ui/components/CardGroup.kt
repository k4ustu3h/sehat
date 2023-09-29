package jkz.sehat.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

val actions = listOf("Medication Tracking", "Browse Medicines", "Dietary Planning", "Appointments")

@Composable
fun CardGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)
    ) {
        items(actions) { item ->
            Card(
                modifier = Modifier
                    .aspectRatio(1F)
                    .padding(4.dp)
            ) {
                Text(
                    text = item, modifier = Modifier.padding(8.dp), fontSize = 5.em
                )
            }
        }
    }
}

@Preview
@Composable
fun CardGroupPreview() {
    Column {
        CardGrid()
    }
}