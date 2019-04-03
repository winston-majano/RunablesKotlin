package dev.winstonmajano.runableskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var  number:Int = 0
    var handler: Handler = Handler();
    var runable:Runnable =  Runnable {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun start(view: View){
        number = 0

        runable = object : Runnable{
            override fun run() {
                tv1.text = "Time: "+number
                number++
                tv1.text = "Time: "+number
                handler.postDelayed(this, 1000)
            }

        }

        handler.post(runable)
    }

    fun reset(view: View){
            handler.removeCallbacks(runable)
            number = 0
        tv1.text = "Time: "+number
    }


}
