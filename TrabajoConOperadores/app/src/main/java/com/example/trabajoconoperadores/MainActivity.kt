package com.example.trabajoconoperadores

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.trabajoconoperadores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val miNumero:EditText = findViewById(R.id.editTextText)
        val miBoton:Button = findViewById(R.id.button)
        val txtResultado:TextView = findViewById(R.id.textView)

        miBoton.setOnClickListener {

            val numeroUsuario = miNumero.text.toString().toIntOrNull()

            /*
            if (numeroUsuario==null) txtResultado.text = "Debes introducir un numero"
            else if (numeroUsuario<18) txtResultado.text = "Eres menor de edad"
            else if (numeroUsuario>=18) txtResultado.text = "Eres mayor de edad"
            */

            txtResultado.text = if (numeroUsuario==null) "Debes introducir un numero"
            else if (numeroUsuario>=18) "Eres mayor de edad"
            else if (numeroUsuario<18 && numeroUsuario>=0) "Eres menor de edad"
            else "Eres muy raro"
        }

    }
}