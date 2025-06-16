plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.kotlinAndroid)
    implementation(libs.gradleAndroid)
    implementation(libs.kotlinCompose)
    implementation(libs.detekt)
    implementation(libs.lbAndroidLibraryPlugin)
    implementation(libs.lbMultiplatformLibrary)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
