package com.github.anonisnap.fragmentviewdemo.ui.sub_page_one;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.anonisnap.fragmentviewdemo.databinding.FragmentSubPageOneBinding;

public class SubPageOneFragment extends Fragment {

	private FragmentSubPageOneBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		SubPageOneViewModel viewModel = new ViewModelProvider(this).get(SubPageOneViewModel.class);

		binding = FragmentSubPageOneBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		final TextView textView = binding.textHeaderSOne;
		viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}