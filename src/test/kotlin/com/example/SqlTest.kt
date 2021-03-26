package com.example

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.junit.jupiter.api.Test

class SqlTest {

    @Test
    fun test() {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        Database.Schema.create(driver)
        val db = Database(driver)
        db.myEntityQueries.select().executeAsList()
        db.playerQueries.select().executeAsList()
    }
}