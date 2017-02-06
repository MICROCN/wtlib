package com.test.util;

import org.dbunit.database.DatabaseConfig;
import org.unitils.dbunit.DbUnitModule;
import org.unitils.dbunit.util.DbUnitDatabaseConnection;

public class MySqlDbUnitModult extends DbUnitModule {

	public DbUnitDatabaseConnection getDbUnitDatabaseConnection(
			final String schemaName) {
		DbUnitDatabaseConnection result = dbUnitDatabaseConnections
				.get(schemaName);
		if (null != result) {
			return result;
		}
		result = super.getDbUnitDatabaseConnection(schemaName);
		result.getConfig().setProperty(
				DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new MySqlDbUnitModult());
		result.getConfig().setProperty(
				DatabaseConfig.PROPERTY_METADATA_HANDLER,
				new MySqlDbUnitModult());
		return result;
	}
}
