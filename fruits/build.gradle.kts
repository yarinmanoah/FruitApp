plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.fruitapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fruitapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
}


dependencies {
    implementation("com.appsflyer:af-android-sdk:6.12.5")
    implementation("com.android.installreferrer:installreferrer:2.2")
    implementation ("com.squareup.retrofit:retrofit:2.0.0-beta1")
    implementation ("com.squareup.okhttp:okhttp:2.4.0")
    implementation("com.squareup.retrofit:converter-gson:2.0.0-beta1")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(project(":food"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}