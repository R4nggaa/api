package com.example.api.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.Model.BaseMedicalRecord

import com.example.api.Network.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel:ViewModel() {
    var movieListResponse:MutableState<List<BaseMedicalRecord>> = mutableStateOf(emptyList())
    var errorMessage: String by mutableStateOf("error bung")

    fun getMovieList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try{
                val movielist = apiService.getMovies()
                movieListResponse.value = movielist
            }
            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}