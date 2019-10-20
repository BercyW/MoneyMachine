package android.bercy.com.moneymachine.ui.db

import android.bercy.com.moneymachine.ui.model.Deposit
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DepositDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(deposit:Deposit?)



}