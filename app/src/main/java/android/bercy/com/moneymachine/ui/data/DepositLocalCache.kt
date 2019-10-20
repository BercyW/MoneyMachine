package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.db.DepositDao
import android.bercy.com.moneymachine.ui.model.Deposit
import android.util.Log
import java.util.concurrent.Executor

class DepositLocalCache(
    private val depositDao: DepositDao?,
    private val ioExecutor: Executor
) {


    //insert one deposit each time
    fun insert(deposit:Deposit) {
        ioExecutor.execute {
            Log.d("boxi","insert deposit amount : ${deposit.amount}")
            depositDao?.insert(deposit)
        }
    }




}