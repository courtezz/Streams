package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        // Create a list to store Person objects
        List<Person> people = new ArrayList<>();

        // Populate the list with Person objects
        people.add(new Person("John", "Doe", 30));
        people.add(new Person("Alice", "Smith", 25));
        people.add(new Person("Bob", "Johnson", 40));
        people.add(new Person("Emily", "Williams", 35));
        people.add(new Person("Michael", "Brown", 28));
        people.add(new Person("Emma", "Jones", 22));
        people.add(new Person("Daniel", "Taylor", 45));
        people.add(new Person("Olivia", "Wilson", 32));
        people.add(new Person("James", "Miller", 38));
        people.add(new Person("Sophia", "Davis", 27));

// Calculate the average age
        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        // Find the age of the oldest person
        int oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        // Find the age of the youngest person
        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);

        // Calculate the total age of all people and find the oldest and youngest person
        int totalAge = 0;


        for (Person person : people) {
            totalAge += person.getAge();
            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }
            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        // Display the results
        System.out.println("Average age of all people: " + averageAge);
        System.out.println("Age of the oldest person: " + oldestAge);
        System.out.println("Age of the youngest person: " + youngestAge);


        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a name to search
        System.out.print("Enter a name to search (first or last): ");
        String nameToSearch = scanner.nextLine();

        // Create a new list to store matching people
        List<Person> matchingPeople = new ArrayList<>();

        // Search for the name in the list of people
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(nameToSearch) || person.getLastName().equalsIgnoreCase(nameToSearch)) {
                matchingPeople.add(person);
            }
        }
// Display names of matching people
        if (matchingPeople.isEmpty()) {
            System.out.println("No person found with the name: " + nameToSearch);
        } else {
            System.out.println("Matching people:");
            for (Person person : matchingPeople) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        }
        // Close the scanner
        scanner.close();
    }
}