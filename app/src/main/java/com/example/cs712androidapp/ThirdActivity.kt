package com.example.cs712androidapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity

class ThirdActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        val btn = findViewById<Button>(R.id.camera_open)
        val img = findViewById<ImageView>(R.id.click_image)

        btn.setOnClickListener {
            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1)
        }
    }

    override fun onActivityResult(req: Int, res: Int, data: Intent?) {
        super.onActivityResult(req, res, data)

        if (req == 1 && res == Activity.RESULT_OK) {
            val bmp = data?.extras?.get("data") as? Bitmap
            bmp?.let { findViewById<ImageView>(R.id.click_image).setImageBitmap(it) }
        }
    }
}