package com.prakhar.samples.addressBook;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File; 


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
}
