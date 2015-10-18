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
	
	private FileReader reader;
	private String line = null;
	
	 boolean IsAddressBookEmpty(File file){
		 boolean flag = false;
		
		try {
			reader = new FileReader(file);
		BufferedReader buff = new BufferedReader(reader);
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

	public int CountMales(File file) {
		int count = 0;
		if(IsAddressBookEmpty(file)){
			try {
				reader = new FileReader(file);
				BufferedReader buff = new BufferedReader(reader);
				while((line = buff.readLine())!=null){
					String values[] = line.split(",");
					if (values.length != 3) {
						throw new IllegalArgumentException("Address is Invalid");
					}
					if (values[1].contains("Male")){
						count++;
					}
				}
				return count;
			}catch (Exception e) {
				e.printStackTrace();
			} 
		}		
		return count;
	}
}
