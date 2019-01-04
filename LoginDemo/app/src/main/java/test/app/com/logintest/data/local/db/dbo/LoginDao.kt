package test.app.com.logintest.data.local.db.dbo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import test.app.com.logintest.data.local.db.XaccData

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertXaccData(xaccData: XaccData): Long

}