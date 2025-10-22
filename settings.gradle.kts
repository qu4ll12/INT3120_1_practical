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
include(":unit4_pathway2_cupcake")
include(":unit4_pathway2_lunchtray")
include(":unit4_pathway3_reply")
include(":unit4_pathway3_sports")
include(":menupicker")
include(":unit5_pathway1_racetracker")
include(":unit5_pathway1_marphotos")
include(":unit5_pathway2_amphibians")
include(":unit6_pathway2_inventory")
include(":unit6_pathway2_busschedule")
include(":unit6_pathway3_dessertrelease")
include(":nine_patch")
include(":unit7_pathway1_bluromatic")
include(":unit7_pathway1_waterme")
