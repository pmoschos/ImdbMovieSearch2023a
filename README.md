# Movie Search App 🎥

## Overview 🌟
This Android application allows users to search for movies. Utilizing the IMDb API, it fetches and displays information about movies. Users can enter a movie title in the search field, and the app presents a list of relevant movies, complete with details like title, description, and image.

## Features 🚀
- **Search Functionality**: Users can enter a movie title to retrieve and display matching results.
- **RecyclerView**: Efficient display of movie listings.
- **Picasso Library**: Enables image loading and rendering.
- **Volley Library**: Manages network requests for movie data retrieval.

## Dependencies 📚
- **Volley**: Handles network requests.
- **Picasso**: Manages image loading.
- **Material Components**: Provides UI elements.

## Library Dependencies 📚
To work with network data and images, the application depends on two key libraries: Volley and Picasso. Add these dependencies to your `build.gradle` (Module: app) file:

- **Volley Library:** For network requests and data retrieval.
  ```gradle
  implementation 'com.android.volley:volley:1.2.1'
   ```
- **Picasso Library:** For image loading and caching.
  ```gradle
  implementation 'com.squareup.picasso:picasso:2.71828'
   ```

## Implementation Overview 🔍
- **ListView with Network Data:** Demonstrates how to populate a `ListView` with data fetched using Volley. This is essential for applications that require dynamic data retrieval from a server or an API.
- **Image Handling:** Showcases the use of Picasso to efficiently load and display images within the application. Picasso simplifies the process of image loading, caching, and display, making it a valuable tool for apps that handle a lot of images.

## Screenshots 📸
![image](https://github.com/pmoschos/ImdbMovieSearch2023a/assets/133533759/5e9a4d3f-b565-43cc-8454-f510a3a67f06)

## License 📄
This project is distributed under the MIT License. See `LICENSE` for more information.

## Contact 📧
Panagiotis Moschos - [pan.moschos86@gmail.com](mailto:your.email@example.com)

<h1 align=center>Happy Coding 👨‍💻 </h1>

<p align="center">
  Made with ❤️ by Panagiotis Moschos (https://github.com/pmoschos)
</p>
