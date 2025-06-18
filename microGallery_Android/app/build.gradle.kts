plugins {
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.lbAndroidApplication)
    //id("kotlin-kapt")
    //alias(libs.plugins.daggerHilt)
    alias(libs.plugins.lbAndroidFlavors)
    //alias(libs.plugins.ksp)

}

android {
    namespace = "studio.lunabee.amicrogallery.app"
    defaultConfig {
        versionCode = ProjectConfig.Android.envVersionCode
        versionName = ProjectConfig.Android.envVersionName
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {
    implementation(libs.androidxNavigationCompose)
    coreLibraryDesugaring(libs.desugarJdkLibs)
    implementation(platform(libs.androidxComposeBom))
    implementation(platform(libs.lbBom))
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.lbCore)
    implementation(libs.lbcPresenter)
    implementation(projects.coreUi)
    implementation(projects.domain)
    implementation(projects.shared)
}
