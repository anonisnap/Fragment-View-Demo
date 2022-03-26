package com.github.anonisnap.fragmentviewdemo.ui.page_two;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecondaryViewModel extends AndroidViewModel {

	private final MutableLiveData<String> mText;

	public SecondaryViewModel(Application application) {
		super(application);
		mText = new MutableLiveData<>();
		mText.setValue("This is the Secondary Main Page");
	}

	public LiveData<String> getText() {
		return mText;
	}
}