package com.example.wallpaper.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.wallpaper.databinding.FragmentImagesBinding
import com.example.wallpaper.presentation.recycleview.ImageAdapter
import com.example.wallpaper.presentation.viewmodel.ImagesFragmentViewModel
import com.example.wallpaper.presentation.viewmodel.ImagesViewModelFactory
import java.lang.RuntimeException

class ImagesFragment : Fragment() {

    private val args by navArgs<ImagesFragmentArgs>()

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ImagesViewModelFactory(args.themeName)
        )[ImagesFragmentViewModel::class.java]
    }

    private var _binding : FragmentImagesBinding? = null
    private val binding : FragmentImagesBinding
        get() = _binding ?: throw RuntimeException("ThemesFragment == null")

    private lateinit var rvAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
        viewModel.ldImages.observe(viewLifecycleOwner) {
            rvAdapter.imageGallery = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRecycleView() {
        val rvImageList = binding.rvImageList
        with(rvImageList) {
            rvAdapter = ImageAdapter(context)
            adapter = rvAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        rvAdapter.onImageItemClickListener = {

        }
    }

    companion object {

    }
}