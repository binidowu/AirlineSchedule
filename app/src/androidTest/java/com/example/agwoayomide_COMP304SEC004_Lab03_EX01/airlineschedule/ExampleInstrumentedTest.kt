package com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.agwoayomide_COMP304SEC004_Lab03_EX01.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule", appContext.packageName)
    }
}