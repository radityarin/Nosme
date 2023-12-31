package com.ftp.keberlanjutanumkmbsc.presentation.home.users.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ftp.keberlanjutanumkmbsc.databinding.FragmentHomeBinding
import com.ftp.keberlanjutanumkmbsc.utils.goToPerspektifPertamaKeuangan

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvWelcome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvIsiPerspektif.setOnClickListener {
            requireActivity().goToPerspektifPertamaKeuangan()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}