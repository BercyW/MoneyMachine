package android.bercy.com.moneymachine.ui.data

import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.DepositSearchResult
import android.bercy.com.moneymachine.ui.model.Withdraw
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * by passing localcache, we can pass service call in the future,
 * it will works with local and remote data source
 *
 */

class MoneyMachineRepository (
    private val depositLocalCache:DepositLocalCache,
    private val withdrawLocalCache: WithdrawLocalCache
) {

    // just for the future use
    private val networkErrors = MutableLiveData<String>()


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
    fun searchDepositTransaction(query : String): DepositSearchResult {
        networkErrors.postValue(null)
        val searchResult = depositLocalCache.getTotalDepositTransaction()
        return DepositSearchResult(searchResult,networkErrors)
    }

    /**
     * below here for remote in the future, add boundary callback if using pagedlist
     */








}