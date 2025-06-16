import studio.lunabee.plugins.StringsProvider

plugins {
    `android-library-convention`
    alias(libs.plugins.lbResources)
}

android {
    namespace = "template.core.res"
}

lbResources {
    provider = StringsProvider.Loco("")
}

dependencies {
    implementation(platform(libs.androidxComposeBom))

    implementation(libs.androidxComposeFoundation)
    api(libs.lbcCore)
}
