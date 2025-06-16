# Mono-Repo Template

This repository contains a template to create a new Git repository with an Android application and the necessary KMP modules for its proper functioning. A folder is prepared to host the iOS application, which should be directly created using Xcode. For more details, refer to the `README.md` file in the `Template_iOS` folder.

This template allows configuration of the architecture type (classic or feature-module-based) as well as the choice of the database and network library.

For more information about the different architecture types and configuration options, refer to the sections below.

---

## How to Create a New Project?

1. Click on "Use this template".
2. Clone your new repository on your computer.
3. Ensure you have Python 3 installed on your computer.
4. Run the command `python3 init.py` and follow the terminal instructions.
5. Open your new project with Android Studio.
6. Run a Gradle synchronization.

---

## Architectures

### Classic Architecture

The classic architecture is the one we have most commonly used up until now. The diagram below illustrates the dependencies between the various modules.

**Important Note:** As of December 2024, we have decided to remove interfaces at the datasource level.


![Diagramme sans nom drawio](https://github.com/user-attachments/assets/54db8885-2395-495e-a4b6-7b8a56cab3a5)

The `kmp-shared` module uses all other modules for dependency injection. The arrows have been omitted to avoid overloading the diagram.

- **Android** uses the module only to expose dependency injection.
- **iOS** uses the module as the entry point for KMP.

The `domain` module automatically exposes the `data` module and the `error` module.

**Important Note:** Applications should never have access to repositories or the contents of the `local` and `remote` modules.

---

### Feature-Based Architecture

The feature-based architecture segments the code by functionalities while allowing for a shared base (e.g., a user can be used in both the `feature-profile` module and the `feature-share` module). This architecture enables greater modularity.

**Important Note:** As of December 2024, we have decided to remove interfaces at the datasource level.
**Important Note:** As of May 2025, we (Rémi) have decided to re-add interfaces at the datasource level to avoid using Android plugin everywhere.

![Copie de Diagramme sans nom drawio](https://github.com/user-attachments/assets/241cedfd-869d-44d9-9210-1da997e96226)

The `kmp-shared` module uses all other modules for dependency injection. The arrows have been omitted to avoid overloading the diagram.

- **Android** has `features-ui` modules that retrieve the KMP feature modules.
- KMP feature modules can use as many `data` and `repository` modules as needed. However, a feature module should not depend on another feature module.
- Feature modules automatically expose the `data` and `error` modules.
- **iOS** uses the module as the entry point for KMP.
- `remote` and `local` can use all data modules.

**Important Note:** Applications should never have access to repositories or the contents of the `local` and `remote` modules.

---

## Database

Currently, we support the choice between **Room** or no database. Room is already configured and ready to be used in your new project!

**Important Note:** If you choose to use Room, your project will not compile until you have added at least one entity.

---

## Network

Currently, we support the choice between **Ktor** or no network call management. Ktor is used via one of our libraries, which simplifies tasks such as error handling.

---

_Last Updated: Wednesday, December 11, 2024_
