# Login Exam

___

Hi Seven Seven Global Services!

Thanks for taking the time to check out this Github Repository, This Readme serves as a guide and a glimpse on what to expect on this project

To access the app please use
username: admin
password: admin

To edit users please visit

com.aaa.localexamxaml.data.mock.LoginCredentialsMock

Hopefully, This project prove my worth and I am looking forward to working with you.

___

### Tech Stack

- Android
- Kotlin
- Dagger Hilt
- MVVM
- Lottie

### Project Structure

- com.aaa.loginexamxaml
  - data - This layer contains the data models and data access objects (DAOs) used throughout the application. It includes local data storage using Room and remote data fetching using Retrofit.
    - local - This directory supposed to contain the offline data storage using Room or SQLite.
    - remote- This directory contains the online data fetching preferraThis is the main application class that sets up the Dagger Hilt dependency injection framework and initializes the application.bly using Retrofit (It is using mockdata and is being simulated only to work like an API).
    - mock - This directory contains a sample mock data source.
    - repository - This directory is the collection of different data sources to be accessed
  - domain - This layer contains the business logic of the application.
    - model - This directory contains the models used in the application.
    - repository - This directory contains the repository implementations.
  - presentation - This is where the UI is being implemented
    - ui.screens - This is where the screens are being implemented
    - viewmodels - This is where the view models are being implemented
  - LoginExamApplication - This is the main application class that sets up the Dagger Hilt dependency injection framework and initializes the application.