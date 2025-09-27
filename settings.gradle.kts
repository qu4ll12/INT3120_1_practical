pluginManagement {
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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BusinessCard"
include(":app")
include(":affirmations")
include(":courses")
include(":absolutelayoutdemo")
include(":unit2_pathway1_diceroller")
include(":unit2_pathway2_lemonade")
include(":demo")
include(":musicdemo")
include(":unit1_pathway1_helloworld")
include(":unit2_pathway2_diceroller")
