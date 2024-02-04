package com.example.k2024_01_30

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_01_30.ui.theme.K2024_01_30Theme

const val LOG_TYPE = "MAIN_ACTIVITY_STATE_LOG"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(LOG_TYPE, "In onCreate")

        setContent {
            K2024_01_30Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_TYPE, "In onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_TYPE, "In onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_TYPE, "In onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_TYPE, "In onStop")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_01_30Theme {
        Greeting("Android")
    }
}