package com.prakhar.samples.addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class AddressBook 
{

	 boolean IsAddressBookEmpty(){
		 boolean flag = false;
		File file = new File("addressBook.txt");
		FileReader reader;
		try {
			reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
		String line = null;
		if ((line = buff.readLine())!=null){
			buff.close();
			flag = true;
			return flag;
		}
		else{
			flag = false;
		return flag;
		}
	}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	 }
}
