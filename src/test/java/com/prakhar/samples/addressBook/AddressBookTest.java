package com.prakhar.samples.addressBook;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List; 


/**
 * Unit test for simple App.
 */
public class AddressBookTest 
{
    private AddressBook book;
    private File file;
    
    @Before
    public void setup(){
    	book = new AddressBook();
    	file = new File("addressBook.txt");
    }
    
    @Test
    public void checkAddressBookNotEmpty(){
    	boolean empty = false;
    	empty = book.IsAddressBookEmpty(file);
    	assertEquals(true,empty);
    }
    
    @Test
    public void checkMalesInAddressBook(){
    	int countMales;
    	countMales=book.CountMales(file);
    	assertEquals("Count of males in the addressBook",3,countMales);
    }
    
    @Test
    public void findOldest(){
    	List<Person> list=new ArrayList<Person>();
    	list=book.findOldestPerson(file);
    	String oldestPerson=list.get(0).getName()+" "+list.get(0).getSurname();
    	assertEquals("Oldest one ","Wes Jackson",oldestPerson);
    }
    
    @Test
    public void TestfindOldestAmongBillAndPaul(){
    	int days;
    	days=book.findOldestAmongBillAndPaul(file,"Bill","Paul");
    	System.out.println(days);
    	assertNotNull(days);
    }
}
