import os
import shutil
from pathlib import Path


# Step 1: Get inputs from the user
def get_user_input(dest):
    app_name = os.path.basename(dest)
    app_id = input("Enter the application ID (e.g., studio.lunabee.app.android): ").strip().lower()
    package_name = input("Enter the package name (default = " + app_id + "): ").strip().lower() or app_id
    app_name = input("Enter the application name (default = " + app_name + "): ").strip().lower() or app_name
    while True:
        architectureChoice = input("What architecture do you want to use? Classic [c], Feature [f]: ").strip().lower()
        if architectureChoice not in ['c', 'f']:
            print("Expected value are Classic [c], Feature [f]")
        else:
            break
    while True:
        databaseChoice = input("What database do you want to use? Room [r], None [n]: ").strip().lower()
        if databaseChoice not in ['r', 'n']:
            print("Expected value are Room [r], None [c]")
        else:
            break
    while True:
        remoteChoice = input("What remote API do you want to use? Ktor [k], None [n]: ").strip().lower()
        if remoteChoice not in ['k', 'n']:
            print("Expected value are Ktor [k], None [c]")
        else:
            break
    return app_id, package_name, architectureChoice, databaseChoice, remoteChoice, app_name


# Step 2: Copy contents of src to dest while excluding specified patterns.
def remove_directory(dest):
    # Define the exclusion patterns
    exclusions = [
        "*/build",
        "*/.gradle",
        "*/.kotlin",
        "*/schemas",
        "classic.drawio",
        "feature.drawio",
        "init.py"
    ]
    for root, dirs, files in os.walk(dest, topdown=False):  # Use `topdown=False` to process child directories first
        # Process files
        for file in files:
            file_path = Path(root, file)
            if any(file_path.match(pattern) for pattern in exclusions):
                file_path.unlink()  # Delete the file

        # Process directories
        for dir in dirs:
            dir_path = Path(root, dir)
            if any(dir_path.match(pattern) for pattern in exclusions):
                shutil.rmtree(dir_path)  # Remove the directory and its contents


# Step 3: Handle the user choice for architecture: Classic or Feature.
def handle_architecture_choice(target_directory, choice):
    template_kmp_path = target_directory / "Template_KMP"
    template_android_path = target_directory / "Template_Android"
    if choice == 'c':
        classic_path = template_kmp_path / "classic"
        for item in classic_path.iterdir():
            shutil.move(str(item), str(template_kmp_path))
        shutil.rmtree(classic_path)
        feature_module_path = template_kmp_path / "feature-module"
        if feature_module_path.exists():
            shutil.rmtree(feature_module_path)
        feature_path = template_android_path / "feature"
        if feature_path.exists():
            shutil.rmtree(feature_path)
        replace_words_in_files(dest, ["classic/"], ["settings.gradle.kts"], "")
        clean_files(dest, ["feature-", "template"], ["settings.gradle.kts", "build.gradle.kts"])
    elif choice == 'f':
        feature_module_path = template_kmp_path / "feature-module"
        for item in feature_module_path.iterdir():
            shutil.move(str(item), str(template_kmp_path))
        shutil.rmtree(feature_module_path)
        classic_path = template_kmp_path / "classic"
        if classic_path.exists():
            shutil.rmtree(classic_path)
        replace_words_in_files(dest, ["feature-module/"], ["settings.gradle.kts"], "")
        clean_files(dest, ["classic", "\":domain\"", "\":data\"", "\":repository\""], ["settings.gradle.kts"])
        clean_files(dest, ["classic", "projects.domain", "projects.data", "projects.repository"], ["build.gradle.kts"])


def handle_database_choice(target_directory, choice):
    template_kmp_path = target_directory / "Template_KMP"
    if choice == 'n':
        room_path = template_kmp_path / "local-room"
        shutil.rmtree(room_path)
        clean_files(dest, ["local-room", "room", "sqlite", "Sqlite", "Room", "LocalDatasource"],
                    ["settings.gradle.kts", "build.gradle.kts", "libs.versions.toml", "KoinHelper.kt",
                     "KoinHelper.android.kt",
                     "KoinHelper.ios.kt"])
    elif choice == 'r':
        clean_files(dest, ["dao", "Dao"],
                    ["RoomAppDatabase.kt", "KoinHelper.kt", "KoinHelper.android.kt", "KoinHelper.ios.kt"])


def handle_remote_choice(target_directory, choice):
    template_kmp_path = target_directory / "Template_KMP"
    if choice == 'n':
        room_path = template_kmp_path / "remote-ktor"
        shutil.rmtree(room_path)
        clean_files(dest, ["remote-ktor", "ktor", "RemoteDatasource", "Ktor", "CoreHttpClient"],
                    ["settings.gradle.kts", "build.gradle.kts", "libs.versions.toml", "KoinHelper.kt",
                     "KoinHelper.android.kt",
                     "KoinHelper.ios.kt"])


def clean_files(directory, keywords, target_files):
    for root, _, files in os.walk(directory):
        for file in files:
            if file in target_files:
                file_path = Path(root, file)
                with file_path.open("r", encoding="utf-8") as f:
                    lines = f.readlines()

                # Filter out lines containing any of the keywords
                filtered_lines = [line for line in lines if not any(keyword in line for keyword in keywords)]

                # Write the cleaned content back to the file
                with file_path.open("w", encoding="utf-8") as f:
                    f.writelines(filtered_lines)


