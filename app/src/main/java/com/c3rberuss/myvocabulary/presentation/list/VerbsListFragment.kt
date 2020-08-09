package com.c3rberuss.myvocabulary.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.c3rberuss.myvocabulary.R
import com.c3rberuss.myvocabulary.databinding.FragmentVerbsListBinding
import com.c3rberuss.myvocabulary.utils.getNavigationResult

class VerbsListFragment : Fragment() {

    private val viewModel by activityViewModels<VerbsViewModel>()
    private lateinit var adapter: VerbsListAdapter
    private lateinit var binding: FragmentVerbsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerbsListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verbsList.layoutManager = LinearLayoutManager(requireContext())
        adapter = VerbsListAdapter(requireContext())
        binding.verbsList.adapter = adapter

        binding.refresher.setOnRefreshListener {
            viewModel.obtainVerbs()
        }

        viewModel.verbs.observe(viewLifecycleOwner, Observer { result ->

            if(binding.refresher.isRefreshing){
                binding.refresher.isRefreshing = false
            }

            adapter.submitList(result)

            binding.noContent.visibility = if (result.isEmpty()) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        binding.btnAddVerb.setOnClickListener {
            findNavController().navigate(R.id.action_verbsListFragment_to_createVerbFragment)
        }

        getNavigationResult()?.observe(viewLifecycleOwner, Observer {
            viewModel.obtainVerbs()
            Log.d("RESULT", "onViewCreated: $it")
        })

    }
}