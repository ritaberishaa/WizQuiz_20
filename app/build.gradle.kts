plugins {
    alias(libs.plugins.android.application)

}

android {
    namespace = "com.example.wizquiz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wizquiz"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packaging {
        resources {
            excludes += "META-INF/NOTICE.md"
            excludes += "META-INF/LICENSE.md"
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Libraries for mail and activation
    implementation("com.sun.mail:android-mail:1.6.7")
    implementation("com.sun.mail:android-activation:1.6.7")

    // BCrypt library for password hashing
    implementation("org.mindrot:jbcrypt:0.4")

    // Room runtime
    implementation("androidx.room:room-runtime:2.5.2")

    // Annotation processor for Java projects
    annotationProcessor("androidx.room:room-compiler:2.5.2")

}