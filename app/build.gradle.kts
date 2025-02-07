
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services")
}

android {
    namespace = "br.edu.up.rgm33905380"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.edu.up.rgm33905380"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }

    lint {
        // TODO(thatfiredev): Remove this once
        //  https://github.com/bumptech/glide/issues/4940 is fixed
        disable.add("NotificationPermission")
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")

    // Also add the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:20.5.0")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib")

    implementation ("com.google.firebase:firebase-core:9.6.1")

    // Other Firebase/Play services deps
    implementation("com.google.firebase:firebase-auth-ktx")

    // Pinned to 20.7.0 as a workaround for issue https://github.com/firebase/quickstart-android/issues/1647
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    // FirebaseUI (for authentication)
    implementation("com.firebaseui:firebase-ui-auth:8.0.2")

    // Support Libs
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.vectordrawable:vectordrawable-animated:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.browser:browser:1.5.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.4")
    implementation("androidx.startup:startup-runtime:1.2.0")

    // Android architecture components
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.dataconnect)
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.8.7")

    // Third-party libraries
    implementation("me.zhanghai.android.materialratingbar:library:1.4.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")


    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-analytics")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}