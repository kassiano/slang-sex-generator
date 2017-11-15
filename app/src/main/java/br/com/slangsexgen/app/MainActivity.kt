package br.com.slangsexgen.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val random = Random()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val verbos =  resources.getStringArray(R.array.verbos)
        val substantivos =  resources.getStringArray(R.array.substantivos)


        txt_dia_semana.text = "Hoje é ${diaDaSemana()}, dia de"

        generateSlang(verbos, substantivos)

        btn_gen.setOnClickListener { generateSlang(verbos, substantivos) }



    }

    fun generateSlang(verbos:Array<String> , substantivos:Array<String>){
        val verb=  genVerb(verbos)
        val sub = genSub(substantivos)
        txt_slang.text = "$verb $sub".toUpperCase()

    }


    fun genVerb(verbos:Array<String>) = verbos[rand(0, verbos.size -1)]
    fun genSub(substantivos:Array<String>) = substantivos[rand(0, substantivos.size -1)]


    fun diaDaSemana():String{

        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_WEEK)

        var dia = ""
        when (day) {

            Calendar.SUNDAY -> dia = "Domingo"
            Calendar.MONDAY -> dia = "Segunda-Feira"
            Calendar.TUESDAY -> dia = "Terça-Feira"
            Calendar.WEDNESDAY -> dia = "Quarta-Feira"
            Calendar.THURSDAY -> dia = "Quinta-Feira"
            Calendar.FRIDAY -> dia = "Sexta-Feira"
            Calendar.SATURDAY -> dia = "Sabado"

        }

        return dia
    }

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

}
