package com.example.taller1_icm_sinwifi.Logica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_icm_sinwifi.Datos.Data
import com.example.taller1_icm_sinwifi.R
import kotlin.random.Random

class RecomendacionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)

        findViewById<Button?>(R.id.btnVolverRecs)?.setOnClickListener { finish() }

        val titulo   = findViewById<TextView>(R.id.recTitulo)
        val pais     = findViewById<TextView>(R.id.recPais)
        val categoria= findViewById<TextView>(R.id.recCategoria)
        val plan     = findViewById<TextView>(R.id.recPlan)
        val precio   = findViewById<TextView>(R.id.recPrecio)

        val favs = Data.FAVORITOS_LIST

        if (favs.isEmpty()) {
            titulo.text    = "NA"
            pais.text      = "NA"
            categoria.text = "NA"
            plan.text      = "NA"
            precio.text    = "NA"
            return
        }

        val catTop = favs.groupingBy { it.categoria }.eachCount().maxByOrNull { it.value }!!.key

        val candidatos = favs.filter { it.categoria.equals(catTop, true) }
        val elegido = candidatos[Random.nextInt(candidatos.size)]

        titulo.text    = elegido.nombre
        pais.text      = elegido.pais
        categoria.text = elegido.categoria
        plan.text      = elegido.plan
        precio.text    = "USD ${elegido.precio}"
    }
}