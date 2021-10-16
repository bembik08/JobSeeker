package com.test_app.jobseeker.utils.schedulers

import io.reactivex.rxjava3.core.Scheduler

interface Schedulers {
    fun io(): Scheduler
    fun main(): Scheduler
}