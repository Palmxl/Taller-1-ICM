package com.example.taller1_icm_sinwifi.Logica

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_icm_sinwifi.Datos.Data
import com.example.taller1_icm_sinwifi.Datos.Destino
import com.example.taller1_icm_sinwifi.R

class FavoritosActivity : AppCompatActivity() {

    private lateinit var lista: List<Destino>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        findViewById<Button?>(R.id.btnVolverFavoritos)?.setOnClickListener { finish() }

        lista = Data.FAVORITOS_LIST.toList()

        val lv = findViewById<ListView>(R.id.lvFavoritos)

        if (lista.isEmpty()) {
            Toast.makeText(this, "Aún no tienes favoritos", Toast.LENGTH_SHORT).show()
        }

        lv.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            lista.map { it.nombre }
        )

        lv.setOnItemClickListener { _, _, position, _ ->
            val i = Intent(this, DetallesDestino::class.java)
            i.putExtra(DetallesDestino.EXTRA_DESTINO, lista[position])
            startActivity(i)
        }

        lv.setOnItemLongClickListener { _, _, position, _ ->
            val destino = lista[position]
            val removed = Data.FAVORITOS_LIST.removeIf { it.id == destino.id }
            if (removed) {
                Toast.makeText(this, "Eliminado de favoritos", Toast.LENGTH_SHORT).show()
                // refrescar UI simple
                lista = Data.FAVORITOS_LIST.toList()
                (lv.adapter as ArrayAdapter<String>).apply {
                    clear()
                    addAll(lista.map { it.nombre })
                    notifyDataSetChanged()
                }
            }
            true
        }
    }
}
