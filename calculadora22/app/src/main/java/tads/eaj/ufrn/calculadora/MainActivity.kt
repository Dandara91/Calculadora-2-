package tads.eaj.ufrn.calculadora

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    var variavelX:Int = 0
    var variavelY:Int = 0
    var resultado:Int = 0

    val setvariavelXlancher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    result ->
        if (result.resultCode == RESULT_OK){
            variavelX = result.data!!.getIntExtra("VALOR",0)
            val textViewVariavelX = findViewById<TextView>(R.id.texteviewlabelvariavel)
            textViewVariavelX.text = "${variavelX}"
        }else{
            Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show()
        }
}

    val setvariavelYlaucher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == RESULT_OK){
            variavelY = result.data!!.getIntExtra("VALOR", 0)
            val textViewvariavelY = findViewById<TextView>(R.id.texteviewlabelvariavel)
            textViewvariavelY.text="${variavelY}"
        }else{
            Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show()
        }


    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewvariavelX =  findViewById<TextView>(R.id.variavelx)
        val textViewvariavely =  findViewById<TextView>(R.id.variavelY)
        val textViewvariavelResult =  findViewById<TextView>(R.id.textViewvariavelResult)

        textViewvariavelResult.text = "${textViewvariavelResult}"
        textViewvariavelX.text = "${textViewvariavelX}"
        textViewvariavely.text = "${textViewvariavely}"


        val buttonsetvariavelX = findViewById<Button>(R.id.buttonsetvariavelX)
        val buttonsetvariavelY = findViewById<Button>(R.id.buttonSetVariavelY)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        buttonsetvariavelX.setOnClickListener {
        val intent = Intent( this, recebeActivity:: class.java)


        val bundle = Bundle()

        bundle.putString("VARIAVEL", "variavel X:")
        bundle.putInt("VALOR", variavelX)
        intent.putExtras(bundle)

            setvariavelXlancher.launch(intent)

        }
buttonsetvariavelY.setOnClickListener(){
    val intent = Intent(this, recebeActivity::class.java)

    val bundle = Bundle()
    bundle.putString("VARIAVEL", "variavel Y")
    bundle.putInt("VALOR", variavelY)
    intent.putExtras(bundle)

    setvariavelYlaucher.launch(intent)
}
        buttonCalcular.setOnClickListener(){
            textViewvariavelResult.text = (variavelX+ variavelY).toString()
            Toast.makeText(this, ("Result"), Toast.LENGTH_SHORT).show()

        }


    }


}