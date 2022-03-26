package com.github.anonisnap.fragmentviewdemo.ui.page_one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.github.anonisnap.fragmentviewdemo.R
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentMainPrimaryBinding

class PrimaryMainFragment : Fragment() {
    private var binding: FragmentMainPrimaryBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(PrimaryViewModel::class.java)
        binding = FragmentMainPrimaryBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textHeaderPrimary
        viewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }

        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        // INFO: This is where you would add more code, if you need it to be run on Page Initialisation

        // INFO: Binds the Button's "OnClick" to the Lambda Expression for navigating to the Sub Page
        binding!!.navigateToSubPage.setOnClickListener { view: View? -> NavHostFragment.findNavController(this).navigate(R.id.action_nav_main_page_to_nav_sub_page) }

        // ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~ ~~
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}