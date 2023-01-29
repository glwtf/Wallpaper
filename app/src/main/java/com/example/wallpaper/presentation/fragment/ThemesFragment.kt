package com.example.wallpaper.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.wallpaper.databinding.FragmentThemesBinding
import com.example.wallpaper.presentation.recycleview.ThemeListAdapter
import com.example.wallpaper.presentation.viewmodel.ThemeFragmentViewModel
import java.lang.RuntimeException

class ThemesFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[ThemeFragmentViewModel::class.java]
    }

    private var _binding : FragmentThemesBinding? = null
    private val binding : FragmentThemesBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    private lateinit var rvAdapter: ThemeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentThemesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
        viewModel.ldTheme.observe(viewLifecycleOwner) {
            rvAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRecycleView() {
        val rvThemeList = binding.rvThemeList
        with(rvThemeList) {
            rvAdapter = ThemeListAdapter(context)
            adapter = rvAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        rvAdapter.onThemeItemClickListener = {

        }
    }

    companion object {

    }
}