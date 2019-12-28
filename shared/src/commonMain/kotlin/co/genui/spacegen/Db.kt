package co.genui.spacegen

import com.squareup.sqldelight.db.SqlDriver

expect fun getSqlDriver(context: ApplicationContext, databaseName: String): SqlDriver

expect class ApplicationContext
