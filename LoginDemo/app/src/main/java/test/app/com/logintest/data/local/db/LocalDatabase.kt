package test.app.com.logintest.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import test.app.com.logintest.data.local.db.dbo.LoginDao

@Database(entities = arrayOf(XaccData::class), version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract val loginDao: LoginDao
}