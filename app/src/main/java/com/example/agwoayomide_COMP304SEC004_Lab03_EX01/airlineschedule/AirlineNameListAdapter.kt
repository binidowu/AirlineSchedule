/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule.database.schedule.Schedule
import com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule.databinding.AirlineNameItemBinding
import java.text.SimpleDateFormat
import java.util.Date

class AirlineNameAdapter(
    private val onItemClicked: (Schedule) -> Unit
) : ListAdapter<Schedule, AirlineNameAdapter.AirlineNameViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineNameViewHolder {
        val viewHolder = AirlineNameViewHolder(
            AirlineNameItemBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AirlineNameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AirlineNameViewHolder(
        private var binding: AirlineNameItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(schedule: Schedule) {
            binding.airlineNameTextView.text = schedule.airlineName
            binding.terminalNumTextView.text = schedule.terminalNumber
            binding.arrivalTimeTextView.text = SimpleDateFormat(
                "h:mm a").format(Date(schedule.arrivalTime.toLong() * 1000)
            )
        }
    }
}
