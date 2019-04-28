package com.example.ecome.data.model

import android.content.Context
import com.example.ecome.network.DataAgent
import com.example.ecome.network.ProductDataAgent
import com.example.ecome.persistance.EcoDatabase
import com.example.ecome.util.DataAgentUtil

open class BaseModel(context: Context) {

    val mDataAgent = ProductDataAgent.getInstance()
    val mEcoDatabase : EcoDatabase = EcoDatabase.getInstance(context)
}