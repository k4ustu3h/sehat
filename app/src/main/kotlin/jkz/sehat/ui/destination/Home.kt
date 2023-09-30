package jkz.sehat.ui.destination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jkz.sehat.R
import jkz.sehat.ui.components.home.Greeting
import jkz.sehat.ui.components.home.QuickActions
import jkz.sehat.ui.theme.SehatTheme

@Composable
fun Home() {
    Surface {
        Column(
            Modifier
                .padding(vertical = 8.dp)
                .fillMaxHeight()
        ) {
            Greeting(name = stringResource(id = R.string.user_name))
            QuickActions()
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    SehatTheme {
        Home()
    }
}