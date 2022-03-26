package com.github.anonisnap.fragmentviewdemo.ui.sub_page_two;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SubPageTwoViewModel extends AndroidViewModel {

	private final MutableLiveData<String> mText;

	public SubPageTwoViewModel(Application application) {
		super(application);
		mText = new MutableLiveData<>();
		mText.setValue("This is the Second Sub Page");
	}

	public void showNumberSentFromOtherFragment(int number){
		mText.setValue("This is the Second Sub Page\nYou have typed " + number);
	}

	public LiveData<String> getText() {
		return mText;
	}
}