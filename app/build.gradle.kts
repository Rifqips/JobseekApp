plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "id.rifqipadisiliwangi.jobseekapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "id.rifqipadisiliwangi.jobseekapp"
        minSdk = 24
        targetSdk = 33
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
    packagingOptions{
        "META-INF/DEPENDENCIES"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {


    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Image Service
    implementation("com.github.bumptech.glide:glide:4.13.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")

    // RxJava3 support for paging library
    implementation("androidx.paging:paging-runtime-ktx:3.0.0-beta01")
    implementation("androidx.paging:paging-rxjava3:3.2.1")

    //Dagger hilt
    implementation("com.google.dagger:hilt-android:2.39.1")
    implementation("com.google.dagger:hilt-android-compiler:2.39.1")
}