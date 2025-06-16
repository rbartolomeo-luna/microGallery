plugins {
    `kmp-library-android-convention`
}

android {
    namespace = "template.domain"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.dataTemplate)
            implementation(projects.repoTemplate)
        }
    }
}
