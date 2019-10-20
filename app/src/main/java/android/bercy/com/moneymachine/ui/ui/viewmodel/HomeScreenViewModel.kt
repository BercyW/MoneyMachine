package android.bercy.com.moneymachine.ui.ui.viewmodel

import android.bercy.com.moneymachine.ui.data.MoneyMachineRepository
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.Withdraw
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * by using two tables for deposit and withdraw, I think it is easier to fetch specific data when we want.
 * also we can use foreign key in entities to make connection between tables.
 *
 * ex: if user only want get deposit information, we don't need to write more code to remove unnecessary columns.
 *
 * That's my thought as of now.
 */
class HomeScreenViewModel (private val repository: MoneyMachineRepository) : ViewModel() {

    //for search
    private val searchData = MutableLiveData<String>()


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



}