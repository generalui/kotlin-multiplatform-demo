package co.genui.spacegen

import com.genui.spacegen.db.SpaceGenDB
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.ios.NativeSqliteDriver

actual fun getSqlDriver(context: ApplicationContext, databaseName: String): SqlDriver {
    return NativeSqliteDriver(SpaceGenDB.Schema, databaseName)
}

actual class ApplicationContext
