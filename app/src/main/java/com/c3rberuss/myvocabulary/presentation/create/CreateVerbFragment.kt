package com.c3rberuss.myvocabulary.presentation.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.c3rberuss.myvocabulary.databinding.FragmentCreateVerbBinding
import com.c3rberuss.myvocabulary.utils.hideKeyboard
import com.c3rberuss.myvocabulary.utils.setNavigationResult

class CreateVerbFragment : Fragment() {

    private val viewModel by activityViewModels<CreateVerbViewModel>()
    private lateinit var binding: FragmentCreateVerbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateVerbBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.baseForm.observe(viewLifecycleOwner, Observer {
            viewModel.validateData()
        })

        viewModel.presentProgressive.observe(viewLifecycleOwner, Observer {
            viewModel.validateData()
        })

        viewModel.past.observe(viewLifecycleOwner, Observer {
            viewModel.validateData()
        })

        binding.btnSaveVerb.setOnClickListener {
            viewModel.save()
            hideKeyboard()
            setNavigationResult("HELLO")
            findNavController().popBackStack()
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        }
    }
}