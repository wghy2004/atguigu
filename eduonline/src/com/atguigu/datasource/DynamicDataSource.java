package com.atguigu.datasource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 作为对dbcp的DataSource的封装，以此能使系统支持多数据库
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private transient final Log log = LogFactory.getLog(getClass());

	private static final boolean logDebug = false;

	@Override
	protected Object determineCurrentLookupKey() {

		return DBContextHolder.getDBType();
	}

}
