package com.root.app.tests;

import java.util.Calendar;
import java.util.Date;


public class AccountNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		Date date = ca.getTime();
		System.out.println(date);
		long sc = ca.getTimeInMillis();
		System.out.println(sc);
		
		String rd = null;
		
		Object obj = sc;
		rd = obj.toString();
		System.out.println(rd);
		
		rd = rd.substring(0, 3)+"-"+rd.substring(3, 9)+"-"+rd.substring(9);
		System.out.println(rd.substring(0, 2));
		System.out.println(rd.substring(3, 8));
		System.out.println(rd.substring(9));
		System.out.println(rd);

	}

}
