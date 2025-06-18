plugins {
    `android-library-convention`
}

lbAndroidLibrary {
    android {
        withCompose = true
    }
}

android {
    namespace = "studio.lunabee.amicrogallery.core.ui"
}

dependencies {
    implementation(platform(libs.androidxComposeBom))
    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeUi)
    implementation("androidx.compose.ui:ui-text-google-fonts:1.8.2")
    implementation("androidx.compose.material3:material3:1.4.0-alpha15")

    api(projects.coreRes)
    implementation(libs.activity.ktx)
    implementation(libs.navigation.runtime.android)

}
