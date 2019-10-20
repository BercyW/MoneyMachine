package android.bercy.com.moneymachine.ui.ui.viewmodel

import android.bercy.com.moneymachine.ui.data.MoneyMachineRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val repository: MoneyMachineRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeScreenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}