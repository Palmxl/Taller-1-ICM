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

        val destino = intent.getSerializableExtra(EXTRA_DESTINO) as Destino

        // Ajusta estos IDs a tu XML real
        findViewById<TextView>(R.id.tvNombre).text = destino.nombre
        findViewById<TextView>(R.id.tvPais).text = destino.pais
        findViewById<TextView>(R.id.tvCategoria).text = destino.categoria
        findViewById<TextView>(R.id.tvPlan).text = destino.plan
        findViewById<TextView>(R.id.tvPrecio).text = "USD ${destino.precio}"

        val btnFav = findViewById<Button>(R.id.btnAnadirFavorito)
        btnFav.setOnClickListener {
            val yaEsta = Data.FAVORITOS_LIST.any { it.id == destino.id }
            if (!yaEsta) {
                Data.FAVORITOS_LIST.add(destino)
                btnFav.isEnabled = false
                Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ya estaba en favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object { const val EXTRA_DESTINO = "extra_destino" }
}
