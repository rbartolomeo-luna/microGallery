plugins {
    `android-library-convention`
}

lbAndroidLibrary {
    android {
        namespace = "template.core.ui"
        withCompose = true
    }
}

dependencies {
    implementation(platform(libs.androidxComposeBom))

    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeUi)

    api(projects.coreRes)
}
