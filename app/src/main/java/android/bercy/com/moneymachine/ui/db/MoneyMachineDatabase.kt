package android.bercy.com.moneymachine.ui.db

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DepositDao::class,WithdrawDao::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MoneyMachineDatabase : RoomDatabase() {
    abstract fun depositDao() : DepositDao
    abstract fun withDrawDao() : WithdrawDao

    companion object {
        @Volatile
        private var INSTANCE : MoneyMachineDatabase? = null

        fun getInstance(context: Context):MoneyMachineDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE=it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,MoneyMachineDatabase::class.java,
                "MoneyMachine.db")
                .build()
    }
}