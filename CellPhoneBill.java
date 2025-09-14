// File: CellphoneBill.java
// Author: Flor Guadalupe
// Date: 2025-02-05
// Class: COMP 2315 Structured Programming
// Description: A monthly cellphone bill is displayed.

import java.util.Scanner;

public class CellphoneBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("Welcome to your cellphone company, please have patience and answer the following questions correctly to be able to give you your phone bill!");

        // Step 1: Collect User Input
        String customerName = receiveCustomerName(scanner);  // Changed to String
        double daytimeMinutes = receiveUsage(scanner, "daytime minutes used");
        double nighttimeMinutes = receiveUsage(scanner, "nighttime minutes");
        double textMessages = receiveUsage(scanner, "text messages used");
        double dataUsed = receiveUsage(scanner, "data used in GB");

        // Step 2: Calculate Charges
        double[] charges = calculateCharges(daytimeMinutes, nighttimeMinutes, textMessages, dataUsed);

        // Step 3: Calculate Total Charge
        double totalCharge = calculateTotalCharge(charges);

        // Step 4: Display the Bill
        displayBill(customerName, charges, totalCharge);

        scanner.close();
    }

    // Module 1: Get Customer Info (name and usage)
    public static String receiveCustomerName(Scanner scanner) {  // Changed return type to String
        System.out.print("Enter customer name: ");
        return scanner.nextLine();
    }

    // Helper function to handle usage input
    public static double receiveUsage(Scanner scanner, String usageType) {
        double value = -1;
        while (value < 0) {
            System.out.print("Enter " + usageType + ": ");
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("Error: Please enter a positive number.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
            }
        }
        return value;
    }

    // Module 2: Calculate Charges for Daytime, Nighttime, Text, and Data
    public static double[] calculateCharges(double daytimeMinutes, double nighttimeMinutes, double textMessages, double dataUsed) {
        double[] charges = new double[4];

        charges[0] = daytimeMinutes * 0.12; // Daytime Charge
        charges[1] = nighttimeMinutes * 0.07; // Nighttime Charge
        charges[2] = textMessages * 0.05; // Text Charge
        charges[3] = dataUsed * 3.00; // Data Charge

        return charges;
    }

    // Module 3: Calculate Total Charge
    public static double calculateTotalCharge(double[] charges) {
        double total = 0;
        for (double charge : charges) {
            total += charge;
        }
        return total;
    }

    // Module 4: Display the Full Bill
    public static void displayBill(String name, double[] charges, double total) {
        System.out.println("\n======= MONTHLY BILL =======");
        System.out.println("Customer: " + name);
        System.out.printf("Daytime Charge: $%.2f\n", charges[0]);
        System.out.printf("Nighttime Charge: $%.2f\n", charges[1]);
        System.out.printf("Text Message Charge: $%.2f\n", charges[2]);
        System.out.printf("Data Charge: $%.2f\n", charges[3]);
        System.out.printf("Total Charge: $%.2f\n", total);
    }
}

