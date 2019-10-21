package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.db.DepositDao
import android.bercy.com.moneymachine.ui.model.Deposit
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executor


/**
 * the benefit to use this class is we can handle local data source, it makes sure
 * the methods are triggered on the correct executor
 *
 * Just realized I forgot to use coroutines, I will use coroutine in viewmodel class for other functions..
 *
 */
class DepositLocalCache(
    private val depositDao: DepositDao,
    private val ioExecutor: Executor
) {


    //insert one deposit each time
    fun insert(deposit:Deposit) {
        ioExecutor.execute {
            depositDao.insert(deposit)
            Log.d("boxi","insert deposit amount : ${deposit.amount}")
        }
    }


    fun getTotalDepositAmount() : LiveData<Long> {

        return depositDao.getAllDepositAmount()

    }

}