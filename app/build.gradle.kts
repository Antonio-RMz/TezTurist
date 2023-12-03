@file:Suppress("UNUSED_EXPRESSION")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.tezturist"
    compileSdk = 34

    defaultConfig {
        buildFeatures{
            viewBinding = true
        }
        applicationId = "com.example.tezturist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    testImplementation("junit:junit:4.13.2")

//para caruusel
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.github.bumptech.glide:glide:4.16.0")


    //firebase
    //dependencia para Firebase Realtime
    implementation ("com.firebaseui:firebase-ui-database:8.0.2")

    //dependencia para CircleImageView
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //dependencia para Glide
    //implementation ("com.github.bumptech.glide:glide:4.16.0")
    //dependencias para el cardView
    implementation ("androidx.cardview:cardview:1.0.0")
    //recyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")


// material design 3
    implementation ("androidx.compose.material3:material3:1.0.1")
    implementation ("androidx.compose.material3:material3-window-size-class:1.0.1")

//para google maps
    implementation ("com.google.android.gms:play-services-maps:18.1.0")


    // Implementar los servicios de Google
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    //implementation("com.android.tools.build:gradle:7.4.1")

    //imagenes de clima
    implementation ("com.squareup.picasso:picasso:2.71828")
    



}