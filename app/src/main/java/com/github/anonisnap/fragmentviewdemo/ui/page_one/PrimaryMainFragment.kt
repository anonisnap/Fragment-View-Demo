package com.github.anonisnap.fragmentviewdemo.ui.page_one;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.github.anonisnap.fragmentviewdemo.R;
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentMainPrimaryBinding;

public class PrimaryMainFragment extends Fragment {

	private FragmentMainPrimaryBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		PrimaryViewModel viewModel = new ViewModelProvider(this).get(PrimaryViewModel.class);

		binding = FragmentMainPrimaryBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		final TextView textView = binding.textHeaderPrimary;
		viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		// INFO: This is where you would add more code, if you need it to be run on Page Initialisation

		// INFO: Binds the Button's "OnClick" to the Lambda Expression for navigating to the Sub Page
		binding.navigateToSubPage.setOnClickListener(view -> NavHostFragment.findNavController(this).navigate(R.id.action_nav_main_page_to_nav_sub_page));

		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}