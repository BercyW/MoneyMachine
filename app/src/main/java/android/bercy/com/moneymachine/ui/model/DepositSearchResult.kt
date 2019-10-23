package android.bercy.com.moneymachine.ui.model

import androidx.lifecycle.LiveData

data class DepositSearchResult (
    val searchResult: LiveData<List<Deposit>>,
    val networkErrors: LiveData<String>
)