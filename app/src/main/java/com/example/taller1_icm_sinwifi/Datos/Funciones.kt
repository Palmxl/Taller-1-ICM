package com.example.taller1_icm_sinwifi.Datos

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class Funciones {
    companion object {

        // Lee el archivo JSON desde /assets (por defecto "destinos.json")
        fun loadJSONFromAsset(context: Context, fileName: String = "destinos.json"): String {
            return context.assets.open(fileName)
                .bufferedReader(Charsets.UTF_8)
                .use { it.readText() }
        }

        // Devuelve la lista de destinos parseada
        fun leerDestinos(context: Context, fileName: String = "destinos.json"): List<Destino> {
            val json = loadJSONFromAsset(context, fileName)
            if (json.isBlank()) return emptyList()

            val arr = JSONArray(json) // si tu JSON tiene raíz {"destinos":[...]}, usa: JSONObject(json).getJSONArray("destinos")
            val lista = mutableListOf<Destino>()
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                lista.add(
                    Destino(
                        id = o.optInt("id"),
                        nombre = o.optString("nombre"),
                        pais = o.optString("pais"),
                        categoria = o.optString("categoria"),
                        plan = o.optString("plan"),
                        precio = o.optDouble("precio", 0.0)
                    )
                )
            }
            return lista
        }

        fun filtrarPorCategoria(destinos: List<Destino>, categoria: String): List<Destino> {
            if (categoria.equals("Todos", ignoreCase = true)) return destinos
            return destinos.filter { it.categoria.equals(categoria, ignoreCase = true) }
        }

        fun nombres(destinos: List<Destino>): List<String> = destinos.map { it.nombre }
    }
}