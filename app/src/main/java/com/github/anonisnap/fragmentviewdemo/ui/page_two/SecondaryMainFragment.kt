package com.github.anonisnap.fragmentviewdemo.ui.page_two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.github.anonisnap.fragmentviewdemo.R
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentMainSecondaryBinding

class SecondaryMainFragment : Fragment() {
    private var binding: FragmentMainSecondaryBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(SecondaryViewModel::class.java)
        binding = FragmentMainSecondaryBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textHeaderSecondary
        viewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }

        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        // INFO: This is where you would add more code, if you need it to be run on Page Initialisation

        // INFO: Sets the action for clicking the button. This is done with a Lambda Expression
        binding!!.navigateToSubPage.setOnClickListener { view: View? ->
            // INFO: First we create a Bundle, which will be used for transferring Data from this Fragment, into the next Fragment
            val dataTransferBundle = Bundle()
            val valueFromEditableTextField = binding!!.numberField.text.toString()
            val dataToTransfer: Int = if (valueFromEditableTextField != "") valueFromEditableTextField.toInt() else 0

            // Clear the Text from the Field
            binding!!.numberField.setText("")

            // INFO: The String in this method call is used to define the Key. To access the Data, you will need to use the same key
            dataTransferBundle.putInt("navigation_value", dataToTransfer)

            // INFO: After having created the Bundle, we will need to set up the Navigation, and add the Bundle to it
            NavHostFragment.findNavController(this) // Navigation can be done with the Actions defined in mobile_navigation.xml
                    .navigate(R.id.action_nav_secondary_page_to_nav_sub_page_two, dataTransferBundle)
        }
        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}