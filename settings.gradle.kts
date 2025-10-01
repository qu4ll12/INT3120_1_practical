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

rootProject.name = "Mobile Homework"
include(":app")
include(":unit1_pathway2_firstandroidapp")
include(":unit1_pathway3_happybirthday")
include(":unit1_pathway3_composearticle")
include(":unit1_pathway3_taskmanager")
include(":unit1_pathway3_composequadrant")
include(":unit1_pathway3_businessapp")
include(":unit2_pathway2_diceroller")
include(":unit2_pathway3_calculator")
include(":unit2_pathway3_customtipcalculator")
include(":unit2_pathway3_artspace")
include(":unit3_pathway2_affirmationapp")
include(":unit3_pathway3_woofapp")
include(":unit3_pathway3_superheroes")
include(":unit4_pathway1_dessertclicker")
include(":unit4_pathway1_unscramble")