def replace_words_in_files(directory, keywords, target_files, toReplace):
    for root, _, files in os.walk(directory):
        for file in files:
            if file in target_files:
                file_path = Path(root, file)
                with file_path.open("r", encoding="utf-8") as f:
                    lines = f.readlines()
                # Remove the keywords from each line
                cleaned_lines = [
                    line for line in [line.replace(keyword, toReplace) for line in lines for keyword in keywords]
                ]
                # Write the modified content back to the file
                with file_path.open("w", encoding="utf-8") as f:
                    f.writelines(cleaned_lines)


def replace_template_with_package_name(directory, package_name):
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".kt"):
                replace_words_in_files(directory, ["template."], [file], package_name + ".")


def create_package_tree(target_directory, package_name, app_name):
    package_path = Path(*package_name.split('.'))
    kotlin_folders = list(target_directory.rglob("kotlin"))
    for kotlin_folder in kotlin_folders:
        template_path = kotlin_folder / "template"
        new_arborescence = kotlin_folder / package_path
        if template_path.exists():
            # Create the new arborescence
            new_arborescence.mkdir(parents=True, exist_ok=True)
            # Move existing content
            for item in template_path.rglob("*"):
                if item.is_file() or item.is_dir():
                    shutil.move(str(item), str(new_arborescence / item.name))
            # Remove unnecessary files
            for file in new_arborescence.rglob("*"):
                if file.is_file() and file.name not in [
                    "RoomAppDatabase.kt", "RoomAppDatabase.kt", "CoreHttpClient.kt", "KoinHelper.kt",
                    "KoinHelper.android.kt",
                    "KoinHelper.ios.kt", "MainActivity.kt", "CoreError.kt", "CoreRes.kt", "CoreColors.kt",
                    "CoreRadius.kt", "CoreSpacing.kt", "CoreTheme.kt", "CoreTypography.kt", app_name + "Application.kt"
                ]:
                    file.unlink()
            # Delete the template folder
            shutil.rmtree(template_path)
    clean_files(dest,
                ["Datasource", "UseCase", "TemplateRepository", "TemplateFeatureRepository", "KtorTemplateClient"],
                ["KoinHelper.kt", "KoinHelper.android.kt", "KoinHelper.ios.kt"])
    clean_files(dest, ["TemplateEntity", "Dao"], ["RoomAppDatabase.kt"])


def update_main_activity(target_directory):
    main_activity_path = target_directory.rglob("MainActivity.kt")
    for file in main_activity_path:
        file_content = """package template.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import template.core.ui.theme.CoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreTheme {
            }
        }
    }
}
"""
        file.write_text(file_content, encoding="utf-8")


def update_template_app(target_directory, app_name):
    template_app_path = list(target_directory.rglob("TemplateApp.kt"))
    for file in template_app_path:
        file_content = f"""package template.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import template.shared.KoinHelper

class {app_name}Application : Application() {{
    override fun onCreate() {{
        super.onCreate()
        KoinHelper.init {{
            androidContext(this@{app_name}Application)
        }}
    }}
}}
"""
        file.write_text(file_content, encoding="utf-8")
        new_file_name = file.with_name(f"{app_name}Application.kt")
        file.rename(new_file_name)


def rename_template_directories(base_path, app_name):
    directories = {
        "Template_iOS": f"{app_name}_iOS",
        "Template_KMP": f"{app_name}_KMP",
        "Template_Android": f"{app_name}_Android",
    }
    for old_name, new_name in directories.items():
        old_path = os.path.join(base_path, old_name)
        new_path = os.path.join(base_path, new_name)
        if os.path.exists(old_path):
            os.rename(old_path, new_path)


if __name__ == "__main__":
    dest = Path.cwd()
    app_id, package_name, architectureChoice, databaseChoice, remoteChoice, app_name = get_user_input(dest)
    handle_architecture_choice(dest, architectureChoice)
    handle_database_choice(dest, databaseChoice)
    handle_remote_choice(dest, remoteChoice)
    update_main_activity(dest)
    update_template_app(dest, app_name)
    create_package_tree(dest, package_name, app_name)
    replace_words_in_files(dest, ["templateApplicationId"], ["ProjectConfig.kt"], app_id)
    replace_words_in_files(dest, ["templatePackageId"], ["ProjectConfig.kt"], package_name)
    replace_words_in_files(dest, ["TemplateApp"], ["AndroidManifest.xml"], app_name + "Application")
    replace_words_in_files(dest, ["Template"], ["appname_string.xml"], app_name)
    replace_words_in_files(dest, ["template."], ["AndroidManifest.xml"], package_name + ".")
    replace_template_with_package_name(dest, package_name)
    replace_words_in_files(dest, ["Template_"], ["settings.gradle.kts"], app_name + "_")
    replace_words_in_files(dest, ["rootProject.name = \"Template\""], ["settings.gradle.kts"],
                           "rootProject.name = \"" + app_name + "\"")
    rename_template_directories(dest, app_name)
    old_path = os.path.join(dest, ".github")
    shutil.rmtree(old_path)
    github_path = os.path.join(dest, "github")
    new_github_path = os.path.join(dest, ".github")
    os.rename(github_path, new_github_path)
    os.remove("renovate.json")
    os.rename("_renovate.json", "renovate.json")
    replace_words_in_files(dest, ["Template_"], ["CODEOWNERS", "labeler.yml"], app_name + "_")
    remove_directory(dest)
    print("Done!")
