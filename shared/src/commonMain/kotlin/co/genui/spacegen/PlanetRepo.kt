package co.genui.spacegen

import com.squareup.sqldelight.db.SqlDriver

class PlanetRepo(
    private val databaseName: String,
    private val context: ApplicationContext,
    private val sqlDriver: SqlDriver = getSqlDriver(context, databaseName)) {


    

}
