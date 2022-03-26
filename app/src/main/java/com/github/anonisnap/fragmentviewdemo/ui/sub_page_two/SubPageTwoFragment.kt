package com.github.anonisnap.fragmentviewdemo.ui.sub_page_two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentSubPageTwoBinding

class SubPageTwoFragment : Fragment() {
    private var binding: FragmentSubPageTwoBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(SubPageTwoViewModel::class.java)
        binding = FragmentSubPageTwoBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textHeaderSTwo
        // INFO: This will bind the setText() method from TextView, to the LiveData present in the ViewModel. So when the LiveData changes, the setText will be called
        viewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }

        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        // INFO: This is where you would add more code, if you need it to be run on Page Initialisation

        // INFO: 'navigation_value' would be defined from the location, which initiates the navigation to here
        val valueSentThroughNavigation = if (arguments != null) requireArguments().getInt("navigation_value") else 0 // getArguments != null -> get the value, else it'll just use 0
        viewModel.showNumberSentFromOtherFragment(valueSentThroughNavigation)

        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}