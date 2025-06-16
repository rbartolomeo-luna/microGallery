import org.gradle.accessors.dm.LibrariesForLibs
import studio.lunabee.plugins.TargetPlatform

plugins {
    id("studio.lunabee.plugins.multiplatform.library")
    id("android-library-convention")
}

// FIXME workaround https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
val libs: LibrariesForLibs = the<LibrariesForLibs>()

kotlin {
    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
            languageSettings.optIn("kotlin.uuid.ExperimentalUuidApi")
        }
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.kotlinxCoroutineBom))
            implementation(libs.kotlinxCoroutineCore)
        }
    }
}

lbMultiplatformLibrary {
    multiplatform {
        jvmTarget = ProjectConfig.JVM_TARGET
        targets = listOf(
            TargetPlatform.Android(),
            TargetPlatform.Ios(),
        )
    }
}
