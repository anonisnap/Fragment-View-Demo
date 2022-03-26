package com.github.anonisnap.fragmentviewdemo.ui.sub_page_two

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SubPageTwoViewModel(application: Application?) : AndroidViewModel(application!!) {
    private val mText: MutableLiveData<String?>
    fun showNumberSentFromOtherFragment(number: Int) {
        mText.value = "This is the Second Sub Page\nYou have typed $number"
    }

    val text: LiveData<String?>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is the Second Sub Page"
    }
}