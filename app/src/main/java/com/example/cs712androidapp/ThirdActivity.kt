package com.example.cs712androidapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.Manifest
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.Toast

class ThirdActivity : ComponentActivity() {

    private lateinit var captureButton: Button
    private lateinit var imageView: ImageView

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            bitmap?.let { imageView.setImageBitmap(it) }
        }

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                cameraLauncher.launch(null)
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        captureButton = findViewById(R.id.btnCaptureImage)
        imageView = findViewById(R.id.imageView)

        captureButton.setOnClickListener {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
}