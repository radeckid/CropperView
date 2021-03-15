package pl.damrad.cropperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cropperView = findViewById<CropperView>(R.id.cropperView)

        findViewById<Button>(R.id.previewBtn).setOnClickListener {
            val stripe = cropperView.getStripeBitmap()
            stripe?.let { bitmap -> cropperView.setPreview(bitmap) }
        }

    }
}