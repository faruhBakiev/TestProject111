package com.example.presentation.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemFilmsBinding
import com.example.presentation.models.FilmsResponseUi

class FilmsAdapter :
    ListAdapter<FilmsResponseUi, FilmsAdapter.FilmsViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(
            ItemFilmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class FilmsViewHolder(private val binding: ItemFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: FilmsResponseUi) {
            binding.tvTitle.text =item.title
            binding.tvOriginalTitle.text =item.originalTitle
        }

    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FilmsResponseUi>() {
            override fun areItemsTheSame(oldItem: FilmsResponseUi, newItem: FilmsResponseUi): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: FilmsResponseUi, newItem: FilmsResponseUi
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}