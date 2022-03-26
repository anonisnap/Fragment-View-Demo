package com.github.anonisnap.fragmentviewdemo.ui.sub_page_one

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SubPageOneViewModel(application: Application?) : AndroidViewModel(application!!) {
    private val mText: MutableLiveData<String?>
    val text: LiveData<String?>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is the First Sub Page"
    }
}