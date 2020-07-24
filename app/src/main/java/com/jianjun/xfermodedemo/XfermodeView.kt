package com.jianjun.xfermodedemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class XfermodeView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var curXfermode: PorterDuffXfermode? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, -1)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        paint.color = Color.parseColor("#985157")
        canvas?.drawCircle(width / 2f, height / 2f, width / 3f, paint)
        paint.color = Color.parseColor("#D4BFA5")
        curXfermode?.let {
            paint.xfermode = it
        }
        canvas?.drawRect(width / 2f, height / 2f, width.toFloat(), height.toFloat(), paint)
        paint.xfermode = null
        canvas?.restore()
    }

    fun setXfermode(mode: PorterDuff.Mode) {
        curXfermode = PorterDuffXfermode(mode)
        invalidate()
    }
}