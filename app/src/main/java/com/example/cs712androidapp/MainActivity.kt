package com.example.cs712androidapp

import android.annotation.SuppressLint
import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs712androidapp.ui.theme.CS712AndroidAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var receiver: MyBroadcastReceiver

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnspecifiedRegisterReceiverFlag")

    private fun startForegroundNow() {
        val intent = Intent(this, MyForegroundService::class.java)
        ContextCompat.startForegroundService(this, intent)
    }

    private val REQUEST_CODE = 100

    private fun openSecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS712AndroidAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        setContentView(R.layout.main_activity)


        // second activity using an explicit intent
        val buttonExplicit = findViewById<Button>(R.id.buttonExplicit)
        buttonExplicit.setOnClickListener {
            if(checkSelfPermission("com.example.cs712androidapp.MSE712") !=
                android.content.pm.PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                    arrayOf("com.example.cs712androidapp.MSE712"), REQUEST_CODE
                )
                }
            else{
                openSecondActivity()
            }

        }



        // second activity using an implicit intent
        val buttonImplicit = findViewById<Button>(R.id.buttonImplicit)
        buttonImplicit.setOnClickListener {
            val intent = Intent("com.example.cs712androidapp.ACTION_SECOND_ACTIVITY")
            startActivity(intent)
        }

        // receiver initialization
        receiver = MyBroadcastReceiver()
        val filter = IntentFilter("com.example.MY_ACTION")
        registerReceiver(receiver, filter)

        // start Service Button
        val startServiceButton = findViewById<Button>(R.id.buttonStartService)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionLauncher =
                registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
                    if (granted) {
                        startForegroundNow()
                    } else {
                        Toast.makeText(this,
                            "Notification permission denied",
                            Toast.LENGTH_SHORT).show()
                    }
                }
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundNow()
            } else {
                // Fallback for older devices (API 24/25)
                val intent = Intent(this, MyForegroundService::class.java)
                startService(intent)
            }

        }


        //sendbroadcast button
        val buttonSendBroadcast = findViewById<Button>(R.id.buttonSendBroadcast)
        buttonSendBroadcast.setOnClickListener {
            val intent = Intent("com.example.MY_ACTION")
            sendBroadcast(intent)
        }

        // third activity - Capture Image button
        val buttonThird = findViewById<Button>(R.id.buttonThirdActivity)
        buttonThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)
        if(requestCode == REQUEST_CODE && grantResults.isNotEmpty() &&
            grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED){

            openSecondActivity()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CS712AndroidAppTheme {
        Greeting("Android")
    }
}
