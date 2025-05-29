import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String date;
    String category;
    double amount;

    Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return "Date: " + date + ", Category: " + category + ", Amount: " + amount;
    }
}
 
public class ExpenseTracker {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter category (e.g., Food, Travel): ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // clear newline

        Expense e = new Expense(date, category, amount);
        expenses.add(e);
        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        System.out.println("\n List of Expenses:");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public static void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println(" Total Expenses: " + total);
    }

    public static void deleteExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }

        System.out.print("Enter the index of the expense to delete (starting from 0): ");
        int index = sc.nextInt();
        sc.nextLine(); 

        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public static void viewExpensesByCategory() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        System.out.print("Enter the category to filter by (e.g., Food, Travel): ");
        String category = sc.nextLine();

        boolean found = false;
        System.out.println("\n Expenses in category '" + category + "':");
        for (Expense e : expenses) {
            if (e.category.equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    public static void main(String[] args) {
        int choice;

        System.out.println("Welcome to the Expense Tracker!");

        do {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Delete Expense");
            System.out.println("5. View Expenses by Category");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: showTotal(); break;
                case 4: deleteExpense(); break;
                case 5: viewExpensesByCategory(); break;
                case 6: System.out.println("Exiting... Bye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}