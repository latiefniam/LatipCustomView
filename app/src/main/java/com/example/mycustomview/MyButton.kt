package com.example.mycustomview

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import java.util.jar.Attributes

class MyButton : AppCompatButton {

    private var enableBackground: Drawable? = null
    private var disableBackground: Drawable? = null
    private var txtColor: Int= 0

    constructor(context: Context):super(context){
    init()
    }
    constructor(context: Context, attrs: AttributeSet):super(context,attrs){
    init()
    }
    constructor(context: Context,attrs: AttributeSet,defStyleAttr:Int):super(context, attrs, defStyleAttr){
    init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background= when{
            isEnabled->enableBackground
            else->disableBackground
        }

        setTextColor(txtColor)
        textSize=12f
        gravity=Gravity.CENTER
        text=when{
            isEnabled->"Submit"
            else->"Isi dulu"
        }
    }
    private fun init(){
        txtColor = ContextCompat.getColor(context,android.R.color.background_light)
        enableBackground=ResourcesCompat.getDrawable(resources,R.drawable.bg_button,null)
        disableBackground=ResourcesCompat.getDrawable(resources,R.drawable.bg_button_disable,null)

    }

}

