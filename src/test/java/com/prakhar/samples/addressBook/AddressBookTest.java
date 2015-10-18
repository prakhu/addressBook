package com.prakhar.samples.addressBook;

import org.junit.*;
import static org.junit.Assert.*; 


/**
 * Unit test for simple App.
 */
public class AddressBookTest 
{
    private AddressBook book;
    
    @Before
    public void setup(){
    	book = new AddressBook();
    }
    
    @Test
    public void checkAddressBookNotEmpty(){
    	boolean empty = false;
    	empty = book.IsAddressBookEmpty();
    	assertEquals(true,empty);
    }
    
    @Test
    public void checkMalesInAddressBook(){
    	
    }
}
