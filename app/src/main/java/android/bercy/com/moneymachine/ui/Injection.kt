package android.bercy.com.moneymachine.ui

import android.bercy.com.moneymachine.ui.data.DepositLocalCache
import android.bercy.com.moneymachine.ui.data.MoneyMachineRepository
import android.bercy.com.moneymachine.ui.data.WithdrawLocalCache
import android.bercy.com.moneymachine.ui.db.MoneyMachineDatabase
import android.bercy.com.moneymachine.ui.ui.viewmodel.ViewModelFactory
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import java.util.concurrent.Executors


/**
 * the benefit to use this class is
 * we can pass these object as parameters in the constructors and then replace it for testing.
 */

object Injection {
    private lateinit var database : MoneyMachineDatabase

    fun provideViewModelFacotry(context: Context):ViewModelProvider.Factory {
        database = MoneyMachineDatabase.getInstance(context)
        return ViewModelFactory(provideMoneyMachineRepository())
    }

    private fun provideMoneyMachineRepository():MoneyMachineRepository {
        return MoneyMachineRepository(provideDepositLocalCache(),provideWithdrawLocalCache())
    }
    private fun provideDepositLocalCache() :DepositLocalCache{
        return DepositLocalCache(database.depositDao(), Executors.newSingleThreadExecutor())
    }
    private fun provideWithdrawLocalCache() :WithdrawLocalCache{
        return WithdrawLocalCache(database.withDrawDao(),Executors.newSingleThreadExecutor())
    }
}