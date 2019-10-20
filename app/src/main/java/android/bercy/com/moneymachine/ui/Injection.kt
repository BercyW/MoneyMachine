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
 * the benefit to
 */

object Injection {
    private var database : MoneyMachineDatabase? =null

    fun provideViewModelFacotry(context: Context):ViewModelProvider.Factory {
        database = MoneyMachineDatabase.getInstance(context)
        return ViewModelFactory(provideMoneyMachineRepository(context))
    }

    private fun provideMoneyMachineRepository(context: Context):MoneyMachineRepository {
        return MoneyMachineRepository(provideDepositLocalCache(context),provideWithdrawLocalCache(context))
    }
    private fun provideDepositLocalCache(context: Context) :DepositLocalCache{
        return DepositLocalCache(database?.depositDao(), Executors.newSingleThreadExecutor())
    }
    private fun provideWithdrawLocalCache(context: Context) :WithdrawLocalCache{
        return WithdrawLocalCache(database?.withDrawDao(),Executors.newSingleThreadExecutor())
    }
}