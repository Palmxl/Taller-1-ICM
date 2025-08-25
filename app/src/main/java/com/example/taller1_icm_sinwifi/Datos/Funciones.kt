package com.example.taller1_icm_sinwifi.Datos

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset

class Funciones {
    companion object {
        fun loadJSONFromAsset(context: Context, fileName: String = "destinos.json"): String {
            return context.assets.open(fileName)
                .bufferedReader(Charsets.UTF_8)
                .use { it.readText() }
        }

        fun leerDestinos(context: Context, fileName: String = "destinos.json"): List<Destino> {
            return try {
                val raw = loadJSONFromAsset(context, fileName)
                val array: JSONArray = when {
                    raw.trim().startsWith("{") -> JSONObject(raw).getJSONArray("destinos")
                    else -> JSONArray(raw)
                }
                val out = ArrayList<Destino>(array.length())
                for (i in 0 until array.length()) {
                    val o = array.getJSONObject(i)
                    out.add(
                        Destino(
                            id        = o.optInt("id"),
                            nombre    = o.optString("nombre"),
                            pais      = o.optString("pais"),
                            categoria = o.optString("categoria"),
                            plan      = o.optString("plan"),
                            precio    = o.optDouble("precio", 0.0)
                        )
                    )
                }
                out
            } catch (e: Exception) {
                Log.e("Funciones", "Error leyendo destinos: ${e.message}")
                emptyList()
            }
        }

        fun filtrarPorCategoria(destinos: List<Destino>, categoria: String): List<Destino> {
            if (categoria.equals("Todos", true)) return destinos
            return destinos.filter { it.categoria.equals(categoria, true) }
        }

        fun nombres(destinos: List<Destino>) = destinos.map { it.nombre }
    }
}