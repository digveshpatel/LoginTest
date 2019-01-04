package test.app.com.logintest.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class XaccData {

    @PrimaryKey
    lateinit var userName: String

    var xacc: String? = null


}