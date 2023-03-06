package com.utility;

import java.sql.Connection;

public class CheckConnection {

	public static void main(String[] args) {
		
		Connection connect =DBUtil.provideConnection();
		
		
		System.out.println(connect + " Connection successful");

	}

}
