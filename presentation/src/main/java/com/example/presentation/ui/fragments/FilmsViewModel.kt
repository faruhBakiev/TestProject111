package com.example.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.example.domain.either.Either
import com.example.domain.usecase.FetchFilmsUseCase
import com.example.presentation.models.FilmsResponseUI
import com.example.presentation.ui.base.BaseViewModel
import com.example.presentation.models.toUi
import com.example.presentation.ui.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val fetchFilmsUseCase: FetchFilmsUseCase
) : BaseViewModel(){

    init {
        fetchFilms()
    }

    private val _filmsState =
        MutableStateFlow<UIState<List<FilmsResponseUI>>>(UIState.Loading())
    val filmsState = _filmsState.asStateFlow()

    private fun fetchFilms() {
        viewModelScope.launch {
            fetchFilmsUseCase.invoke().collect { either ->
                when (either) {
                    is Either.Left -> {
                        either.message?.let {
                            _filmsState.value = UIState.Error(either.message.toString())
                        }
                    }
                    is Either.Right -> {
                        either.data?.let { data->
                            _filmsState.value = UIState.Success(data.map { item->
                                item.toUi()
                            })
                        }
                    }
                }
            }
        }
    }
}