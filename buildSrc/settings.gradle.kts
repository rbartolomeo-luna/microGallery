dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
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
        maven("https://artifactory.lunabee.studio/artifactory/lunabee-gradle-plugin/") {
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

rootProject.name = "buildSrc"
