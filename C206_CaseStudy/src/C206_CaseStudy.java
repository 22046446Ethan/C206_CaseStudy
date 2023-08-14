
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class C206_CaseStudy {
	 private List<Payment> payments;
	 private ArrayList<User> UserList;
	 
	    public C206_CaseStudy() {
	        payments = new ArrayList<>();
	        UserList = new ArrayList<>(); 
	    }

	    public List<Payment> getPayments() {
	        return payments;
	    }
	    public void addPayment(String name, String cardNumber, String cvv) {
	        Payment payment = new Payment(name, cardNumber, cvv);
	        payments.add(payment);
	        System.out.println("Payment added successfully.");
	    }

	    public void viewAllPayments() {
	        System.out.println("All Payments:");
	        for (Payment payment : payments) {
	            System.out.println("Name: " + payment.getName());
	            System.out.println("Card Number: " + payment.getCardNumber());
	            System.out.println("CVV: " + payment.getCvv());
	            System.out.println("--------------------------");
	        }
	    }

	    public void deletePayment(String userName) {
	        Payment paymentToRemove = null;
	        for (Payment payment : payments) {
	            if (payment.getName().equals(userName)) {
	                paymentToRemove = payment;
	                break;
	            }
	        }

	        if (paymentToRemove != null) {
	            payments.remove(paymentToRemove);
	            System.out.println("Payment deleted successfully.");
	        } else {
	            System.out.println("Payment not found.");
	        }
	    }

	    public static boolean isValidCardNumber(String cardNumber) {
	        return cardNumber.length() == 10 && cardNumber.matches("\\d+");
	    }

	    public static boolean isValidCvv(String cvv) {
	        return cvv.length() == 3 && cvv.matches("\\d+");
	    }

    public static void main(String[] args) {
        // users (Shai)
        ArrayList<User> UserList = new ArrayList<User>();
        UserList.add(new User("John Doe", 18, "Admin"));
        UserList.add(new User("Don Ken", 21, "Auction Organiser"));
        
        // auction(Don)
        AuctionItem item1 = new AuctionItem("Laptop");
        AuctionItem item2 = new AuctionItem("Phone");
        
        // bid(Don)
        Bid laptopBid = new Bid("John", 100.0, item1);
        Bid phoneBid = new Bid("Mary", 200.0, item2);
        laptopBid.addBid(laptopBid);
        phoneBid.addBid(phoneBid);
        
        // items(Mei Jin)
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<AuctionItem> auctionList = new ArrayList<AuctionItem>();
        itemList.add(new Item("Item 1", "Description 1", 50.0));
        itemList.add(new Item("Item 2", "Description 2", 100.0));
        itemList.add(new Item("Item 3", "Description 3", 75.0));
        itemList.add(new Item("fion", "abc", 50.0));
        
        // payment(Ethan) 
        C206_CaseStudy caseStudy = new C206_CaseStudy();
        caseStudy.addPayment("John Doe", "1234567890", "123");
        caseStudy.addPayment("Jane Smith", "9876543210", "456");

        int option = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (option != 5) {
            C206_CaseStudy.menu();
            System.out.print("Enter an option > ");

            try {
                option = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a valid integer option.");
                continue;
            }



            if (option == 1) {
                // Sub-menu for adding, viewing, and deleting users
                int subOption = 0;
                
                while (subOption != 4) {
                    C206_CaseStudy.subMenu1();
                    subOption = Helper.readInt("Enter a sub-option > ");

                    if (subOption == 1) {
                        // Add new user
                        C206_CaseStudy.setHeader("ADD NEW USER");
                        User us = inputUser();
                        C206_CaseStudy.addUser(UserList, us);
                        System.out.println("New user has been added");
                    } else if (subOption == 2) {
                        // View all users
                        C206_CaseStudy.viewAllUsers(UserList);
                    } else if (subOption == 3) {
                        // Delete existing user
                        String Deletename = Helper.readString("Enter user's name: ");
                        boolean userDeleted = false;

                        for (int i = 0; i < UserList.size(); i++) {
                            if (UserList.get(i).getName().equals(Deletename)) {
                                UserList.remove(i);
                                userDeleted = true;
                                break;
                            }
                        }
                        if (userDeleted) {
                            System.out.println("User " + Deletename + " deleted.");
                        } else {
                            System.out.println("User " + Deletename + " not found.");
                        }
                    } else if (subOption == 4) {
                        System.out.println("Returning to main menu.");
                    } else {
                        System.out.println("Invalid sub-option");
                    }
                }
            } else if (option == 2) {
                // ... (Existing bidder operations code)
                bidderOperations(laptopBid, phoneBid); // Call the bidder operations method
            } else if (option == 3) {
                // Option 3 - Item operations
                itemOperations(itemList);
            } else if (option == 4) {  
                caseStudy.paymentSubMenu(); 
            } else if (option == 5) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu() {
        setHeader("CAMPUS ONLINE AUCTION SHOP");
        System.out.println("1. User operations");
        System.out.println("2. Bidder operations");
        System.out.println("3. Item operations");
        System.out.println("4. Payment operations");
        System.out.println("5. Quit");
        Helper.line(80, "-");
    }


    public static void subMenu1() {
        C206_CaseStudy.setHeader("USER OPERATIONS");
        System.out.println("1. Add new user");
        System.out.println("2. View all users");
        System.out.println("3. Delete existing user");
        System.out.println("4. Return to main menu");
        Helper.line(80, "-");
    }


       public static void setHeader(String header) {
       Helper.line(80, "-");
      System.out.println(header);
      Helper.line(80, "-");
}

    public static User inputUser() {
        String name = Helper.readString("Enter user name: ");
        int userid = Helper.readInt("Enter userid: ");
        String roles = Helper.readString("Enter role: ");

        User us = new User(name, userid, roles);
        return us;
    }

    public static void addUser(ArrayList<User> UserList, User us) {
        User user1;
        for (int i = 0; i < UserList.size(); i++) {
            user1 = UserList.get(i);
            if (user1.getName().equalsIgnoreCase(us.getName()))
                return;
        }
        if ((us.getName().isEmpty()) || (us.getRoles().isEmpty())) {
            return;
        }

        UserList.add(us);
    }

    public static String retrieveAllUsers(ArrayList<User> UserList) {
        String output = "";

        for (int i = 0; i < UserList.size(); i++) {
            output += String.format("%-20s %-20s %-20s\n", UserList.get(i).getName(),
                    UserList.get(i).getUserid(), UserList.get(i).getRoles());
        }
        return output;
    }

    public static void viewAllUsers(ArrayList<User> UserList) {
        C206_CaseStudy.setHeader("USER LIST");
        String output = String.format("%-20s %-20s %-20s\n", "NAME", "USER ID",
                "ROLES");
        output += retrieveAllUsers(UserList);
        System.out.println(output);
    }

    public static void bidderOperations(Bid laptopBid, Bid phoneBid) {
    	int bidderOption = 0;

    	while (bidderOption != 4) {
    	    Helper.line(80, "-");
    	    System.out.println("Campus Online Auction Shop - Bidder Operations");
    	    Helper.line(80, "-");
    	    System.out.println("1. Add a new bid");
    	    System.out.println("2. View all bids");
    	    System.out.println("3. Delete an existing bid");
    	    System.out.println("4. Return to main menu");
    	    Helper.line(80, "-");

    	    bidderOption = Helper.readInt("Enter the option > ");


    	    if (bidderOption == 1) {
    	        // Add new bid
    	        C206_CaseStudy.addNewBid(laptopBid, phoneBid);
    	    } else if (bidderOption == 2) {
    	        // View all bids
    	        C206_CaseStudy.viewAllBids(laptopBid, "Bids for Laptop:");
    	        C206_CaseStudy.viewAllBids(phoneBid, "Bids for Phone:");
    	    } else if (bidderOption == 3) {
    	        // Delete existing bid
    	        C206_CaseStudy.deleteBids(laptopBid, phoneBid);
    	    } else if (bidderOption == 4) {
    	        System.out.println("Returning to main menu.");
    	    } else {
    	        System.out.println("Invalid option. Please enter a valid option (1-4).");
    	    }
    	}
    }

public static void addNewBid(Bid laptopBid, Bid phoneBid) {
      System.out.println("Choose an item to bid on: \nLaptop or Phone"); String
      itemChoice = Helper.readString("Enter your choice: "); 
      AuctionItem selectedItem = null;
      Bid selectedBid = null;
      
      if (itemChoice.equalsIgnoreCase("laptop")) {
        selectedItem =laptopBid.getItem(); selectedBid = laptopBid;
    } else if(itemChoice.equalsIgnoreCase("phone")){ 
     selectedItem = phoneBid.getItem();
      selectedBid = phoneBid;
      } else {
    System.out.println("Invalid choice.");
      return; }
      
      String newBidder = Helper.readString("Enter the new bidder's name: "); double
      newBidAmount = Helper.readDouble("Enter the bid amount: ");
      
      if (newBidAmount >= 0) { 
       Bid newBid = new Bid(newBidder, newBidAmount,selectedItem);
       boolean bidAccepted = selectedBid.addBid(newBid);
      
      if (bidAccepted) {
        System.out.println("New Bid Added Successfully"); } else {
      System.out.println("Bid not accepted. The bid amount must be higher than the current bid."  );
      } } else {
      System.out.println("Invalid bid amount. Please enter a non-negative value.");
      }
      }
      
      public static void viewAllBids(Bid bid, String header) {
        List<Bid> allBids = bid.getAllBids();
        setHeader(header); if (allBids.isEmpty()) {
      System.out.println("No bids available.");
      } else { for (Bid b : allBids) {
      System.out.println(b.getBidder() + " bids $" + b.getBidAmount() + " on " +
      b.getItem().getItemName()); 
      }
      }
        System.out.println(); }
      
      public static void deleteBids(Bid laptopBid, Bid phoneBid) {
      System.out.println("Choose an item to delete the bid from: \nLaptop or Phone" );
      String itemChoice = Helper.readString("Enter your choice: ");
      Bid selectedBid = null;
      
      if (itemChoice.equalsIgnoreCase("laptop")) { selectedBid = laptopBid; } else
      if (itemChoice.equalsIgnoreCase("phone")) { selectedBid = phoneBid; } else {
      System.out.println("Invalid choice."); return; }
      
      String bidderToDelete =
      Helper.readString("Enter the bidder's name to delete the bid: "); boolean
      bidRemoved = false;
      List<Bid> allBids = selectedBid.getAllBids(); 
      List<Bid>
      bidsToRemove = new ArrayList<>();
      
      for (Bid bid : allBids) { if
      (bid.getBidder().equalsIgnoreCase(bidderToDelete)) {
      bidsToRemove.add(bid);
      bidRemoved = true;
      }
      } 
      for (Bid bidToRemove : bidsToRemove) {
      selectedBid.removeBid(bidToRemove); }
      
      if (bidRemoved) {
    System.out.println( "Bid for " +selectedBid.getItem().getItemName() + " by " + bidderToDelete +" has been deleted.");
      } else {
    System.out.println("Bid not found or already deleted.");
    } 
     
}
      public static void itemOperations(ArrayList<Item> itemList) {
            int subOption = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

            while (subOption != 4) {
                Helper.line(80, "-");
                System.out.println("Item Operations Sub-Menu");
                Helper.line(80, "-");
                System.out.println("1. Add a new item");
                System.out.println("2. View all items");
                System.out.println("3. Delete an existing item");
                System.out.println("4. Return to main menu");
                Helper.line(80, "-");

                System.out.print("Enter a sub-option > "); // Prompt user for input
                try {
                    subOption = Integer.parseInt(reader.readLine()); // Read input from BufferedReader
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Invalid input. Please enter a valid integer option.");
                    continue;
                }

                if (subOption == 1) {
                    // Add new item
                    Item newItem = inputItem(itemList);
                    addnewItem(itemList, newItem);
                    System.out.println("New item has been added");
                } else if (subOption == 2) {
                    // View all items
                    String itemsOutput = viewAllItems(itemList);
                    System.out.println(itemsOutput);
                } else if (subOption == 3) {
                    // Delete existing item
                    String removeItem = Helper.readString("Enter item name: ");
                    deleteItem(itemList, removeItem);
                } else if (subOption == 4) {
                    System.out.println("Returning to main menu.");
                } else {
                    System.out.println("Invalid sub-option");
                }
            }
        }
        
      
       // Option 1 Add an item (CRUD - Create)
        public static Item inputItem(ArrayList<Item> itemList) {

        	        String name = Helper.readString("Enter item name > ");
        	        String description = Helper.readString("Enter description > ");

        	        double startingBid = Helper.readDouble("Enter starting bid > ");
        	        while (startingBid < 0) {
        	            System.out.println("Starting bid must be a non-negative number.");
        	            startingBid = Helper.readDouble("Enter starting bid > ");
        	        }

        	        Item newItem = new Item(name, description, startingBid);
        	        return newItem;
        	    }
        


      public static void addnewItem(ArrayList<Item> itemList, Item newItem) {
          boolean duplicate = false;

          for (Item i : itemList) {
              if (i.getName().equalsIgnoreCase(newItem.getName())) {
                  duplicate = true;
                  break;
              }
          }

          if (!duplicate) {
              itemList.add(newItem);
              System.out.println("Add item successfully!");
          } else {
              System.out.println("Item name already exists. Add item unsuccessful!");
          }
      }
    // Option 2 View items (CRUD - Read)
    public static String viewAllItems(ArrayList<Item> itemList) {
        String output = "";
        for (int i = 0; i < itemList.size(); i++) {
            output += String.format("%-20s %-30s %.2f\n",
                itemList.get(i).getName(),
                itemList.get(i).getDescription(),
                itemList.get(i).getStartingBid());
        }
        return output;
    }

    // Option 3 Delete items (CRUD - Delete)
    public static void deleteItem(ArrayList<Item> itemList, String itemName) {
        boolean itemDeleted = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equalsIgnoreCase(itemName)) {
                itemList.remove(i);
                itemDeleted = true;
                break;
            }
        }

        if (itemDeleted) {
            System.out.println("Item " + itemName + " deleted.");
        } else {
            System.out.println("Item " + itemName + " not found.");
        }
    }

    public void paymentSubMenu() {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int subOption = 0;

        while (subOption != 4) {
            Helper.line(80, "-");
            System.out.println("Payment Management");
            Helper.line(80, "-");
            System.out.println("1. Add payment");
            System.out.println("2. View all payments");
            System.out.println("3. Delete payment");
            System.out.println("4. Return to main menu");
            Helper.line(80, "-");

            System.out.print("Enter a sub-option > ");

            try {
                subOption = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid input. Please enter a valid integer option.");
                continue;
            }

            if (subOption == 1) {
                String name = Helper.readString("Enter name: ");
                String cardNumber = Helper.readString("Enter card number: ");
                String cvv = Helper.readString("Enter CVV: ");

                if (isValidCardNumber(cardNumber) && isValidCvv(cvv)) {
                    addPayment(name, cardNumber, cvv);
                } else {
                    System.out.println("Invalid card number or CVV.");
                }
            } else if (subOption == 2) {
                viewAllPayments();
            } else if (subOption == 3) {
                String nameToDelete = Helper.readString("Enter the name of user to delete: ");
                deletePayment(nameToDelete);
            } else if (subOption == 4) {
                System.out.println("Returning to main menu.");
                break;  // Add this line to exit the sub-menu loop
            } else {
                System.out.println("Invalid sub-option");
            }
        }
    }
  }
          
