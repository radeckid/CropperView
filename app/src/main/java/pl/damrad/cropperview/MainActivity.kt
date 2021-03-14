package pl.damrad.cropperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainImageView = findViewById<CropperView>(R.id.cropperView)
        val preview = findViewById<ImageView>(R.id.previewImage)

        mainImageView.preview = preview
    }
}