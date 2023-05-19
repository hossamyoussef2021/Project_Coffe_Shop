/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication43;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Hossam
 */
class MenuItem {
    private String name;
    private String type;
    private double price;

    public MenuItem(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    MenuItem(String coCOA, String drink, double d, MenuItem menuItem, MenuItem menuItem0, MenuItem menuItem1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class Coffeeshop {
    private String name;
    private MenuItem[] menu;
    private List<String> orders;

    public Coffeeshop(String name, MenuItem[] menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<>();
    }

    public String addOrder(String itemName) {
        for (MenuItem item : menu) {
            if (item.getName().equals(itemName)) {
                orders.add(itemName);
                return "Order added: " + itemName;
            }
        }
        return "This item is currently Not_available!";
    }

    public String fulfillOrder() {
        if (orders.isEmpty()) {
            return "All orders filled!";
        } else {
            String item = orders.get(0);
            orders.remove(0);
            return "The " + item + " is ready!";
        }
    }

    public List<String> listOrders() {
        return orders;
    }

    public double dueAmount() {
        double total = 0.0;
        for (String item : orders) {
            for (MenuItem menuItem : menu) {
                if (menuItem.getName().equals(item)) {
                    total += menuItem.getPrice();
                    break;
                }
            }
        }
        return total;
    }

    public String cheapestItem() {
        double minPrice = Double.MAX_VALUE;
        String cheapestItem = "";
        for (MenuItem item : menu) {
            if (item.getPrice() < minPrice) {
                minPrice = item.getPrice();
                cheapestItem = item.getName();
            }
        }
        return cheapestItem;
    }

    public List<String> drinksOnly() {
        List<String> drinkItems = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getType().equals("drink")) {
                drinkItems.add(item.getName());
            }
        }
        return drinkItems;
    }

    public List<String> foodOnly() {
        List<String> foodItems = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getType().equals("food")) {
                foodItems.add(item.getName());
            }
        }
        return foodItems;
    }
}

   
        
    public class Main {
            public static void main(String[] args) {
        MenuItem[] menu = {
                new MenuItem("Coffee", "drink", 2.5),
                new MenuItem("Cocoa", "drink", 3.5),
                new MenuItem("Ice-Coffe", "drink", 3.5),
                new MenuItem("Orange Juice", "drink", 3.5),
                new MenuItem("Mango Juice ", "drink", 3.5),
                new MenuItem("Lemonade ", "drink", 3.5),
                new MenuItem("Croissant", "food", 1.8),
                new MenuItem("Tea", "drink", 2.0),
                new MenuItem("cinnamon roll", "food", 2.0),   
                new MenuItem("chaorom", "food", 2.0),
                 new MenuItem("Pizza", "food", 2.0),
                new MenuItem("Sandwich", "food", 4.2)
        };

        Coffeeshop coffeeshop = new Coffeeshop("Awesome Cafe", menu);

        System.out.println(coffeeshop.addOrder("Coffee")); 
        System.out.println(coffeeshop.addOrder("Tea")); 
        System.out.println(coffeeshop.addOrder("Smoothie")); 
        System.out.println(coffeeshop.addOrder("Apple")); 
        System.out.println(coffeeshop.fulfillOrder()); 
        System.out.println(coffeeshop.fulfillOrder());
        System.out.println(coffeeshop.fulfillOrder()); 

        System.out.println(coffeeshop.listOrders()); 

        System.out.println(coffeeshop.cheapestItem()); 

        System.out.println(coffeeshop.drinksOnly()); 

        System.out.println(coffeeshop.foodOnly()); 
            }
}


    
    
