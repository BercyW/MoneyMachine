package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.db.DepositDao
import android.bercy.com.moneymachine.ui.db.WithdrawDao
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import android.util.Log
import java.util.concurrent.Executor

class WithdrawLocalCache (
    private val withdrawDao: WithdrawDao?,
    private val ioExecutor: Executor
) {


    //insert one withdraw each time
    fun insert(withdraw : Withdraw) {
        ioExecutor.execute {
            Log.d("boxi","insert deposit amount : ${withdraw.amount}")
            withdrawDao?.insert(withdraw)
        }
    }


}