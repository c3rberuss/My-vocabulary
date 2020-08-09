package com.c3rberuss.myvocabulary.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.c3rberuss.core.domain.Verb
import com.c3rberuss.myvocabulary.R
import com.c3rberuss.myvocabulary.databinding.VerbItemBinding

class VerbsListAdapter(private val context: Context) :
    ListAdapter<Verb, VerbsListAdapter.VerbViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerbViewHolder {
        val view: VerbItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.verb_item,
            parent,
            false
        )
        return VerbViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerbViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VerbViewHolder(private val binding: VerbItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(verb: Verb) {
            binding.verb = verb
        }

    }
}

private class DiffCallback : DiffUtil.ItemCallback<Verb>() {
    override fun areItemsTheSame(oldItem: Verb, newItem: Verb): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Verb, newItem: Verb): Boolean {
        return oldItem == newItem
    }
}