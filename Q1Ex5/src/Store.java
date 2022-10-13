import java.util.*;
import java.util.stream.Collectors;

public class Store {

    private String name;
    private double earnings;
    private ArrayList<Item> itemList;
    private static ArrayList<Store> storeList = new ArrayList<>();

    public Store(String name) {
        // Initialize name to parameter and earnings to zero
        this.name = name;
        this.earnings = 0;

        // Initialize itemList as a new ArrayList
        this.itemList = new ArrayList<>();

        // add 'this' store to storeList
        Store.storeList.add(this);
    }

    public String getName() {
        return name;
    }

    public double getEarnings() {
        return earnings;
    }

    public void sellItem(int index) {
        try {
            // check if index is within the size of the itemList (if not, print statement that there are only x items in the store)
            if (index >= itemList.size() || index < 0) {
                throw new IllegalArgumentException(); // TODO: throw to exterior
            }

            // get Item at index from itemList and add its cost to earnings
            this.earnings += this.itemList.get(index).getCost();

            // print statement indicating the sale
            System.out.printf(
                "Sale of item %s successful.%n",
                this.itemList.get(index).getName()
            );
        } catch (IllegalArgumentException iae) {
            System.out.printf(
                "Invalid index: indices valid only up to %d.%n",
                this.itemList.size()
            );
        }
    }

    public void sellItem(String name) {
        try {
            // check if Item with given name is in the itemList (you will need to loop over itemList)
            // (if not, print statement that the store doesn't sell it)
            var itemListNames =
                this.itemList.stream()
                    .map(
                        n -> {
                            return n.getName();
                        }
                    )
                    .collect(Collectors.toCollection(ArrayList::new));
            if (!itemListNames.contains(name)) {
                throw new IllegalArgumentException(); // TODO: throw to exterior
            }

            // get Item from itemList and add its cost to earnings
            var itemDesired = this.itemList.get(itemListNames.indexOf(name));
            this.earnings += itemDesired.getCost();

            // print statement indicating the sale
            System.out.printf(
                "Sale of item %s successful.%n",
                itemDesired.getName()
            );
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid name.  Perhaps a different store sells it."
            );
        }
    }

    public void sellItem(Item i) {
        try {
            // check if Item i exists in the store (there is a method that can help with this)
            // (if not, print statement that the store doesn't sell it)
            if (this.itemList.indexOf(i) == -1) {
                throw new IllegalArgumentException(); // TODO: throw to exterior
            }

            // get Item i from itemList and add its cost to earnings
            this.earnings += i.getCost();

            // print statement indicating the sale
            System.out.printf("Sale of item %s successful.%n", i.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid item sought.  Perhaps a different store sells it."
            );
        }
    }

    public void addItem(Item i) {
        // add Item i to store's itemList
        this.itemList.add(i);
    }

    public void filterType(String type) {
        // loop over itemList and print all items with the specified type
        System.out.printf(
            "Item/s sold in %s that have type %s:%n",
            this.name,
            type
        );
        this.itemList.forEach(
                n -> {
                    if (n.getType() == type) {
                        System.out.printf("%s%n", n.getName());
                    }
                }
            );
    }

    public void filterCheap(double maxCost) {
        // loop over itemList and print all items with a cost lower than or equal to the specified value
        System.out.printf(
            "Item/s sold in %s that have a cost less than or equal to %,.2f:%n",
            this.name,
            maxCost
        );
        this.itemList.forEach(
                n -> {
                    if (n.getCost() <= maxCost) {
                        System.out.printf("%s%n", n.getName());
                    }
                }
            );
    }

    public void filterExpensive(double minCost) {
        // loop over itemList and print all items with a cost higher than or equal to the specified value
        System.out.printf(
            "Item/s sold in %s that have a cost greater than or equal to %,.2f:%n",
            this.getName(),
            minCost
        );
        this.itemList.forEach(
            n -> {
                if (n.getCost() >= minCost) {
                    System.out.printf("%s%n", n.getName());
                }
            }
        );
    }

    public static void printStats() {
        // loop over storeList and print the name and the earnings'Store.java'
        System.out.println("Storelist:");
        Store.storeList.forEach(
            n -> {
                System.out.printf(
                    "Name: %s; Earnings: %,.2f%n",
                    n.name,
                    n.earnings
                );
            }
        );
    }
}
