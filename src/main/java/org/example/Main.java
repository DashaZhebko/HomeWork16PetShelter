package org.example;

import org.example.model.Pet;
import org.example.service.ShelterSerializer;
import org.example.service.ShelterService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ShelterService service = new ShelterService();
        List<Pet> pets = ShelterSerializer.loadPetsFromFile();

        boolean mark = true;

        while (mark) {
            service.menu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        service.addPet(pets);
                        break;
                    case 2:
                        service.shawAll(pets);
                        break;
                    case 3:
                        service.takePet(pets);
                        break;
                    case 4:
                        ShelterSerializer.saveToFile(pets);
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
                break;
            }
        }
        scanner.close();
    }
}
