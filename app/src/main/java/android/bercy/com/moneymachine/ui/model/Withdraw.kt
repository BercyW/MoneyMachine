package android.bercy.com.moneymachine.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "withdraw")
data class Withdraw(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "userName") var userName:String? = null,
    @ColumnInfo(name = "deposit") var deposit: String? = null,
    @ColumnInfo(name = "amount") var amount: String? = null,
    @ColumnInfo(name = "date") var date: Date? = null,
    @ColumnInfo(name = "tag") var tag: String? = null
)