import java.util.Random;

public class RestaurantMenu {
    public static void main(String[] args) {
        // Define the menu items and their prices
        String[] menuItems = {
            "onionRings", "sambusa", "springRolls", "salds", "butterMilkBread",
            "Classic Burger", "Chicken Alfredo", "Spicy Delux", "Smoked Salmon", "Rattle Snake Pasta",
            "Hot Chocolet", "Cheese cake", "Teramisso", "Red Velevet", "Black Forest"
        };

        double[] itemPrices = {
            5.99, 6.99, 7.49, 4.99, 8.99,
            12.99, 14.99, 11.49, 15.99, 13.49,
            6.99, 5.49, 7.99, 8.49, 4.99
        };

        // Create a 2D array to represent the menu
        String[][] menu = new String[3][5];
        double[][] prices = new double[3][5];

        // Fill the menu and prices arrays
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                menu[i][j] = menuItems[index];
                prices[i][j] = itemPrices[index];
                index++;
            }
        }

        // Create an array to keep track of orders
        String[] orders = new String[20];
        int orderCount = 0;

        // Simulate taking 20 orders
        Random random = new Random();
        while (orderCount < 20) {
            // Generate a random order
            int category = random.nextInt(3); // 0 for appetizers, 1 for entrees, 2 for desserts
            int itemIndex = random.nextInt(5);
            String selectedItem = menu[category][itemIndex];

            // Record the order
            orders[orderCount] = selectedItem;
            orderCount++;

            // Print the menu for the drive-through worker
            System.out.println("Menu:");
            for (int i = 0; i < 3; i++) {
                System.out.print(i == category ? "* " : "  ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(menu[i][j] + " $" + prices[i][j] + "   ");
                }
                System.out.println();
            }
        }

        // Calculate total money made
        double totalMoney = 0;
        for (String item : orders) {
            int itemIndex = findItemIndex(item, menu);
            if (itemIndex != -1) {
                totalMoney += prices[itemIndex / 5][itemIndex % 5];
            }
        }

        // Print summary
        System.out.println("\nSummary:");
        System.out.println("Total money made: $" + totalMoney);

        // Calculate and print percentage of sales for each item
        for (int i = 0; i < menuItems.length; i++) {
            int itemOrderedCount = countItemOccurrences(menuItems[i], orders);
            double percentage = (itemOrderedCount * prices[i / 5][i % 5] / totalMoney) * 100;
            System.out.println(menuItems[i] + ": " + percentage + "%");
        }

        // Print a list of items ordered with the number of times they're ordered
        System.out.println("\nItems ordered and their quantities:");
        for (String menuItem : menuItems) {
            int itemOrderedCount = countItemOccurrences(menuItem, orders);
            if (itemOrderedCount > 0) {
                System.out.println(menuItem + ": " + itemOrderedCount);
            }
        }
    }

    // Helper method to find the index of an item in the menu
    private static int findItemIndex(String item, String[][] menu) {
        for (int i = 0; i < menu.length; i++) {
            for (int j = 0; j < menu[i].length; j++) {
                if (menu[i][j].equals(item)) {
                    return i * 5 + j;
                }
            }
        }
        return -1; // Item not found
    }

    // Helper method to count the occurrences of an item in an array
    private static int countItemOccurrences(String item, String[] array) {
        int count = 0;
        for (String element : array) {
            if (item.equals(element)) {
                count++;
            }
        }
        return count;
    }
}

/*
I always dreamed of having a restaurant with 15 options on the menu, but I don’t know what I want to put on it. I’ve decided to ask you to create the items and decide how much they’ll cost because i’m not very creative. I need 5 appetizers, 5 entrees, and 5 desserts. And then the restaurant will begin taking orders. We are only willing to take 20 orders from the drive through. Customers are only able to order 1 item. Every time a car pulls up the drive through worker will have a script to read and the menu must appear. 

After all 20 orders happen, a summary must appear with this information:
Total money made
Percentage of sales for each item.
A list of items ordered with the number of times they’re ordered. 

 */




