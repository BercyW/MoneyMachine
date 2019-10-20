package android.bercy.com.moneymachine.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "deposit")
data class Deposit(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "amount") var amount: String? = null,
    @ColumnInfo(name = "date") var date: Date? = null
)