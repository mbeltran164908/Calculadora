package beltran.miguel.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var entrada1=""
    var entrada2=""
    var operacion=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_1.setOnClickListener({
            agregarNumero(btn_1.getText().toString())
        })
        btn_2.setOnClickListener({
            agregarNumero(btn_2.getText().toString())
        })
        btn_3.setOnClickListener({
            agregarNumero(btn_3.getText().toString())
        })
        btn_4.setOnClickListener({
            agregarNumero(btn_4.getText().toString())
        })
        btn_5.setOnClickListener({
            agregarNumero(btn_5.getText().toString())
        })
        btn_6.setOnClickListener({
            agregarNumero(btn_6.getText().toString())
        })
        btn_7.setOnClickListener({
            agregarNumero(btn_7.getText().toString())
        })
        btn_8.setOnClickListener({
            agregarNumero(btn_8.getText().toString())
        })
        btn_9.setOnClickListener({
            agregarNumero(btn_9.getText().toString())
        })
        btn_0.setOnClickListener({
            agregarNumero("0")
        })
        btn_borrar.setOnClickListener({
            borrar()
        })
        btn_suma.setOnClickListener({
            agregarOperacion("+")
        })
        btn_resta.setOnClickListener({
            agregarOperacion("-")
        })
        btn_multi.setOnClickListener({
            agregarOperacion("*")
        })
        btn_div.setOnClickListener({
            agregarOperacion("/")
        })
        btn_result.setOnClickListener({
            resultado()
        })
    }

    fun agregarNumero(numero:String){
        if(operacion.isBlank()){
            entrada1=entrada1+numero
            tv_entrada.setText(entrada1)
        }else{
            entrada2=entrada2+numero
            tv_entrada.setText(entrada2)
        }
    }

    fun agregarOperacion(operacion:String){
        if(!tv_entrada.text.isBlank()){
                this.operacion=operacion;
                tv_entrada.setText("")
                tv_registro.setText("$entrada1 $operacion")
        }
    }

    fun resultado(){
        var resultado=0.0
        when(operacion){
            "+"->resultado=(entrada1.toDouble()+entrada2.toDouble())
            "-"->resultado=(entrada1.toDouble()-entrada2.toDouble())
            "*"->resultado=(entrada1.toDouble()*entrada2.toDouble())
            "/"->
                if(entrada1.toDouble()!=0.0){
                    resultado=(entrada1.toDouble()/entrada2.toDouble())
                }else{
                    Toast.makeText(this,"División entre 0",Toast.LENGTH_LONG)
                }
        }
        borrar()
        entrada1=resultado.toString()
        tv_entrada.setText(resultado.toString())
    }

    fun borrar(){
        entrada1=""
        entrada2=""
        operacion=""
        tv_entrada.setText("")
        tv_registro.setText("")
    }
}
