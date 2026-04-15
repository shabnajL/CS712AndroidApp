package com.example.cs712androidapp

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*

import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiAutomatorTest {

    private lateinit var device: UiDevice
    private val packageName = "com.example.cs712androidapp"
    private val timeout = 5000L

    @Before
    fun setUp() {
        device = UiDevice.getInstance(
            InstrumentationRegistry.getInstrumentation()
        )

        // # Go to home screen
        device.pressHome()

        // # Launch app
        val context = InstrumentationRegistry.getInstrumentation().context
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        requireNotNull(intent)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // # Wait for app
        device.wait(Until.hasObject(By.pkg(packageName).depth(0)), timeout)
    }

    @Test
    fun testAppFlow() {

        // # Click button by ID="buttonExplicit"
        device.wait(
            Until.findObject(By.res(packageName, "buttonExplicit")),
            timeout
        )?.click()

        // # Wait for second screen
        device.wait(Until.hasObject(By.pkg(packageName).depth(0)), timeout)

        // # Verify content(one of the challenges) in the second activity
        // test - 2
        val found = device.hasObject(
            By.textContains("Device Fragmentation")
        )
        /* // test - 1
        val found = device.hasObject(
            By.textContains("Security")
        )
         */

        assertTrue("Oh Bummer! Text not found on second screen.", found)
    }
}