package com.c3rberuss.myvocabulary.presentation.list

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c3rberuss.core.domain.Verb
import com.c3rberuss.myvocabulary.framework.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VerbsViewModel @ViewModelInject constructor(private val interactors: Interactors) :
    ViewModel() {

    val verbs = MutableLiveData<List<Verb>>(listOf())

    init {
        Log.d("VIEWMODEL", "init: CALLED")
        obtainVerbs()
    }

    fun obtainVerbs() {
        viewModelScope.launch(Dispatchers.IO) {
            verbs.postValue(interactors.getAllVerbs())
        }
    }
}