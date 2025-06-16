plugins {
    `kmp-library-jvm-convention`
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.dataTemplate)
            implementation(projects.local)
            implementation(projects.remote)
        }
    }
}
