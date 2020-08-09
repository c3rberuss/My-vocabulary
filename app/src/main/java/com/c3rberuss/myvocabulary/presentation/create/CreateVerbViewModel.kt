package com.c3rberuss.myvocabulary.presentation.create

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c3rberuss.core.domain.Verb
import com.c3rberuss.myvocabulary.framework.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateVerbViewModel @ViewModelInject constructor(private val interactors: Interactors) :
    ViewModel() {

    val baseForm = MutableLiveData<String?>()
    val presentProgressive = MutableLiveData<String?>()
    val past = MutableLiveData<String?>()

    val validData = MutableLiveData<Boolean>()

    init {
        validData.postValue(false)
    }

    fun validateData() {
        validData.postValue(
            baseForm.value?.isNotEmpty() ?: false &&
                    presentProgressive.value?.isNotEmpty() ?: false &&
                    past.value?.isNotEmpty() ?: false

        )
    }

    fun save() {
        viewModelScope.launch(Dispatchers.IO) {
            interactors.addVerb(
                Verb(
                    baseForm = baseForm.value ?: "",
                    presentProgressive = presentProgressive.value ?: "",
                    past = past.value ?: ""
                )
            )

            clearFields()
        }
    }

    fun clearFields() {
        validData.postValue(false)
        baseForm.postValue(null)
        presentProgressive.postValue(null)
        past.postValue(null)
    }
}