package com.example.calculatorapp



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private var currentInput = ""
    private var currentOperator = ""
    private var firstOperand = 0.0
    private var waitingForOperand = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)

        // Number buttons
        findViewById<Button>(R.id.button0).setOnClickListener { appendNumber("0") }
        findViewById<Button>(R.id.button1).setOnClickListener { appendNumber("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { appendNumber("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { appendNumber("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { appendNumber("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { appendNumber("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { appendNumber("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { appendNumber("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { appendNumber("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { appendNumber("9") }
        findViewById<Button>(R.id.buttonDecimal).setOnClickListener { appendDecimal() }

        // Operator buttons
        findViewById<Button>(R.id.buttonAdd).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { setOperator("×") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { setOperator("/") }
        findViewById<Button>(R.id.buttonPercent).setOnClickListener { calculatePercent() }
        findViewById<Button>(R.id.buttonSign).setOnClickListener { toggleSign() }

        // Clear and equals
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearAll() }
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calculate() }
    }

    private fun appendNumber(number: String) {
        if (waitingForOperand) {
            inputEditText.text.clear()
            waitingForOperand = false
        }
        currentInput += number
        inputEditText.append(number)
    }

    private fun appendDecimal() {
        if (waitingForOperand) {
            currentInput = "0."
            inputEditText.setText("0.")
            waitingForOperand = false
            return
        }

        if (!currentInput.contains(".")) {
            if (currentInput.isEmpty()) {
                currentInput = "0."
                inputEditText.setText("0.")
            } else {
                currentInput += "."
                inputEditText.append(".")
            }
        }
    }

    private fun setOperator(operator: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            currentOperator = operator
            waitingForOperand = true
            currentInput = ""
        }
    }

    private fun calculate() {
        if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
            val secondOperand = currentInput.toDouble()
            var result = when (currentOperator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "×" -> firstOperand * secondOperand
                "/" -> firstOperand / secondOperand
                else -> 0.0
            }

            // Handle division by zero
            if (currentOperator == "/" && secondOperand == 0.0) {
                inputEditText.setText("Error")
                currentInput = ""
                currentOperator = ""
                waitingForOperand = true
                return
            }

            // Remove .0 if the result is an integer
            val resultText = if (result % 1 == 0.0) {
                result.toInt().toString()
            } else {
                result.toString()
            }

            inputEditText.setText(resultText)
            currentInput = resultText
            currentOperator = ""
            waitingForOperand = true
        }
    }

    private fun clearAll() {
        currentInput = ""
        currentOperator = ""
        firstOperand = 0.0
        waitingForOperand = false
        inputEditText.setText("")
    }

    private fun toggleSign() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDouble() * -1
            currentInput = if (value % 1 == 0.0) {
                value.toInt().toString()
            } else {
                value.toString()
            }
            inputEditText.setText(currentInput)
        }
    }

    private fun calculatePercent() {
        if (currentInput.isNotEmpty()) {
            val value = currentInput.toDouble() / 100
            currentInput = if (value % 1 == 0.0) {
                value.toInt().toString()
            } else {
                value.toString()
            }
            inputEditText.setText(currentInput)
        }
    }
}