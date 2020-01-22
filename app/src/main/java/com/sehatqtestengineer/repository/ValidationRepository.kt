package com.sehatqtestengineer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.regex.Pattern


class ValidationRepository {

    fun validateCredentials(userName: String, passWord: String): LiveData<String> {
        val loginErrorMessage = MutableLiveData<String>()
        if (isUserNameValid(userName)) {
            if (passWord.length < 5) {
                loginErrorMessage.value = "Password must more than 4 character"
            } else if (!(isPasswordValid(passWord))) {
                loginErrorMessage.value = "Invalid Password"
            } else {
                loginErrorMessage.value = "Successful Login"
            }
        } else {
            loginErrorMessage.value = "Invalid Username"
        }

        return loginErrorMessage
    }

    fun isUserNameValid(username: String): Boolean {
        return if(username != "") true else false
    }

    fun isPasswordValid(password: String): Boolean{
        return if(password != "") true else false
    }

}