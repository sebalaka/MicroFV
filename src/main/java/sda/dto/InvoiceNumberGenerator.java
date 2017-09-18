package sda.dto;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RENT on 2017-09-14.
 */
public class InvoiceNumberGenerator {

	private Date date;
	private PrintWriter out;

	public InvoiceNumberGenerator() {
	}

	private Integer getMonth() {
		date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	private Integer getYear() {
		date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	private Integer getDay() {
		date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	private String getNextNumber() {
		return "1234";
	}

	public String getInvoiceNumber() {
		return getNextNumber() + "/" + String.valueOf(getMonth()) + "/" + String.valueOf(getYear());
	}

	public String getDate() {
		return String.valueOf(getYear()) + "/" + String.valueOf(getMonth()) + "/" + String.valueOf(getDay());
	}

}
