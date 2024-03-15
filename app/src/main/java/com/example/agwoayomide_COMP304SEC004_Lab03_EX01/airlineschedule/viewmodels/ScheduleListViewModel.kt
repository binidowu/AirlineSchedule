package com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule.viewmodels
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule.database.schedule.Schedule
import com.example.agwoayomide_COMP304SEC004_Lab03_EX01.airlineschedule.database.schedule.ScheduleDao
import kotlinx.coroutines.flow.Flow

class AirlineScheduleViewModel(private val scheduleDao: ScheduleDao): ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = scheduleDao.getAll()

    fun scheduleForAirlineName(name: String): Flow<List<Schedule>> = scheduleDao.getByAirlineName(name)
}

class AirlineScheduleViewModelFactory(
    private val scheduleDao: ScheduleDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AirlineScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AirlineScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
