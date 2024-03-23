plugins {
    id("com.android.application")
}

android {
    namespace = "lk.nibm.pdsa.pentaplay.pentaplay_mobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "lk.nibm.pdsa.pentaplay.pentaplay_mobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Scalable Size Unit (support for different screen size)

    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")

    //Rounded Image View
    implementation ("com.makeramen:roundedimageview:2.3.0")

    //MultiDex
    implementation ("androidx.multidex:multidex:2.0.1")

    implementation ("com.android.volley:volley:1.2.1")
    implementation ("io.github.chaosleung:pinview:1.4.4")

    //Testing (jupiter)
    testImplementation ("org.junit.jupiter:junit-jupiter:5.8.0")

}