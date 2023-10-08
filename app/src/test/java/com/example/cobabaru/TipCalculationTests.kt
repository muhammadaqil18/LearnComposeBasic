package com.example.cobabaru

import com.example.cobabaru.ui.latihan.calculateTip
import java.text.NumberFormat
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TipCalculationTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)
        assertEquals(expectedTip, actualTip)
    }

}