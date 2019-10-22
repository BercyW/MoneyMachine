package android.bercy.com.moneymachine.ui.db

import android.bercy.com.moneymachine.ui.model.Withdraw
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WithdrawDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(withdraw: Withdraw?)

    @Query("select SUM(amount) from withdraw")
    fun getAllWithdrawAmount() : LiveData<Long>

}