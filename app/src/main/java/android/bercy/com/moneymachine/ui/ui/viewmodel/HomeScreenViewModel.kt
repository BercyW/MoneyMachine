package android.bercy.com.moneymachine.ui.ui.viewmodel

import android.bercy.com.moneymachine.ui.data.MoneyMachineRepository
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*


/**
 * by using two tables for deposit and withdraw, I think it is easier to fetch specific data when we want.
 * also we can use foreign key in entities to make connection between tables.
 *
 * ex: if user only want get deposit information, we don't need to write more code to remove unnecessary columns.
 *
 * That's my thought as of now.
 */
class HomeScreenViewModel (private val repository: MoneyMachineRepository) : ViewModel() {

    //total deposit
    private val totalDeposit = MutableLiveData<Long>()

    //for search
    private val searchData = MutableLiveData<String>()

    init {
        //totalDeposit.postValue(repository.getTotalDeposit().value)
        totalDeposit.postValue(repository.getTotalDeposit().value)
        //postDepositValue()

    }

    private fun postDepositValue() = GlobalScope.launch {
        totalDeposit.value = repository.getTotalDeposit().value
    }

    /**
     * for insert deposit
     */
    fun insertDepositMoney(deposit : Deposit) {
        repository.insertDepositData(deposit)
    }

    /**
     * for insert withdraw
     */
    fun insertWithdrawMoney(withdraw: Withdraw) {
        repository.insertWithdrawData(withdraw)
    }

    fun getTotalDeposit() : LiveData<Long> {
        return totalDeposit
    }


}