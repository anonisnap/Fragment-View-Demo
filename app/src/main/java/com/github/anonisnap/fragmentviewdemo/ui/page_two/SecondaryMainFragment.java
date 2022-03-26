package com.github.anonisnap.fragmentviewdemo.ui.page_two;

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
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentMainSecondaryBinding;

public class SecondaryMainFragment extends Fragment {

	private FragmentMainSecondaryBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		SecondaryViewModel viewModel = new ViewModelProvider(this).get(SecondaryViewModel.class);

		binding = FragmentMainSecondaryBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		final TextView textView = binding.textHeaderSecondary;
		viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		// INFO: This is where you would add more code, if you need it to be run on Page Initialisation

		// INFO: Sets the action for clicking the button. This is done with a Lambda Expression
		binding.navigateToSubPage.setOnClickListener(view -> {
			// INFO: First we create a Bundle, which will be used for transferring Data from this Fragment, into the next Fragment
			Bundle dataTransferBundle = new Bundle();
			String valueFromEditableTextField = binding.numberField.getText().toString();
			int dataToTransfer = Integer.parseInt(!valueFromEditableTextField.equals("") ? valueFromEditableTextField : "0");

			// Clear the Text from the Field
			binding.numberField.setText("");

			// INFO: The String in this method call is used to define the Key. To access the Data, you will need to use the same key
			dataTransferBundle.putInt("navigation_value", dataToTransfer);

			// INFO: After having created the Bundle, we will need to set up the Navigation, and add the Bundle to it
			NavHostFragment.findNavController(this)
					// Navigation can be done with the Actions defined in mobile_navigation.xml
					.navigate(R.id.action_nav_secondary_page_to_nav_sub_page_two, dataTransferBundle);
		});
		// ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}