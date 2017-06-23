package com.helloweenvsfei.struts2.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception {

		InputStream ins = Test.class.getResourceAsStream("countries.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(ins));

		List<String> list = new ArrayList<String>();

		String s = null;

		while ((s = reader.readLine()) != null) {
			list.add(s);
		}

		ins.close();

		System.out.println(list);

		StringBuffer buffer = new StringBuffer();

		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			buffer.append("\"" + it.next() + "\", ");
		}
		
		System.out.println();
		System.out.println(buffer);

	}
}
