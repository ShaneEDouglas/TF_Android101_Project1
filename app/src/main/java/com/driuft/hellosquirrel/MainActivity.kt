package com.driuft.hellosquirrel

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var profileName: TextView
    private lateinit var profileBio: TextView
    private lateinit var profilegif: ImageView
    private lateinit var secprofilegif: ImageView


    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureViews()
        setupProfile()
        circleImage()
        setupGifs()

    }

    private fun configureViews() {
        profileImage = findViewById(R.id.profile_image)
        profileName = findViewById(R.id.profile_name)
        profileBio = findViewById(R.id.profile_bio)
        profilegif = findViewById(R.id.star)
        secprofilegif = findViewById(R.id.secstar)
    }

    private fun setupProfile() {
        configureImage()
        configureName()
    }

    private fun circleImage() {
        Glide.with(this)
            .load(R.drawable.sddev)
            .circleCrop()
            .into(profileImage)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setupGifs() {
//
//        val source = ImageDecoder.createSource(resources, R.drawable.betterstargif)
//        val drawable: Drawable = ImageDecoder.decodeDrawable(source)
//        profilegif.setImageDrawable(drawable)
//        (drawable as? AnimatedImageDrawable)?.start()


        Glide.with(this)
            .asGif()
            .load(R.drawable.betterstargif)
            .into(profilegif)

        Glide.with(this)
            .asGif()
            .load(R.drawable.betterstargif)
            .into(secprofilegif)


    }

    private fun configureImage() {
        profileImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_launcher_foreground))
    }

    private fun configureName() {
        profileName.text = getString(
            R.string.full_name,
            getString(R.string.first_name),
            getString(R.string.last_name)
        )
    }
}