package com.github.anonisnap.fragmentviewdemo.ui.sub_page_one;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubPageOneViewModel extends AndroidViewModel {

	private final MutableLiveData<String> mText;

	public SubPageOneViewModel(Application application) {
		super(application);
		mText = new MutableLiveData<>();
		mText.setValue("This is the First Sub Page");
	}

	public LiveData<String> getText() {
		return mText;
	}
}