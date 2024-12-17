package br.edu.ifsp.calcularmedia

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MediaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtValores = findViewById<EditText>(R.id.edtValores)
        val edtPesos = findViewById<EditText>(R.id.edtPesos)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val spinnerTipo = findViewById<Spinner>(R.id.spinnerTipo)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        // Spinner para selecionar o tipo de média
        val tiposMedia = arrayOf("Aritmetica", "Ponderada", "Harmonica")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposMedia)
        spinnerTipo.adapter = adapter

        // Observador para resultado da média
        viewModel.resultadoMedia.observe(this) { resultado ->
            txtResultado.text = resultado
        }

        btnCalcular.setOnClickListener {
            val valores = edtValores.text.toString().split(",").mapNotNull { it.toDoubleOrNull() }
            val pesos = edtPesos.text.toString().split(",").mapNotNull { it.toDoubleOrNull() }
            val tipoSelecionado = spinnerTipo.selectedItem.toString()

            if (valores.isNotEmpty()) {
                val pesosList = if (tipoSelecionado == "Ponderada") pesos else null
                viewModel.calcularMedia(tipoSelecionado, valores, pesosList)
            } else {
                Toast.makeText(this, "Informe os valores corretamente!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
