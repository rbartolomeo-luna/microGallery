import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object ProjectConfig {
    const val GROUP_ID: String = "studio.lunabee.amicrogallery.android"
    val JDK_VERSION: JavaVersion = JavaVersion.VERSION_17
    val JVM_TARGET: JvmTarget = JvmTarget.JVM_17

    object Android {
        private const val VERSION_CODE: Int = 1
        private const val VERSION_NAME: String = "0.1.0"
        const val APPLICATION_ID: String = "studio.lunabee.amicrogallery.android"
        const val COMPILE_SDK: Int = 36
        const val TARGET_SDK: Int = COMPILE_SDK
        const val MIN_SDK: Int = 23

        val envVersionCode: Int = System.getenv("ANDROID_VERSION_CODE")?.toInt() ?: VERSION_CODE
        val envVersionName: String = System.getenv("ANDROID_VERSION_NAME") ?: VERSION_NAME
    }
}
