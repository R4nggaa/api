package com.example.api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.api.Model.Movie
import com.example.api.View.MovieItem
import com.example.api.ViewModel.MovieViewModel
import com.example.api.ui.theme.ApiTheme

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiTheme {

                val movieList by movieViewModel.movieListResponse
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LaunchedEffect(key1 = Unit, block = {
                        movieViewModel.getMovieList()
                    })
                    MovieList(movieList = movieList)


                }

            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn{
        itemsIndexed(items = movieList){index, item ->
            MovieItem(movie = item)
        }
    }
    
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiTheme {
        val movie = Movie("Developer says", "", "Hi guys", "01")
        MovieItem(movie = movie)

    }
}