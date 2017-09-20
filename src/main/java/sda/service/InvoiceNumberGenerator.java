package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by RENT on 2017-09-14.
 */
@Service
public class InvoiceNumberGenerator {

	private Date date;
	private PrintWriter out;

	@Autowired
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

			String year = String.valueOf(getYear());
			String month;
			String day;

			if(getMonth() < 10)
				month = "0"+String.valueOf(getMonth());
			else
				month = String.valueOf(getMonth());

		if(getDay() < 10)
			day = "0"+String.valueOf(getDay());
		else
			day = String.valueOf(getDay());


		return year + "/" + month + "/" + day;
	}

}
