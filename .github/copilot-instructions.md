# Copilot instructions for AndroidPildoras

Overview
- This repository is a collection of small Android practice projects (Pildoras Informaticas course). Top-level folders: `MiAppPildorasCompose/`, `MiAppPildorasXml/`, `TrabajoConOperadores/`.
- Each subfolder is an independent Android Gradle project (has its own `gradlew` and `app/` module). Treat changes as module-local unless the change explicitly targets the root build files.

Quick local build & test
- Use the Gradle wrapper from the project you intend to build. Example (PowerShell):

  .\\TrabajoConOperadores\\gradlew.bat assembleDebug

- To run unit tests in a module:

  .\\MiAppPildorasCompose\\gradlew.bat testDebugUnitTest

- Common tasks: `assembleDebug`, `assembleRelease`, `connectedAndroidTest`, `clean`.

Project conventions & patterns
- Kotlin DSL Gradle (build.gradle.kts) is used across projects.
- Dependency versions are referenced with a version catalog alias pattern (see `plugins { alias(libs.plugins...) }` in module `build.gradle.kts`). If you need to add dependencies, follow the same pattern in the module's `build.gradle.kts`.
- ViewBinding is enabled in many modules (example: `TrabajoConOperadores/app/build.gradle.kts` has `buildFeatures.viewBinding = true`). Prefer using generated binding classes like `ActivityMainBinding` rather than findViewById where present.
- Simple UI examples use classic Android Views and Navigation components. Example: `TrabajoConOperadores/app/src/main/java/com/example/trabajoconoperadores/MainActivity.kt` demonstrates view binding and manual view lookups for EditText, Button, TextView.

Files to read when changing behavior
- Module entry points: `*/app/src/main/java/**/MainActivity.kt` and corresponding layouts under `*/app/src/main/res/layout/`.
- Gradle module configuration: `*/app/build.gradle.kts` (namespace, compileSdk, minSdk, viewBinding). Update these when changing SDK or features.
- Root project: `settings.gradle.kts` and each module's `gradle.properties` for project-wide properties.

Patterns to follow when editing code
- Keep changes module-scoped unless the task affects multiple modules or the root build. Update `versionCode`/`versionName` only in the target module's `defaultConfig`.
- When adding UI elements prefer updating layout XML in `app/src/main/res/layout/` and use view binding in the Activity/Fragment.
- Navigation: modules reference AndroidX Navigation (`androidx.navigation.fragment.ktx`, `androidx.navigation.ui.ktx`) in dependencies; follow those patterns when adding navigation actions.

Integration & external dependencies
- Projects use standard Google/AndroidX and Material libraries (see module `build.gradle.kts` for exact aliases).
- No external CI configuration found; assume local Gradle wrapper usage for builds.

Examples (copyable)
- Build `TrabajoConOperadores` debug APK (PowerShell):

  .\\TrabajoConOperadores\\gradlew.bat assembleDebug

- Run unit tests for `MiAppPildorasCompose` (PowerShell):

  .\\MiAppPildorasCompose\\gradlew.bat testDebugUnitTest

Why these choices
- The repo is a set of isolated exercises; keeping changes local to modules reduces cross-project side effects and simplifies testing.

When to ask for clarification
- If a change needs to update multiple modules' Gradle configs or the version catalog, ask which modules (or provide a single PR that updates all and explain the reason).

If you edit this file
- Preserve the top-level list of modules and any module-specific Gradle instructions. Keep examples in PowerShell form (this repo owner works on Windows).

Contact / Feedback
- After you finish a change, run `assembleDebug` for the module and a quick run of `lint` or `test` if available; report back any build or test failures.
