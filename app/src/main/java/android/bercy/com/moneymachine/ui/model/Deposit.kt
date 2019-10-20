package android.bercy.com.moneymachine.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

/**
 * supposed to use dateconvert pass date but running into some issues, so changed to string.
 */
@Entity(tableName = "deposit")
data class Deposit(@PrimaryKey(autoGenerate = true)  var id: Long?,
    @ColumnInfo(name = "userName") var userName:String? = null,
    @ColumnInfo(name = "amount") var amount: Long,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "date") var date: String? = null
)
{
    constructor():this(null,"", 0L,"","")
}