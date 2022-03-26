package com.github.anonisnap.fragmentviewdemo.ui.sub_page_two;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.anonisnap.fragmentviewdemo.R;
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentSubPageOneBinding;
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentSubPageTwoBinding;
import com.github.anonisnap.fragmentviewdemo.ui.sub_page_one.SubPageOneViewModel;

public class SubPageTwoFragment extends Fragment {

	private FragmentSubPageTwoBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		SubPageTwoViewModel viewModel = new ViewModelProvider(this).get(SubPageTwoViewModel.class);

		binding = FragmentSubPageTwoBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		final TextView textView = binding.textHeaderSTwo;
		// INFO: This will bind the setText() method from TextView, to the LiveData present in the ViewModel. So when the LiveData changes, the setText will be called
		viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		// INFO: This is where you would add more code, if you need it to be run on Page Initialisation

		// INFO: 'navigation_value' would be defined from the location, which initiates the navigation to here
		int valueSentThroughNavigation = getArguments() != null ? getArguments().getInt("navigation_value") : 0; // getArguments != null -> get the value, else it'll just use 0
		viewModel.showNumberSentFromOtherFragment(valueSentThroughNavigation);

		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}