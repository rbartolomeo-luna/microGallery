plugins {
    `kmp-library-android-convention`
    alias(libs.plugins.kotlinxSerialization)
}

android {
    namespace = "template.remote"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.lbBom))

            implementation(libs.kotlinxSerializationJson)
            implementation(libs.lbCore)
            implementation(libs.lbKtorCore)
            implementation(libs.lbKtorJson)
            implementation(libs.lbKtorKermit)

            implementation(projects.data)
            implementation(projects.dataTemplate)
            implementation(projects.error)
            implementation(projects.remote)
        }
    }
}
