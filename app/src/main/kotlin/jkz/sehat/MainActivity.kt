package jkz.sehat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jkz.sehat.ui.destination.Home
import jkz.sehat.ui.theme.SehatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SehatTheme {
                Home()
            }
        }
    }
}