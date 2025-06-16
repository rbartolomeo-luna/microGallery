plugins {
    `android-library-convention`
    alias(libs.plugins.kotlinxSerialization)
}

lbAndroidLibrary {
    android {
        namespace = "template.feature"
        withCompose = true
    }
}

dependencies {
    implementation(platform(libs.androidxComposeBom))

    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeUi)
    implementation(libs.androidxLifecycleViewModelKtx)
    implementation(libs.androidxNavigationCompose)
    implementation(libs.koinViewmodel)
    implementation(libs.lbcPresenter)

    implementation(projects.featureTemplate)
}
