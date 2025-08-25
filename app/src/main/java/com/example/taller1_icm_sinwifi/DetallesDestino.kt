package com.example.taller1_icm_sinwifi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetallesDestino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_destino)

        // Referencias
        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtPais = findViewById<TextView>(R.id.txtPais)
        val txtCategoria = findViewById<TextView>(R.id.txtCategoria)
        val txtPlan = findViewById<TextView>(R.id.txtPlan)
        val txtPrecio = findViewById<TextView>(R.id.txtPrecio)
        val btnFavorito = findViewById<Button>(R.id.btnFavorito)

        // Recibir destino del Intent
        val destino = intent.getSerializableExtra("destino") as? Destino

        if (destino != null) {
            txtNombre.text = destino.nombre
            txtPais.text = destino.pais
            txtCategoria.text = destino.categoria
            txtPlan.text = destino.plan
            txtPrecio.text = "USD ${destino.precio}"

            // Botón favoritos
            btnFavorito.setOnClickListener {
                Data.FAVORITOS_LIST.add(destino)  // se guarda en la lista global
                btnFavorito.isEnabled = false     // se desactiva
                Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Destino no encontrado", Toast.LENGTH_SHORT).show()
            finish() // cerrar actividad si no hay datos
        }
    }
}
