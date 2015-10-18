package com.prakhar.samples.addressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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


	public List findOldestPerson(File file) {
		List<Person> list=new ArrayList<Person>();
		if(IsAddressBookEmpty(file)){
			try {
				reader = new FileReader(file);
				BufferedReader buff = new BufferedReader(reader);
				while((line = buff.readLine())!=null){
					String values[] = line.split(",");
					if (values.length != 3) {
						throw new IllegalArgumentException("Address is Invalid");
					}
					Person person = new Person(values[0],values[1],values[2]);
					list.add(person);
				}
				list= whoIsOldest(list);
			}catch (Exception e) {
				e.printStackTrace();
			} 
		
		
	}
		return list;
}

	private List<Person> whoIsOldest(List<Person> listP) {
		Collections.sort(listP,new Comparator<Person>(){				
			 public int compare(Person e1,Person e2){
				 return(e1.getBirthday().compareTo(e2.getBirthday()));
			 }
		});
		return listP;
	}

	public int findOldestAmongBillAndPaul(File file, String name1, String name2) {
		List<Person> list=new ArrayList<Person>();
		list=findOldestPerson(file);
		Person p1=null;
		Person p2=null;
		for(Person temp : list){
			if(name1.equals(temp.getName()))
				p1=temp;
			if(name2.equals(temp.getName()))
				p2=temp;
		}
		return (int)( (p2.getBirthday().getTime() - p1.getBirthday().getTime()) / (1000 * 60 * 60 * 24));
	}
}
