package com.uminari.samplelambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun main() {
//        val trickFunction = trick
//        trick()
//        trickFunction()
//        treat()

        val trickFunction = trickOrTreat(true)
        val treatFunction = trickOrTreat(false)
        trickFunction()
        treatFunction()
    }

//    private fun trickOrTreat(isTrick: Boolean): () -> Unit {
//        return if (isTrick) {
//            trick
//        } else {
//            treat
//        }
//    }

    private fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
        return if (isTrick) {
            trick
        } else {
            println(extraTreat(5))
            treat
        }
    }

    private val trick = {
        println("No treats!")
    }

    // 引数なしの戻り値なし () -> Unit
    private val treat: () -> Unit = {
        println("Have a treat!")
    }
}