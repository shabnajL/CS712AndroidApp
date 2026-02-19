package com.example.cs712androidapp

<<<<<<< HEAD
import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
=======
import android.content.Intent
>>>>>>> 5292a051334932be9e39179953ab5afef46ef33d
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cs712androidapp.ui.theme.CS712AndroidAppTheme

class MainActivity : ComponentActivity() {
<<<<<<< HEAD
    private lateinit var receiver: MyBroadcastReceiver

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
=======
>>>>>>> 5292a051334932be9e39179953ab5afef46ef33d
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

<<<<<<< HEAD
=======

>>>>>>> 5292a051334932be9e39179953ab5afef46ef33d
        // second activity using an explicit intent
        val buttonExplicit = findViewById<Button>(R.id.buttonExplicit)
        buttonExplicit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


        // second activity using an implicit intent
        val buttonImplicit = findViewById<Button>(R.id.buttonImplicit)
        buttonImplicit.setOnClickListener {
            val intent = Intent("com.example.cs712androidapp.ACTION_SECOND_ACTIVITY")
            startActivity(intent)
        }
<<<<<<< HEAD

        // receiver initialization
        receiver = MyBroadcastReceiver()
        val filter = IntentFilter("com.example.MY_ACTION")
        registerReceiver(receiver, filter)


        // start Service Button
        val buttonStartService = findViewById<Button>(R.id.buttonStartService)
        buttonStartService.setOnClickListener {
            val intent = Intent(this, MyForegroundService::class.java)
            startForegroundService(intent)
        }

        //sendbroadcast button
        val buttonSendBroadcast = findViewById<Button>(R.id.buttonSendBroadcast)
        buttonSendBroadcast.setOnClickListener {
            val intent = Intent("com.example.MY_ACTION")
            sendBroadcast(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

=======
    }
>>>>>>> 5292a051334932be9e39179953ab5afef46ef33d
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
