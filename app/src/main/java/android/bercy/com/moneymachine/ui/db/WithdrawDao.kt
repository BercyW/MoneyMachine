package android.bercy.com.moneymachine.ui.db

import android.bercy.com.moneymachine.ui.model.Withdraw
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface WithdrawDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(withdraw: Withdraw?)

}