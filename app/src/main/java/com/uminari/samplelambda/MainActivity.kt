package com.uminari.samplelambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun main() {
        val trickFunction = trick
        trick()
        trickFunction()
        treat()
    }

    private val trick = {
        println("No treats!")
    }

    // 引数なしの戻り値なし () -> Unit
    private val treat: () -> Unit = {
        println("Have a treat!")
    }
}