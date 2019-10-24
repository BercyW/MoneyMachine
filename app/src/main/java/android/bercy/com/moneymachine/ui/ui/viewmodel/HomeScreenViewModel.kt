package android.bercy.com.moneymachine.ui.ui.viewmodel

import android.bercy.com.moneymachine.ui.data.MoneyMachineRepository
import android.bercy.com.moneymachine.ui.model.Deposit
import android.bercy.com.moneymachine.ui.model.DepositSearchResult
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


    //for search
    private val searchQuery = MutableLiveData<String>()

    private val searchResult: LiveData<DepositSearchResult> = Transformations.map(searchQuery) {
        repository.searchDepositTransaction(it)
    }
    /**
     * in the future we have remote, than we can use networkErrors
     */
    val result: LiveData<List<Deposit>> = Transformations.switchMap(searchResult) { it -> it.searchResult }
    //for future use
    val networkErrors: LiveData<String> = Transformations.switchMap(searchResult) { it ->
        it.networkErrors
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

    /**
     * get total deposit amount
     */
    fun getTotalDeposit() : LiveData<Long> {
        return repository.getTotalDeposit()
    }

    /**
     * get total withdraw amount
     */
    fun getTotalWithdraw() : LiveData<Long> {
        return repository.getTotalWithdraw()
    }

    /**
     * search deposit. When we have remote data source, we can create search result object, and use
     * transformation.map to convert result object to deposit data.
     */
    fun searchDepositTransactions(query : String) {
        searchQuery.postValue(query)
    }



}