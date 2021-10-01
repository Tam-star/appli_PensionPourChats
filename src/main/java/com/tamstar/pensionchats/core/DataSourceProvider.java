package com.tamstar.pensionchats.core;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceProvider {

	private static BasicDataSource singleDataSource;

	public static DataSource getSingleDataSourceInstance() {
		if (singleDataSource == null) {
			singleDataSource = new BasicDataSource();
			singleDataSource.setInitialSize(5);
			singleDataSource
					.setUrl("jdbc:mysql://localhost:3306/pension_chats?allowPublicKeyRetrieval=true&useSSL=false");
			singleDataSource.setUsername("tamtam");
			singleDataSource.setPassword("mot_de_passe");
		}

		return singleDataSource;
	}
}
