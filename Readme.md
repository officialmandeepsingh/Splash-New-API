# New Splash API

## Developer Details
```
Hi, My Name is Mandeep Singh, i'm shared android App code in kotlin with new Splash API.
I've Native Android Developer (Kotlin | Java) and Backend development (Node | Python).
```

## Contact details
```
Facebook: [Mandeep Singh](https://facebook.com/mandeepsinghpurwa/)
linkedin: [Mandeep Singh](https://in.linkedin.com/in/mandeepsinghpurwa)
```
## Implementation

### Step 1: Add this Library in your app level build.gradle.file and hit **"Sync now"**

` implementation 'androidx.core:core-splashscreen:1.0.0'`

### Step 2: add this code block to your theme.xml file

 ``` 
 <style name="Theme.App.SplashScreen" parent="Theme.SplashScreen">
    <item name="windowSplashScreenBackground">@color/purple_500</item>
    <item name="windowSplashScreenAnimatedIcon">@drawable/ic_launcher_foreground</item>
    <item name="windowSplashScreenAnimationDuration">200</item>
    <item name="postSplashScreenTheme">@style/Theme.NewSplashAPI</item>
</style>
```

Details about properties used in the above code:

1. **windowSplashScreenBackground** = The background color of your splash screen. Use it if you want a different and unique background color other than default white or black color according to light or dark modes.
2. **windowSplashScreenAnimatedIcon** = This is that static or animated vector drawable which will act as your main app icon. In case, you don’t use this property, your device will take the icon used in the mipmap folders of your app to display as a app icon in new splash screen, but somehow this thing is working fine in Android 12 devices but not proper for below Android 12 devices as they some default android icon instead of your app icon placed in mipmap folders.
3. **postSplashScreenTheme** = This property asks for your main app’s theme name which you want to use it after your splash screen thing finishes its job. Please provide value to this property otherwise your app’s overall theming will look scary post splash screen thing happens.
4. There are other properties also which you can add in here such as windowSplashScreenAnimationDuration, windowSplashScreenIconBackgroundColor, windowSplashScreenBrandingImage.

**Note**: Please keep your app icon ready in vector drawable format with recommended dimensions mentioned in the official documentation and then add here in the values of this property — **windowSplashScreenAnimatedIc**

### Step 3: Now update the theme name in the AndroidManifest.xml file with the newly created splash screen theme name

`android:theme="@style/Theme.App.SplashScreen"`

### Step 4: Now add this line in your launcher activity’s onCreate() method before setContentView() method

```
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen = installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
```

### Step 5: If you wants to add splash remove animations (optional)

```
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
```

