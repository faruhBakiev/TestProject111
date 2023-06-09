plugins {
//    id("com.android.library")
//    id("org.jetbrains.kotlin.android")
    Plugins.apply {
        id(androidLibrary)
        id(kotlinJetbrains)
        id(hilt)
        kotlin(kapt)
    }
//    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.presentation"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
        jvmTarget = Config.jvmTarget
    }
    buildFeatures.viewBinding = true

}

dependencies {

    Dependencies.ViewBinding.apply {
        // ViewBindingPropertyDelegate
        implementation(viewBinding)
    }

    Dependencies.Navigation.apply {
        // Navigation
        implementation(navigationFragment)
        implementation(navigation)
    }

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    Dependencies.UiComponents.apply {
        implementation(core)
        // AppCompat
        implementation(appCompat)
        // Material Design
        implementation(material)
        // UI Components
        implementation(constraint)
    }
    implementation(project (":domain"))

    Dependencies.Hilt.apply {
        //Hilt
        implementation(hilt)
        kapt(hiltCompiler)
    }
// Domain
    implementation(project (":domain"))

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Gson convertor
    implementation ("com.google.code.gson:gson:2.9.0")

    //OkHttp client
    implementation ("com.squareup.okhttp3:okhttp-bom:4.10.0")

    // define any required OkHttp artifacts without version
    implementation ("com.squareup.okhttp3:okhttp")
    implementation ("com.squareup.okhttp3:logging-interceptor")
}