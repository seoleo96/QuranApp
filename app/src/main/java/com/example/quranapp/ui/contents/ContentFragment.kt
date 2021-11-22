package com.example.quranapp.ui.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.quranapp.R
import com.example.quranapp.core.App
import com.example.quranapp.databinding.FragmentContentBinding

class ContentFragment : Fragment(R.layout.fragment_content) {

    private lateinit var contentViewModel: ContentViewModel
    private var _binding: FragmentContentBinding? = null
    private val navArgs : ContentFragmentArgs by navArgs<ContentFragmentArgs>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        contentViewModel = (activity?.application as App).contentViewModel

        _binding = FragmentContentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Toast.makeText(requireContext(), navArgs.contentId.toString(), Toast.LENGTH_SHORT).show()
        val rv = binding.rv
        val adapter = ContentAdapter()
        rv.adapter = adapter
        contentViewModel.fetchChapters()
        contentViewModel.observe(viewLifecycleOwner, { contents ->
            adapter.updateList(contents, navArgs.contentId)
        })
        rv.addItemDecoration(DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL))
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}