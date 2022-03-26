package com.github.anonisnap.fragmentviewdemo.ui.sub_page_one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.anonisnap.fragmentviewdemo.databinding.FragmentSubPageOneBinding

class SubPageOneFragment : Fragment() {
    private var binding: FragmentSubPageOneBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(SubPageOneViewModel::class.java)
        binding = FragmentSubPageOneBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView = binding!!.textHeaderSOne
        viewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}