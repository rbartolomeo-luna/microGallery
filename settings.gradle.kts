enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    val artifactoryUsername: String = providers.gradleProperty("artifactory_consumer_username")
        .getOrElse("library-consumer-public")
    val artifactoryPassword: String = providers.gradleProperty("artifactory_consumer_api_key")
        .getOrElse("AKCp8k8PbuxYXoLgvNpc5Aro1ytENk3rSyXCwQ71BA4byg3h7iuMyQ6Sd4ZmJtSJcr7XjwMej")

    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://artifactory.lunabee.studio/artifactory/lunabee-gradle-plugin/") {
            credentials {
                username = artifactoryUsername
                password = artifactoryPassword
            }
            mavenContent {
                releasesOnly()
            }
        }
    }
}

dependencyResolutionManagement {
    val artifactoryUsername: String = providers.gradleProperty("artifactory_consumer_username")
        .getOrElse("library-consumer-public")
    val artifactoryPassword: String = providers.gradleProperty("artifactory_consumer_api_key")
        .getOrElse("AKCp8k8PbuxYXoLgvNpc5Aro1ytENk3rSyXCwQ71BA4byg3h7iuMyQ6Sd4ZmJtSJcr7XjwMej")

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://artifactory.lunabee.studio/artifactory/libs-release-local") {
            credentials {
                username = artifactoryUsername
                password = artifactoryPassword
            }
            mavenContent {
                releasesOnly()
            }
        }
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/") {
            mavenContent {
                snapshotsOnly()
            }
        }
    }
}

plugins {
    id("studio.lunabee.plugins.cache") version "0.9.0"
}

rootProject.name = "Template"

include(":app")
include(":core-res")
include(":core-ui")
include(":remote")
include(":remote-ktor")
include(":local")
include(":local-room")
include(":shared")
include(":domain")
include(":data")
include(":repository")
include(":error")
include(":feature-template-ui")
include(":data-template")
include(":repo-template")
include(":feature-template")

project(":app").projectDir = File("Template_Android/app")
project(":core-res").projectDir = File("Template_Android/core-res")
project(":core-ui").projectDir = File("Template_Android/core-ui")
project(":feature-template-ui").projectDir = File("Template_Android/feature/feature-template-ui")
project(":remote").projectDir = File("Template_KMP/remote")
project(":remote-ktor").projectDir = File("Template_KMP/remote-ktor")
project(":local").projectDir = File("Template_KMP/local")
project(":local-room").projectDir = File("Template_KMP/local-room")
project(":domain").projectDir = File("Template_KMP/classic/domain")
project(":data").projectDir = File("Template_KMP/classic/data")
project(":repository").projectDir = File("Template_KMP/classic/repository")
project(":data-template").projectDir = File("Template_KMP/feature-module/data/template")
project(":repo-template").projectDir = File("Template_KMP/feature-module/repository/template")
project(":feature-template").projectDir = File("Template_KMP/feature-module/domain/feature-template")
project(":error").projectDir = File("Template_KMP/error")
project(":shared").projectDir = File("Template_KMP/shared")
