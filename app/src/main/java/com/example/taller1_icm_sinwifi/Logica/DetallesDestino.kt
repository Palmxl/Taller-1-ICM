package com.example.taller1_icm_sinwifi.Logica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_icm_sinwifi.Datos.Data
import com.example.taller1_icm_sinwifi.Datos.Destino
import com.example.taller1_icm_sinwifi.Datos.Funciones
import com.example.taller1_icm_sinwifi.R

class DetallesDestino : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_destino)

        findViewById<Button>(R.id.btnVolverDetalles)?.setOnClickListener { finish() }

        val destino = intent.getSerializableExtra(EXTRA_DESTINO) as Destino

        findViewById<TextView>(R.id.titulo).text    = destino.nombre
        findViewById<TextView>(R.id.pais).text      = destino.pais
        findViewById<TextView>(R.id.categoria).text = destino.categoria
        findViewById<TextView>(R.id.plan).text      = destino.plan
        findViewById<TextView>(R.id.precio).text    = "USD ${destino.precio}"

        val btnFav = findViewById<Button>(R.id.botonFavoritos)

        val yaEsta = Data.FAVORITOS_LIST.any { it.id == destino.id }
        btnFav.isEnabled = !yaEsta
        btnFav.text = if (yaEsta) "Ya en Favoritos" else "Añadir a Favoritos"

        btnFav.setOnClickListener {
            if (Data.FAVORITOS_LIST.any { it.id == destino.id }) {
                Toast.makeText(this, "Ya estaba en favoritos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Data.FAVORITOS_LIST.add(destino)
            btnFav.isEnabled = false
            btnFav.text = "Ya en Favoritos"
            Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
        }
    }

    companion object { const val EXTRA_DESTINO = "extra_destino" }
}

