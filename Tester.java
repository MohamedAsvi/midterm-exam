
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Mohamed Asvi
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Bmi> bmiRecords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for(int i = 0; i < 5 ; i++){
                        bmiRecords.add(createBmiRecord(scanner));
                        System.out.println("-------------------------");
                    }
                    
                    break;
                case 2:
                    for (Bmi bmi : bmiRecords) {
                        bmi.display();
                        System.out.println("----------------------");
                    }
                    break;
                case 3:
                    int id = getId(scanner);
                    Bmi bmiToDisplay = getBmiById(bmiRecords, id);
                    if (bmiToDisplay != null) {
                        bmiToDisplay.display();
                    } else {
                        System.out.println("No BMI record found for the given ID.");
                    }
                    break;
                case 4:
                    bmiRecords.clear();
                    System.out.println("All BMI records deleted successfully.");
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 5);
    }

    private static Bmi createBmiRecord(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Year of Birth: ");
        int yob = scanner.nextInt();
        System.out.print("Enter Height: ");
        int height = scanner.nextInt();
        System.out.print("Enter Weight: ");
        int weight = scanner.nextInt();
        return new Bmi(id, name, yob, height, weight);
    }

    private static int getId(Scanner scanner) {
        System.out.print("Enter ID: ");
        return scanner.nextInt();
    }

    private static Bmi getBmiById(ArrayList<Bmi> bmiRecords, int id) {
        for (Bmi bmi : bmiRecords) {
            if (bmi.getId() == id) {
                return bmi;
            }
        }
        return null;
    }

    private static void displayMenu() {
        System.out.println("\nBMI Calculator Menu:");
        System.out.println("1. Create a record.");
        System.out.println("2. Show BMI data for all users.");
        System.out.println("3. Show BMI data for a selected user.");
        System.out.println("4. Delete all.");
        System.out.println("5. Exit application.");
    }
}

class Bmi {
    private int id;
    private String name;
    private int yob;
    private int height;
    private int weight;

    public Bmi(int id, String name, int yob, int height, int weight) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public double calculateBmi() {
        return weight / (height * height);
    }

    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
    }
}
