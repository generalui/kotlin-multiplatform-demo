package co.genui.spacegen

import android.app.Activity
import com.genui.spacegen.db.SpaceGenDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual fun getSqlDriver(context: ApplicationContext, databaseName: String): SqlDriver {
    return AndroidSqliteDriver(SpaceGenDB.Schema, context.activity, databaseName)
}

actual class ApplicationContext(val activity: Activity)
