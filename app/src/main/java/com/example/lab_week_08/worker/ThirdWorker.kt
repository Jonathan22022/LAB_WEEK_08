package com.example.lab_week_08.worker

import androidx.work.Data
import android.content.Context
import androidx.work.WorkerParameters
import androidx.work.Worker
import android.util.Log

class ThirdWorker (
    context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    //This function executes the predefined process based on the input
//and return an output after it's done
    override fun doWork(): Result {
//Get the parameter input
        Log.d("WORKFLOW", "ThirdWorker started")
        val id = inputData.getString(INPUT_DATA_ID)
//Sleep the process for 3 seconds
        Thread.sleep(3000L)
//Build the output based on process result
        Log.d("WORKFLOW", "ThirdWorker finished | Output ID: $id")
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, id)
            .build()
//Return the output
        return Result.success(outputData)
    }
    companion object {
        const val INPUT_DATA_ID = "inId"
        const val OUTPUT_DATA_ID = "outId"
    }
}