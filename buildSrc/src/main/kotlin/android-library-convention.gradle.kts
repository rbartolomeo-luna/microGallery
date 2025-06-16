import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

plugins {
    id("studio.lunabee.plugins.android.library")
}

android {
    defaultConfig {
        compileSdk = ProjectConfig.Android.COMPILE_SDK
        minSdk = ProjectConfig.Android.MIN_SDK
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
}

// FIXME workaround https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
val libs: LibrariesForLibs = the<LibrariesForLibs>()

dependencies {
    coreLibraryDesugaring(libs.desugarJdkLibs)
}
