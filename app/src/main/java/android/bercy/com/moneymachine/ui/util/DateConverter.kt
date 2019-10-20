package android.bercy.com.moneymachine.ui.util

import androidx.room.TypeConverter
import java.sql.Date

/**
 *  running into some issues, so discard this as of now
 */
//class DateConverter {
//    @TypeConverter
//    fun fromTimestamp(value: Long?): Date? {
//        return value?.let { Date(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: Date?): Long? {
//        return date?.time?.toLong()
//    }
//}