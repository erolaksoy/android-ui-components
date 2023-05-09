plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.mavenPublish)
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion

        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.kotlinCompilerExtensionVersion
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            setProguardFiles(
                mutableListOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    namespace = "com.trendyol.timelineviewcompose"
}

dependencies {

    val composeBom = platform(Dependencies.composeBom)
    implementation(composeBom)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeCoil)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeConstraintLayout)
}