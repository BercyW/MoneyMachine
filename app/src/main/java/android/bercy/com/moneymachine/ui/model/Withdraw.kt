package android.bercy.com.moneymachine.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "withdraw")
data class Withdraw(@PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "userName") var userName:String? = null,
    @ColumnInfo(name = "amount") var amount: Long,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "date") var date: String? = null,
    @ColumnInfo(name = "tag") var tag: String? = null
){
    constructor():this(null,"", 0L,"","","")
}