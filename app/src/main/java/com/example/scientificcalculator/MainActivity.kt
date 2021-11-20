package com.example.scientificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private var lastMin = false
    private var last = false //if last = true you can use +,-,*,/,...
    private var isDot = true
    private var isRad = true
    private var n = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pi = 3.1415926535
        val e = 2.7182818284
        val bigView = findViewById<TextView>(R.id.bigView)
        val smallView = findViewById<TextView>(R.id.littleView)
        val btnB0 = findViewById<Button>(R.id.b0)
        val btnB1 = findViewById<Button>(R.id.b1)
        val btnB2 = findViewById<Button>(R.id.b2)
        val btnB3 = findViewById<Button>(R.id.b3)
        val btnB4 = findViewById<Button>(R.id.b4)
        val btnB5 = findViewById<Button>(R.id.b5)
        val btnB6 = findViewById<Button>(R.id.b6)
        val btnB7 = findViewById<Button>(R.id.b7)
        val btnB8 = findViewById<Button>(R.id.b8)
        val btnB9 = findViewById<Button>(R.id.b9)
        val btnBac = findViewById<Button>(R.id.bac)
        val btnBc = findViewById<Button>(R.id.bc)
        val btnBsin = findViewById<Button>(R.id.bsin)
        val btnBcos = findViewById<Button>(R.id.bcos)
        val btnBtan = findViewById<Button>(R.id.btan)
        val btnBlog = findViewById<Button>(R.id.blog)
        val btnBln = findViewById<Button>(R.id.bln)
        val btnBxf = findViewById<Button>(R.id.bxf)
        val btnBx2 = findViewById<Button>(R.id.bx2)
        val btnBr = findViewById<Button>(R.id.br)
        val btnB1x = findViewById<Button>(R.id.b1x)
        val btnBdiv = findViewById<Button>(R.id.bdiv)
        val btnBmul = findViewById<Button>(R.id.bmul)
        val btnBplus = findViewById<Button>(R.id.bplus)
        val btnBmin = findViewById<Button>(R.id.bmin)
        val btnBequal = findViewById<Button>(R.id.bequal)
        val btnBdot = findViewById<Button>(R.id.bdot)
        val btnBpi = findViewById<Button>(R.id.bpi)
        val btnBe = findViewById<Button>(R.id.be)
        val btnDegRad = findViewById<Button>(R.id.degRad)

        btnB0.setOnClickListener {
            if (smallView.text.length == 1 && smallView.text.substring(0,1) == "0")
                smallView.append("")
            else {
                smallView.append("0")
                last = true
                smallViewContainsDot()
            }
        }
        btnB1.setOnClickListener {
            smallView.append("1")
            last = true
            smallViewContainsDot()
        }
        btnB2.setOnClickListener {
            smallView.append("2")
            last = true
            smallViewContainsDot()
        }
        btnB3.setOnClickListener {
            smallView.append("3")
            last = true
            smallViewContainsDot()
        }
        btnB4.setOnClickListener {
            smallView.append("4")
            last = true
            smallViewContainsDot()
        }
        btnB5.setOnClickListener {
            smallView.append("5")
            last = true
            smallViewContainsDot()
        }
        btnB6.setOnClickListener {
            smallView.append("6")
            last = true
            smallViewContainsDot()
        }
        btnB7.setOnClickListener {
            smallView.append("7")
            last = true
            smallViewContainsDot()
        }
        btnB8.setOnClickListener {
            smallView.append("8")
            last = true
            smallViewContainsDot()
        }
        btnB9.setOnClickListener {
            smallView.append("9")
            last = true
            smallViewContainsDot()
        }
        btnBac.setOnClickListener {
            bigView.text = ""
            smallView.text = ""
            last = false
        }
        btnBc.setOnClickListener {
            val txt0 = smallView.text.toString()
            val txt = textStringBc(txt0)
            smallView.text = txt
        }
        btnBsin.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = if (isRad)
                    sin(cal)
                else
                    sin(Math.toRadians(cal))
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBcos.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = if (isRad)
                    cos(cal)
                else
                    cos(Math.toRadians(cal))
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBtan.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = if (isRad)
                    tan(cal)
                else
                    tan(Math.toRadians(cal))
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBln.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = log(cal, e)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBlog.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = log(cal, 10.0)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBxf.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toInt()
                cal = factorial(cal)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBx2.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = cal.pow(2.0)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBr.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = sqrt(cal)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnB1x.setOnClickListener {
            val txt = smallView.text.toString()
            if (txt.isEmpty())
                smallView.text = ""
            else {
                var cal = txt.toDouble()
                cal = cal.pow(-1.0)
                smallView.text = ""
                smallView.text = cal.toString()
                last = true
            }
        }
        btnBe.setOnClickListener {
            if (smallView.text.isEmpty()) {
                smallView.append(e.toString())
                last = true
            } else
                smallView.append("")
        }
        btnBdiv.setOnClickListener {
            if (last) {
                if (n) {
                    equalOperator()
                    n = false
                    lastMin = true
                    isDot = true
                }
                bigView.append(smallView.text.toString() + "÷")
                smallView.text = ""
                last = false
                isDot = true
                n = true
            } else {
                smallView.append("")
                isDot = false
            }
        }
        btnBdot.setOnClickListener {
            if (isDot && last) {
                smallView.append(".")
                isDot = false
            }
            else {
                smallView.append("")
            }
        }
        btnBmul.setOnClickListener {
            if (last) {
                if (n) {
                    equalOperator()
                    n = false
                    lastMin = true
                    isDot = true
                }
                bigView.append(smallView.text.toString() + "x")
                smallView.text = ""
                last = false
                isDot = true
                n = true
            } else {
                smallView.append("")
                isDot = false
            }
        }
        btnBplus.setOnClickListener {
            if (last) {
                if (n) {
                    equalOperator()
                    n = false
                    lastMin = true
                    isDot = true
                }
                bigView.append(smallView.text.toString() + "+")
                smallView.text = ""
                n = true
                last = false
                isDot = true
            } else {
                smallView.append("")
                isDot = false
            }
        }
        btnBmin.setOnClickListener {
            var s = ""
            if (smallView.text.isEmpty() && bigView.text.isEmpty()){
                s = "-"
                smallView.append(s)
            }
            if (last) {
                if (n) {
                    equalOperator()
                    n = false
                    isDot = true
                }
                bigView.append(smallView.text.toString() + "-")
                smallView.text = ""
                last = false
                n = true
                isDot = true
            } else {
                smallView.append("")
                isDot = false
            }
        }
        btnBpi.setOnClickListener {
            if (smallView.text.isEmpty()) {
                smallView.append(pi.toString())
                last = true
            } else
                smallView.append("")
        }
        btnBequal.setOnClickListener {
            if(smallView.text.isEmpty())
                bigView.append("")
            else {
                if (bigView.text.isEmpty()) {
                    bigView.append("")
                } else
                    equal()
            }
        }
        btnDegRad.setOnClickListener {
            if(btnDegRad.text == "deg") {
                btnDegRad.text = "rad"
                isRad = false
                Toast.makeText(this,"switched to degrees",Toast.LENGTH_SHORT).show()
            } else {
                btnDegRad.text = "deg"
                isRad = true
                Toast.makeText(this,"switched to radians",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun textStringBc(txt0: String): String{
        var txt = txt0
        if (txt.isEmpty())
            return ""
        else {
            if (txt.length == 1)
                last = false
            if (txt.substring(txt.length - 1, txt.length) == ".")
                isDot = true
            when {
                txt.length >= 3 -> {
                    return if (txt.substring(txt.length - 3,txt.length) == "sin" || txt.substring(txt.length - 3,txt.length) == "cos" ||
                        txt.substring(txt.length - 3,txt.length) == "tan" || txt.substring(txt.length - 3,txt.length) == "tan" ||
                        txt.substring(txt.length - 3,txt.length) == "log"){
                        txt = txt.substring(0,txt.length - 3)
                        txt
                    } else if (txt.substring(txt.length - 2,txt.length) == "ln"){
                        txt = txt.substring(0,txt.length - 2)
                        txt
                    } else {
                        txt = txt.substring(0,txt.length - 1)
                        txt
                    }
                }
                txt.length == 2 -> {
                    return if (txt.substring(0,txt.length) == "ln"){
                        txt = txt.substring(0,txt.length - 2)
                        txt
                    } else {
                        txt = txt.substring(0,txt.length - 1)
                        txt
                    }
                }
                else -> {
                    txt = txt.substring(0,txt.length - 1)
                    return txt
                }
            }
        }
    }

    private fun equal() {
        val TvInput = findViewById<TextView>(R.id.bigView)
        val smallView = findViewById<TextView>(R.id.littleView)
        TvInput.append(smallView.text.toString())
        var TvInputText = TvInput.text.toString()
        var prefix = ""
        try {
            if (TvInputText.startsWith("-")) {
                prefix = "-"
                TvInputText = TvInputText.substring(1)
            }
            if (TvInputText.contains("-")) {
                val TvInputSplit = TvInputText.split("-")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                smallView.text = removeZero((One.toDouble() - Two.toDouble()).toString())
                TvInput.text = ""
            }
            if (TvInputText.contains("+")) {
                val TvInputSplit = TvInputText.split("+")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                smallView.text = removeZero((One.toDouble() + Two.toDouble()).toString())
                TvInput.text = ""
            }
            if (TvInputText.contains("x")) {
                val TvInputSplit = TvInputText.split("x")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                smallView.text = removeZero((One.toDouble() * Two.toDouble()).toString())
                TvInput.text = ""
            }
            if (TvInputText.contains("÷")) {
                val TvInputSplit = TvInputText.split("÷")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                smallView.text = removeZero((One.toDouble() / Two.toDouble()).toString())
                TvInput.text = ""
            }
        } catch (e: ArithmeticException) {
            e.printStackTrace()
        }
    }

    private fun equalOperator() {
        val TvInput = findViewById<TextView>(R.id.bigView)
        val smallView = findViewById<TextView>(R.id.littleView)
        TvInput.append(smallView.text.toString())
        smallView.text = ""
        var TvInputText = TvInput.text.toString()
        var prefix = ""
        try {
            if (TvInputText.startsWith("-")) {
                prefix = "-"
                TvInputText = TvInputText.substring(1)
            }
            if (TvInputText.contains("-")) {
                val TvInputSplit = TvInputText.split("-")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                TvInput.text = removeZero((One.toDouble() - Two.toDouble()).toString())
                smallView.text = ""
            }
            if (TvInputText.contains("+")) {
                val TvInputSplit = TvInputText.split("+")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                TvInput.text = removeZero((One.toDouble() + Two.toDouble()).toString())
                smallView.text = ""
            }
            if (TvInputText.contains("x")) {
                val TvInputSplit = TvInputText.split("x")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                TvInput.text = removeZero((One.toDouble() * Two.toDouble()).toString())
                smallView.text = ""
            }
            if (TvInputText.contains("÷")) {
                val TvInputSplit = TvInputText.split("÷")
                var One = TvInputSplit[0]
                val Two = TvInputSplit[1]
                if (!prefix.isEmpty())
                    One = prefix + One
                TvInput.text = removeZero((One.toDouble() / Two.toDouble()).toString())
                smallView.text = ""
            }
        } catch (e: ArithmeticException) {
            e.printStackTrace()
        }
    }

    private fun removeZero(result: String): String{
        var Value = result
        if (Value.contains(".0"))
            Value = result.substring(0,result.length - 2)
        return Value
    }

    private fun factorial(n: Int): Int{
        return if (n == 1 || n == 0)
            1
        else
            n * factorial(n - 1)
    }

    private fun smallViewContainsDot() {
        val smallView = findViewById<TextView>(R.id.littleView)
        isDot = !smallView.text.contains(".")
    }
}
