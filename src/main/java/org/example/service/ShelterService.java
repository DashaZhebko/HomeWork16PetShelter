package org.example.service;

import org.example.model.Pet;

import java.util.List;
import java.util.Scanner;

public class ShelterService {
    public static Scanner scanner = new Scanner(System.in);

    public void addPet(List<Pet> pets) {
        scanner.nextLine();
        System.out.println("Which pet do you want to give away(cat, dog, etc.)?");
        String type = scanner.nextLine();

        if ((type == null) || type.isEmpty()) {
            System.out.println("We cannot take an animal without the specified species. Please enter again!");
        } else {
            System.out.println("What is the name of your pet?");
            String name = scanner.nextLine();

            System.out.println("What breed is your pet?");
            String breed = scanner.nextLine();

            System.out.println("How old is your pet?");
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                pets.add(new Pet(type, name, breed, age));
                System.out.println("The pet was taken to the shelter!");
            } else {
                System.out.println("Please enter the age as a number");
            }
        }
    }

    public void shawAll(List<Pet> pets) {
        if (pets.isEmpty()) {
            System.out.println("There are no pets in shelter");
        } else {
            System.out.println("All pets in the shelter:");
            for (int i = 0; i < pets.size(); i++) {
                System.out.println(i + " -" + pets.get(i));
            }
        }
    }

    public void takePet(List<Pet> pets) {
        if (pets.isEmpty()) {
            System.out.println("There are no pets in shelter");
        } else {
            shawAll(pets);
            System.out.print("Enter the index of the pet to take from the shelter: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < pets.size()) {
                Pet removedPet = pets.remove(index);
                System.out.println("You taken pet " + removedPet + " from shelter!");
            } else {
                System.out.println("Invalid index number. Try again");
            }
        }
    }

    public void menu() {
        System.out.println("Pet Shelter Menu:");
        System.out.println(
                "1. Add pet " + '\n' +
                        "2. Shaw all pets " + '\n' +
                        "3. Take pet from shelter " + '\n' +
                        "4. Exit " + '\n' +
                        "Enter your choice: "
        );
    }

}
