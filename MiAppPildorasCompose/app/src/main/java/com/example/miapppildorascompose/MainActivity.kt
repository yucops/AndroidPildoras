package com.example.miapppildorascompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            miBotonComponente()

        }
    }
}

@Composable
fun miBotonComponente() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val context = LocalContext.current

        Button(onClick = {
            Toast.makeText(context, "Has presionado el boton", Toast.LENGTH_SHORT).show()
        }) { Text("Presiona aqui") }
    }
}