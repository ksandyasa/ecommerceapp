package com.sehatqtestengineer.viewmodel

import androidx.lifecycle.LiveData
import com.sehatqtestengineer.repository.ValidationRepository

class LoginViewModel: BaseViewModel() {

    private var validationRepository: ValidationRepository

    init {
        validationRepository = ValidationRepository()
    }

    fun validateCredentials(username: String, passWord: String): LiveData<String>{
        return validationRepository.validateCredentials(username, passWord)
    }

}