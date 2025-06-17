plugins {
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.lbAndroidApplication)
    alias(libs.plugins.lbAndroidFlavors)
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
    //implementation(libs.navigationRuntimeJvmstubs)
    implementation(libs.androidxHiltNavigationCompose)
    //implementation(libs.jetbrains.compose.ui.util)
    //implementation(libs.navigationComposeJvmstubs)
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
