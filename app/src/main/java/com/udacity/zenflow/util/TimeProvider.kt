package com.udacity.zenflow.util

import javax.inject.Inject

interface TimeProvider {
    fun currentTimeMillis(): Long
}

class SystemTimeProvider @Inject constructor() : TimeProvider {
    override fun currentTimeMillis(): Long = System.currentTimeMillis()
}
