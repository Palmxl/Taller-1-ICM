package com.example.taller1_icm_sinwifi.Logica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_icm_sinwifi.Datos.Funciones
import com.example.taller1_icm_sinwifi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExplorar = findViewById<Button>(R.id.btnExplorar)
        val btnFavoritos = findViewById<Button>(R.id.btnFavoritos)   // ← botón Favoritos en tu layout
        val btnRecomendaciones = findViewById<Button>(R.id.btnRecomendaciones)
        val spinner = findViewById<Spinner>(R.id.spinnerCategorias)

        btnExplorar.setOnClickListener {
            val categoria = spinner.selectedItem?.toString().orEmpty()
            val i = Intent(this, ExplorarActivity::class.java)
            i.putExtra(ExplorarActivity.EXTRA_CATEGORIA, categoria)
            startActivity(i)
        }

        btnRecomendaciones.setOnClickListener {
            startActivity(Intent(this, RecomendacionesActivity::class.java))
        }

        findViewById<Button>(R.id.btnRecomendaciones).setOnClickListener {
            startActivity(Intent(this, RecomendacionesActivity::class.java))
        }

        // Ir a Favoritos
        btnFavoritos.setOnClickListener {
            startActivity(Intent(this, FavoritosActivity::class.java))
        }
    }
}