package com.mandeep.newsplashapi

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mandeep.newsplashapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var splashScreen: SplashScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen = installSplashScreen()
        setupSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupSplashScreen() {
        splashScreen.setKeepOnScreenCondition { false }
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val slideBack = ObjectAnimator.ofFloat(
                splashScreenView.view,
                View.TRANSLATION_X,
                0f,
                -splashScreenView.view.width.toFloat()
            ).apply {
                interpolator = DecelerateInterpolator()
                duration = 3000L
                doOnEnd { splashScreenView.remove() }
            }
            slideBack.start()
        }
    }
}