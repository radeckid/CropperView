package pl.damrad.cropperview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView

class CropperView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        isFocusable = true
        isClickable = true
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    private var cutHeight: Float = 220f
    private var left: Float = 16f
    private var top: Float = 16f
    private var right: Float = 16f
    private var bottom: Float = 30f

    private val offset: Float = 110f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (top < 0f) {
            top = 0f
            bottom = 0f
        } else if (bottom + cutHeight > height) {
            bottom = height.toFloat()
            top = height - cutHeight
        }

        canvas?.drawRect(left, top, width - right, bottom + cutHeight, paint)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action?.and(MotionEvent.ACTION_MASK)) {
            MotionEvent.ACTION_DOWN -> {
                top = event.y + 16f - offset
                bottom = event.y + 30f - offset
            }
            MotionEvent.ACTION_MOVE -> {
                top = event.y + 16f - offset
                bottom = event.y + 30f - offset
            }
        }
        invalidate()
        return true
    }
}