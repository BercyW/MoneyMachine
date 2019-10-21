package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.db.DepositDao
import android.bercy.com.moneymachine.ui.db.WithdrawDao
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import android.util.Log
import java.util.concurrent.Executor



/**
 * the benefit to use this class is we can handle local data source, it makes sure
 * the methods are triggered on the correct executor
 *
 * another better way to use coroutines here, less RAM usage but I need to think how to use in this situation : )
 *
 */

class WithdrawLocalCache (
    private val withdrawDao: WithdrawDao?,
    private val ioExecutor: Executor
) {


    //insert one withdraw each time
    fun insert(withdraw : Withdraw) {
        ioExecutor.execute {
            withdrawDao?.insert(withdraw)
            Log.d("boxi","insert deposit amount : ${withdraw.amount}")
        }
    }
    //todo get the total mount


}