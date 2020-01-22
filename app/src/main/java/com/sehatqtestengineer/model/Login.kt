package com.sehatqtestengineer.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Login: BaseObservable() {

    var userName: String? = null
        @Bindable get() = field
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userName)
        }
    var userPassWord: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            notifyPropertyChanged(BR.userPassWord)
        }

}