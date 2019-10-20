package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw


/**
 * by using localcache, we can pass service call in the future,
 * it will works with local and remote data source
 */
class MoneyMachineRepository (
    private val depositCache:DepositLocalCache,
    private val withdrawLocalCache: WithdrawLocalCache
) {


    //for deposit
    fun insertDepositData(deposit: Deposit) {
        depositCache.insert(deposit)
    }

    //for withdraw
    fun insertWithdrawData(withdraw:Withdraw) {
        withdrawLocalCache
    }




}