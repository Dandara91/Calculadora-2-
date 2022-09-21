package tads.eaj.ufrn.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class recebeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        var label = intent.extras?.getString("LABEL")
        var valor = intent.extras?.getInt("VALOR")

        val textViewLabelVariavel = findViewById<TextView>(R.id.texteviewlabelvariavel)
        val editTextVariavel= findViewById<EditText>(R.id.editTextVariavel)

        textViewLabelVariavel.text = label
        editTextVariavel.setText(valor.toString())

        val buttonOk = findViewById<Button>(R.id.Ok)
        val buttonCancelar = findViewById<Button>(R.id.Cancelar)

        buttonOk.setOnClickListener(){
            val intent = Intent()
            val bundle = Bundle()

            val editTextVariavel = findViewById<EditText>(R.id.editTextVariavel)
            bundle.putInt("VALOR", editTextVariavel.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            finish()
        }

        buttonCancelar.setOnClickListener(){
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}