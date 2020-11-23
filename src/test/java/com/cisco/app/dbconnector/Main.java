package com.cisco.app.dbconnector;

import java.util.regex.Pattern;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		String myString = "/.,?><';\":][}{_)(*&^%$#@!~`-= qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ1234567890";
		
		String check = myString.replaceAll("[ `~!@#$%^&*()_+=\\-\\[\\]{};':\",.<>/?]", "");
		if(myString.length() != check.length()) {
			System.out.println("bad char");
		}

	}

}
