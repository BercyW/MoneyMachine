package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import androidx.lifecycle.LiveData


/**
 * by passing localcache, we can pass service call in the future,
 * it will works with local and remote data source
 *
 */

class MoneyMachineRepository (
    private val depositLocalCache:DepositLocalCache,
    private val withdrawLocalCache: WithdrawLocalCache
) {


    /**
     * for local cache
     */

    //for deposit
    fun insertDepositData(deposit: Deposit) {
        depositLocalCache.insert(deposit)
    }

    //for withdraw
    fun insertWithdrawData(withdraw:Withdraw) {
        withdrawLocalCache.insert(withdraw)
    }


    //getTotal deposit amount
    fun getTotalDeposit(): LiveData<Long> {
        return depositLocalCache.getTotalDepositAmount()

    }

    //getTotal withdraw
    fun getTotalWithdraw() : LiveData<Long> {
        return withdrawLocalCache.getTotalWithdrawAmount()
    }



    //todo summary


    //todo search


    /**
     * below here for remote in the future, add boundary callback if using pagedlist
     */








}