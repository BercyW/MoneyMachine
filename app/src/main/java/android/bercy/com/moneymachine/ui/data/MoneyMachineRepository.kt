package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw


/**
 * by passing localcache, we can pass service call in the future,
 * it will works with local and remote data source
 *
 */

class MoneyMachineRepository (
    private val depositCache:DepositLocalCache,
    private val withdrawLocalCache: WithdrawLocalCache
) {


    /**
     * for local cache
     */

    //for deposit
    fun insertDepositData(deposit: Deposit) {
        depositCache.insert(deposit)
    }

    //for withdraw
    fun insertWithdrawData(withdraw:Withdraw) {
        withdrawLocalCache
    }



    //todo summary


    //todo search


    /**
     * below here for remote in the future, add boundary callback if using pagedlist
     */








}