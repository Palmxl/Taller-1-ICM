package com.example.taller1_icm_sinwifi.Logica

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_icm_sinwifi.Datos.Destino
import com.example.taller1_icm_sinwifi.Datos.Funciones
import com.example.taller1_icm_sinwifi.R

class ExplorarActivity : AppCompatActivity() {

    private lateinit var listaFiltrada: List<Destino>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explorar)

        findViewById<Button?>(R.id.btnVolverExplorar)?.setOnClickListener { finish() }

        initUI()
    }

    private fun initUI() {
        val categoria = intent.getStringExtra(EXTRA_CATEGORIA) ?: "Todos"
        findViewById<TextView?>(R.id.textoCategoria)?.text = "Filtrando por: $categoria"

        val todos = Funciones.leerDestinos(this)
        listaFiltrada = Funciones.filtrarPorCategoria(todos, categoria)

        val lv = findViewById<ListView>(R.id.lvDestinos)
        if (listaFiltrada.isEmpty()) {
            Toast.makeText(this, "No hay destinos en esta categoría", Toast.LENGTH_SHORT).show()
        }

        lv.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaFiltrada.map { it.nombre }
        )

        lv.setOnItemClickListener { _, _, position, _ ->
            val destino = listaFiltrada[position]
            val i = Intent(this, DetallesDestino::class.java)
            i.putExtra(DetallesDestino.EXTRA_DESTINO, destino) // Serializable
            startActivity(i)
        }
    }

    companion object { const val EXTRA_CATEGORIA = "extra_categoria" }
}