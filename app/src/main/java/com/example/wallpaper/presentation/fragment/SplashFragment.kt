package com.example.wallpaper.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.wallpaper.R
import com.example.wallpaper.databinding.FragmentSplashBinding
import com.example.wallpaper.presentation.viewmodel.SplashFragmentViewModel
import com.example.wallpaper.presentation.viewmodel.SplashFragmentViewModelFactory
import java.lang.RuntimeException

class SplashFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            SplashFragmentViewModelFactory(requireActivity().application)
        )[SplashFragmentViewModel::class.java]
    }

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding
        get() = _binding ?: throw  RuntimeException("FragmentSplashBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        viewModel.ldProgression.observe(viewLifecycleOwner) {
            if (it == SplashFragmentViewModel.READY)
                launchThemeFragment()
            else if (it == SplashFragmentViewModel.FAILED)
                tryAgain()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setOnClickListener() {
        val restartButton = binding.ibRestart

        restartButton.setOnClickListener {
            with(binding) {
                ibRestart.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            viewModel.loadThemes()
        }
    }

    private fun launchThemeFragment() {
        findNavController().navigate(
            SplashFragmentDirections.actionSplashFragmentToThemesFragment()
        )
    }

    private fun tryAgain() {
        with(binding) {
            ibRestart.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
        }
        Toast.makeText(activity, R.string.non_internet, Toast.LENGTH_LONG)
            .show()
    }
}