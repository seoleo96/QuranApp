package com.example.quranapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.quranapp.core.App
import com.example.quranapp.databinding.FragmentHomeBinding
import com.example.quranapp.ui.chapters.QuranAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        homeViewModel = (activity?.application as App).homeViewModel

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rv = binding.rv
        val adapter = QuranAdapter { id ->
            val action = HomeFragmentDirections.actionNavigationHomeToContentFragment(id)
            findNavController().navigate(action)
        }
        rv.adapter = adapter
        homeViewModel.fetchChapters()
        homeViewModel.observe(viewLifecycleOwner, { it ->
            adapter.updateList(it)
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