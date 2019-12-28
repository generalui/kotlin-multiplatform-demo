package co.genui.spacegen

import com.genui.spacegen.db.SpaceGenDB
import com.squareup.sqldelight.db.SqlDriver

// NOTE: Had to remove the injection of sqlDriver bc iOS native compilation can't handle the default values. Depending on the situation, could be injected in other ways.
class PlanetRepo(
    private val databaseName: String,
    private val context: ApplicationContext) {
//    private val sqlDriver: SqlDriver = getSqlDriver(context, databaseName)) {

    val sqlDriver = getSqlDriver(context, databaseName)
    val database = SpaceGenDB(sqlDriver)

    fun getPlanetNames(): List<String> {
        return database.planetQueries.selectNames().executeAsList()
    }
}
