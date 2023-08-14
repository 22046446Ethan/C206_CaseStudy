import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private AuctionItem item1;
    private AuctionItem item2;
    private List<Bid> laptopBids;
    private List<Bid> phoneBids;
    private Bid laptopbid;
    private Bid phonebid;
    private Item item3;
    private Item item4;
    private Item item5;
    private ArrayList<Item> itemList;
    private C206_CaseStudy caseStudy;
    private User user1;
    private User user2;
    private ArrayList<User> userList;

    public C206_CaseStudyTest() {
        super();
      }
    
    @Before
    public void setUp() throws Exception {
        // AuctionItem setup
        item1 = new AuctionItem("Laptop");
        item2 = new AuctionItem("Phone");
        laptopBids = new ArrayList<>();
        phoneBids = new ArrayList<>();
        laptopbid = new Bid("John", 100.0, item1);
        phonebid = new Bid("Mary", 200.0, item2);
        laptopBids.add(laptopbid);
        phoneBids.add(phonebid);

        // Item setup
        item3 = new Item("Item 1", "Description 1", 50.0);
        item4 = new Item("Item 2", "Description 2", 100.0);
        item5 = new Item("Item 3", "Description 3", 75.0);
        itemList = new ArrayList<>();

        // Payment setup
        caseStudy = new C206_CaseStudy();
        new ArrayList<>();

        // User setup
        user1 = new User("John Smith", 18, "Admin");
        user2 = new User("Don Ken", 21, "Auction Organiser");
        userList = new ArrayList<>();
    }

    // ... (test methods for bids)
    @Test
    public void c206_test() {
      // fail("Not yet implemented");
      assertTrue("C206_CaseStudy_SampleTest ", true);
    }
    @Test
    public void testAddNewBidWithHigherAmount() {
      // Scenario 1: Adding a new bid with a higher amount for laptop
      Bid newLaptopBid = new Bid("Alice", 150.0, item1);

      boolean BidAccepted = laptopbid.addBidToList(laptopBids, newLaptopBid);

      assertTrue("New laptop bid with a higher amount should be accepted.", BidAccepted);
      assertEquals("New laptop bid with a higher amount should be added to the laptop bids list.", 2,
          laptopBids.size());
    }

    @Test
    public void testAddNewBidWithSameBidAmount() {
      // Scenario 2: Adding a new bid with the same bid amount
      Bid newBid = new Bid("Bob", 100.0, item1);

      boolean bidAccepted = laptopbid.addBid(laptopBids, newBid);

      assertFalse("New bid with the same amount should not be accepted.", bidAccepted);
      assertEquals("Bids list for the item should remain unchanged.", 1, laptopBids.size());
    }

    @Test
    public void testAddNewBidWithLowerBidAmount() {
      // Scenario 3: Adding a new bid with a lower bid amount
      Bid newBid = new Bid("Mary", 80.0, item1);

      boolean bidAccepted = laptopbid.addBid(laptopBids, newBid);

      assertFalse("New bid with a lower amount should not be accepted.", bidAccepted);
      assertEquals("Bids list for the item should remain unchanged.", 1, laptopBids.size());
    }

    @Test
    public void testBiddersBiddingActivity() {
      // Test case 1
      assertEquals("The bidder's bidding activity should have 1 bid.", 1, phoneBids.size());
      // Test case 2
      Bid newBid = new Bid("Peter", 220.0, item2);
      boolean bidAccepted = phonebid.addBid(phoneBids, newBid);

      assertTrue("New bid should be accepted.", bidAccepted);
      assertEquals("The bidder's bidding activity should have two bids.", 2, phoneBids.size());
    }

    @Test
    public void testDeleteExistingBid() {
      // Delete the bid
      boolean bidDeleted = laptopBids.remove(laptopbid);
      assertTrue("Existing bid should be deleted.", bidDeleted);
      assertEquals("Bids list size should be 0 after deleting the bid.", 0, laptopBids.size());
    }

    @Test
    public void testDeleteLastBid() {
      Bid firstBid = new Bid("Paul", 180.0, item1);
      Bid secondBid = new Bid("David", 190.0, item1);

      boolean bidAccepted = laptopbid.addBid(laptopBids, firstBid);
      assertTrue("First laptop bid should be accepted.", bidAccepted);

      boolean bidAccepted2 = laptopbid.addBid(laptopBids, secondBid);
      assertTrue("Second laptop bid should be accepted.", bidAccepted2);

      // Delete the last bid for laptop
      boolean bidDeleted = laptopBids.remove(secondBid);
      assertTrue("Last laptop bid should be deleted.", bidDeleted);
      assertEquals("Laptop bids list size should be 2 after deleting the last bid.", 2, laptopBids.size());
    }

    @Test
    public void testDeleteNonExistentBidForPhone() {
      // Scenario: Deleting a non-existent bid for phone
      Bid nonExistentBid = new Bid("Jane", 250.0, item2);
      boolean bidDeleted = phoneBids.remove(nonExistentBid);
      assertFalse("Non-existent phone bid should not be deleted.", bidDeleted);
      assertEquals("Phone bids list size should remain unchanged.", 1, phoneBids.size());
    }


    //(test methods for payments)

    @Test
    public void testAddPayment() {
        caseStudy.addPayment("John Doe", "1234567890", "123");
        assertEquals(1, caseStudy.getPayments().size()); 
    }

    @Test
    public void testViewAllPayments() {
        caseStudy.addPayment("John Doe", "1234567890", "123");
        caseStudy.addPayment("Jane Smith", "9876543210", "456");

        String expectedOutput = "All Payments:\n" +
                                "Name: John Doe\nCard Number: 1234567890\nCVV: 123\n--------------------------\n" +
                                "Name: Jane Smith\nCard Number: 9876543210\nCVV: 456\n--------------------------";

        // Normalize line endings in expected and actual output for consistent comparison
        String actualOutput = getConsoleOutput(caseStudy::viewAllPayments).replaceAll("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDeletePayment() {
        caseStudy.addPayment("John Doe", "1234567890", "123");
        caseStudy.addPayment("Jane Smith", "9876543210", "456");

        caseStudy.deletePayment("John Doe");
        assertEquals(1, caseStudy.getPayments().size()); 

        caseStudy.deletePayment("Jane Smith");
        assertEquals(0, caseStudy.getPayments().size()); 
    }

    //(test methods for users)

    @Test
    public void testAddUser() {
      // Item list is not null and it is empty
      assertNotNull("Test if there is valid User arraylist to add to", userList);
      assertEquals("Test that the User arraylist is empty.", 0, userList.size());
      //Given an empty list, after adding 1 item, the size of the list is 1
      C206_CaseStudy.addUser(userList, user1);    
      assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

      
      // Add an item
      C206_CaseStudy.addUser(userList, user2);
      assertEquals("Test that the User arraylist size is now 2.", 2, userList.size());
      //The item just added is as same as the last item in the list
      assertSame("Test that User is added to the end of the list.", user2, userList.get(1));

      // Add an item that already exists in the list
      C206_CaseStudy.addUser(userList, user2);
      assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());

      // Add an item that has missing detail
      User us_missing = new User("mike", 60,"");
      C206_CaseStudy.addUser(userList, us_missing);
      assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
    }

    @Test
    public void testRetrieveAllUsers() {
      //Test Case 1
      // Test if Item list is not null and empty
      assertNotNull("Test if there is valid User arraylist to add to", userList);
      assertEquals("Test that the User arraylist is empty.", 0, userList.size());
      // Attempt to retrieve the Users 
      String allUser= C206_CaseStudy.retrieveAllUsers(userList);
      String testOutput = "";
      // Test if the output is empty
      assertEquals("Test that nothing is displayed", testOutput, allUser);

    }
    
     //========== Test deleting an existing user==============
    @Test
      public void testDeleteUser() {
          // Prepare test data
          User user1 = new User("John Smith", 18, "Admin");
          User user2 = new User("Don Ken", 21, "Auction Organiser");

          // Add test data to the list
          userList.add(user1);
          userList.add(user2);

          // Test deleting an existing user
          assertTrue("Test that user1 is in the list", userList.contains(user1));
          assertTrue("Test that user2 is in the list", userList.contains(user2));
          
          String deleteName = "John Smith";
          boolean userDeleted = false;
          
          for (int i = 0; i < userList.size(); i++) {
              if (userList.get(i).getName().equals(deleteName)) {
            	  userList.remove(i);
                  userDeleted = true;
                  break;
              }
          }

          assertTrue("Test that user1 is removed from the list", userDeleted);
          assertFalse("Test that user1 is not in the list", userList.contains(user1));
          assertTrue("Test that user2 is still in the list", userList.contains(user2));

          // Test deleting a non-existing user
          String nonexistentName = "Nonexistent User";
          userDeleted = false;
          
          for (int i = 0; i < userList.size(); i++) {
              if (userList.get(i).getName().equals(nonexistentName)) {
            	  userList.remove(i);
                  userDeleted = true;
                  break;
              }
          }

  assertFalse("Test that user with name 'Nonexistent User' is not removed from the list", userDeleted);
          assertFalse("Test that user with name 'Nonexistent User' is not added to the list", 
        		  userList.contains(new User("Nonexistent User", 0, "")));
      }

    
    //(test methods for items)
    
    @Test
    public void testAddItem() {
      // check whether itemList is not null and initally empty -   boundary
        assertNotNull("Test if there is a valid item arraylist to add to", itemList);
        assertEquals("Test that the item arraylist is empty.", 0, itemList.size());

        // adding 2 items and checking the size of the list matches the expected size after each addition -normal
        addNewitem(itemList, "Item 2", "Description 2", 100.0);
        assertEquals("Test that the item arraylist size is 1.", 1, itemList.size());

        addNewitem(itemList, "Item 3", "Description 3", 75.0);
        assertEquals("Test that the item arraylist size is now 2.", 2, itemList.size());
        
        // check whether you can add an duplicate item - error 
        Item duplicateItem = new Item("Item 2", "Description", 200.0);
        assertFalse("Test adding an item with the same name should return false.", addNewitem(itemList, duplicateItem));
        assertEquals("Test that the item arraylist size remains unchanged.", 2, itemList.size());

    }

    private static boolean addNewitem(ArrayList<Item> itemList2, Item duplicateItem) {
    // TODO Auto-generated method stub
    return false;
  }

  private void addNewitem(ArrayList<Item> itemList, String name, String description, double startingBid) {
        Item newItem = new Item(name, description, startingBid);
        itemList.add(newItem);
    }
    
  @Test
  public void testViewAllItems() {
      // Prepare test data
      itemList.add(item1);
      itemList.add(item2);

      String allItem = C206_CaseStudy.viewAllItems(itemList);
      String testOutput = String.format("%-20s %-30s %.2f\n","Item 1", "Description 1", 50.0);
    testOutput += String.format("%-20s %-30s %.2f\n","Item 2", "Description 2", 100.0);
    
      assertEquals("Test that the display is correct.", testOutput, allItem);

  //test if the list of Items retrieved from the c206 is empty - boundary
    String allItem1= C206_CaseStudyTest.viewAllItems(itemList);
    testOutput = String.format("%-20s %-30s %.2f\n","Item 1", "Description 1", 50.0);
    testOutput += String.format("%-20s %-30s %.2f\n","Item 2", "Description 2", 100.0);
    assertEquals("Check that ViewAllItemList", testOutput, allItem1);
    
  //Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
    C206_CaseStudyTest.addNewitem(itemList, item1);
    C206_CaseStudyTest.addNewitem(itemList, item2);
      assertEquals("Test that item arraylist size is 2", 2, itemList.size());
      
  // Display duplicate Items - error  
      C206_CaseStudyTest.addNewitem(itemList, item1);
      C206_CaseStudyTest.addNewitem(itemList, item2);
      allItem= C206_CaseStudyTest.viewAllItems(itemList);
      testOutput = String.format("%-20s %-30s %.2f\n","Item 1", "Description 1", 50.0);
      testOutput += String.format("%-20s %-30s %.2f\n","Item 2", "Description 2", 100.0);
      assertEquals("Test that viewAllItems", testOutput, allItem);

  }

  private static String viewAllItems(ArrayList<Item> itemList2) {
    return C206_CaseStudy.viewAllItems(itemList2);
    
  }

  @Test
  public void testDeleteItem() {
     // Test if Item list is not null but empty -boundary
      assertNotNull("Test if there is a valid item arraylist to delete from", itemList);
      assertEquals("Test that the item arraylist is empty.", 0, itemList.size());
// Add items and delete, list size has a change- Normal
      addNewitem(itemList, "Item 1", "Description 1", 5000.0);
      addNewitem(itemList, "Item 2", "Description 2", 105670.0);
      assertEquals("Test that the item arraylist size is 2 after adding items.", 2, itemList.size());

      deleteItem(itemList, "Item 1");
      assertEquals("Test that the item arraylist size is 1 after deleting an item.", 1, itemList.size());

      // Delete item not in the list- Error
      int initialSize = itemList.size();
      String name = "abc";
      deleteItem(itemList, name);
      assertEquals("Test that the item arraylist size remains unchanged after deleting a non-existent item.", initialSize, itemList.size());
  }

    
  private void deleteItem(ArrayList<Item> itemList, String name) {
    C206_CaseStudy.deleteItem(itemList,name);
    }

  //Helper method to capture console output for payment output
  private String getConsoleOutput(Runnable runnable) {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      PrintStream originalOut = System.out;
      System.setOut(new PrintStream(outputStream));

      runnable.run();

      System.setOut(originalOut);
      return outputStream.toString().trim();
  }
  
  //Helper method to perform the required logic to add a bid to a list
  private boolean addBidToList(List<Bid> bidList, Bid bidToAdd) {
	    double highestAmount = 0.0;
	    // Find the highest bid amount among all existing bids
	    for (Bid existingBid : bidList) {
	        if (existingBid.getBidAmount() > highestAmount) {
	            highestAmount = existingBid.getBidAmount();
	        }
	    }
	    if (bidToAdd.getBidAmount() > highestAmount) {
	        bidList.add(bidToAdd);
	        return true; // Bid accepted
	    } else {
	        return false; // Bid not accepted
	    }
	}

    @After
    public void tearDown() throws Exception {
        // AuctionItem teardown
        item1 = null;
        item2 = null;

        // Item teardown
        item3 = null;
        item4 = null;
        item5 = null;
        itemList = null;

        // Payment teardown
        // Clear the payments list after each test
        caseStudy.getPayments().clear();

        // User teardown
        user1 = null;
        user2 = null;
        userList = null;
    }
}
