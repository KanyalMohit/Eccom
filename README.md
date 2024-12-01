# E-Commerce App

An Android eCommerce application built with **Dagger Hilt**, **Firebase**, and **Jetpack Compose**. This project aims to provide users with a seamless online shopping experience, offering features such as user authentication, product browsing, wishlist management, and more.

---

## Features

- 🔒 **User Authentication**: Secure login and logout functionality using **Firebase Authentication**. Users can sign in with email/password or Google login.
- 🏬 **Product Categories**: Browse products organized into categories like **Winter**, **Summer**, **Pants**, **Shoes**, **Accessories**, **Furniture**, **Electronics**, and **Games**.
- 🌟 **Wishlist**: Users can add their favorite products to the wishlist for easy access later.
- 🛍️ **Explore and Home Screen**: Discover curated products tailored to the user's interests and needs.
- 👤 **User Account**: Users can view and manage their profile, including their address, contact information, and other details.
- 🛒 **Cart**: Users can add, remove, and manage items in their cart.
- 📦 **Order History**: Track previous orders and their details.

---

## Tech Stack

- **Frontend**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Declarative UI toolkit)
- **Backend**: [Firebase](https://firebase.google.com/) (Authentication, Firestore Database, Storage)
  - **Firebase Authentication**: For user login and registration.
  - **Cloud Firestore**: To store user data, cart, wishlist, and order history.
  - **Firebase Storage**: To store and fetch product images.
- **Dependency Injection**: [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt) (Simplified DI for better code management)
- **Programming Language**: [Kotlin](https://kotlinlang.org/)

---

## Installation

### Prerequisites

Before running the application, ensure that you have the following installed:

- [Android Studio](https://developer.android.com/studio) (for building and running the app)
- A Firebase project set up in the Firebase Console.
  - [Set up Firebase for your Android project](https://firebase.google.com/docs/android/setup)

### Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/ecommerce-app.git
    cd ecommerce-app
    ```

2. Add your **Firebase project** to the app:
   - Go to the Firebase Console and create a new project.
   - Add the `google-services.json` file to the `app/` directory of your project.
   - Follow the setup instructions on Firebase for **Authentication** (email/password, Google sign-in) and **Firestore Database**.

3. Install dependencies:

    ```bash
    ./gradlew build
    ```

4. Run the app on an emulator or physical device.

---

