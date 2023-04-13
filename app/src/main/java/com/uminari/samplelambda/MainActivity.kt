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

        // (Int)パラメタに明示的に名前"quality"をつけて宣言する
        val coins: (Int) -> String = { quality ->
            "$quality quarters"
        }
        // (Int)パラメタの名前"quality ->"を省略できる
        // 関数のパラメタが1つであり、名前を指定しない場合、itで参照できる
        val coins2: (Int) -> String = {
            "$it quarters"
        }

//        val cupcake: (Int) -> String = {
//            "Have a cupcake!"
//        }

        val trickFunction = trickOrTreat(true, null)
//        val treatFunction = trickOrTreat(false, coins)
        val treatFunction = trickOrTreat(false) { "$it quarters" }
        trickFunction()
        treatFunction()
        repeat(5) {
            treatFunction()
        }
    }

//    private fun trickOrTreat(isTrick: Boolean): () -> Unit {
//        return if (isTrick) {
//            trick
//        } else {
//            treat
//        }
//    }

    // 関数を引数として受け取るか、戻り値が関数の場合は高階関数と呼ばれる
    private fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
        return if (isTrick) {
            trick
        } else {
            if (extraTreat != null) {
                println(extraTreat(5))
            }
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