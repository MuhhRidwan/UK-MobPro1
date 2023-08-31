package com.example.firstapp.network

import android.util.Log

class UpdateWorker {
    context: Context,
    workerParams: WorkerParameters
    ) : Worker(context, workerParams) {
        override fun doWork(): Result {
            Log.d("Worker", "Menjalankan proses background..")
            return Result.success()
        }

    }