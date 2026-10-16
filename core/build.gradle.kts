plugins {
    id("org.jetbrains.kotlin.multiplatform") version "2.0.21"
    id("com.android.library")
}

kotlin {
    androidTarget()
    jvm()
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
            }
        }
        val androidMain by getting
        val jvmMain by getting
    }
}

android {
    namespace = "com.gurukul.core"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 26
    }
}
