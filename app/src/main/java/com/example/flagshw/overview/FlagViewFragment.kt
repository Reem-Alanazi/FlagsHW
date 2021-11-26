package com.example.flagshw.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.flagshw.R
import com.example.flagshw.databinding.FragmentFlagViewBinding


class FlagViewFragment : Fragment() {
    val viewModel: FlagViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFlagViewBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root//inflater.inflate(R.layout.fragment_flag_view, container, false)
    }
}