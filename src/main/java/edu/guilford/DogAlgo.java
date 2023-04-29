package edu.guilford;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class DogAlgo {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        ArrayList<Dogs> allDogs = new ArrayList<Dogs>();
        ArrayList<String> dogNames = new ArrayList<String>();
        ArrayList<String> dogBreeds = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> dogWeights = new ArrayList<Double>();
        Random rand = new Random();
        File sourceFile = new File(DogAlgo.class.getResource("/dogNames.txt").toURI());
        File sourceFile2 = new File(DogAlgo.class.getResource("/dogBreeds.txt").toURI());
        Scanner scan = new Scanner(sourceFile);
        Scanner scan2 = new Scanner(sourceFile2);

        // Put all lines from sourceFile into dogNames array
        while (scan.hasNextLine()) {
            dogNames.add(scan.nextLine());
        }

        // Put all lines from sourceFile2 into dogBreeds array
        while (scan2.hasNextLine()) {
            dogBreeds.add(scan2.nextLine());
        }

        // Close scanners
        scan.close();
        scan2.close();

        Scanner userScan = new Scanner(System.in);
        System.out.println("Enter the number of dog objects you would like to generate (must be an integer): ");
        int numDogs = userScan.nextInt();
        // Check if numDogs is positive
        while (numDogs <= 0) {
            System.out.println("Please enter an integer greater than 0: ");
            numDogs = userScan.nextInt();
        }

        System.out.println("Would you like to sort by weight or name? Please type 'weight' or 'name': ");
        String sortType = userScan.next();
        while (!sortType.contentEquals("weight") && !sortType.contentEquals("name")) {
            System.out.println("Please type 'weight' or 'name': ");
            sortType = userScan.next();
        }

        // Since dogNames is the bigger length, we will use that.
        // Choose a random line of text from file DogNames and dogBreeds and put it into
        // a dog object
        for (int i = 0; i < numDogs + 1; i++) {
            String name = dogNames.get(rand.nextInt(dogNames.size()));
            String breed = dogBreeds.get(rand.nextInt(dogBreeds.size()));
            Dogs dog = new Dogs(name, breed);
            allDogs.add(dog);
            // add weight to dogWeights array
            dogWeights.add(dog.getWeight());
            names.add(dog.getName());

        }

        // // loop through arraylist and print out all info
        // String allInfo = "";
        // for (Dogs dog : allDogs) {
        // allInfo = dog.toString() + "\n" + "Life Expectancy: " +
        // dog.liklihoodOfDeath() + "\n";
        // System.out.println(allInfo);
        // }

        long startTime;
        long endTime;
        long duration;

        if (sortType.contentEquals("weight")) {

            // Sort name array using selection sort
            startTime = System.nanoTime();
            SortingMethods.SelectionSort(dogWeights);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted weights with Selection Sort: " + dogWeights.toString());
            System.out.println("Selection Sort Time: " + (duration / 1.e6) + " milliseconds \n");

            // shuffle array
            SortingMethods.shuffle(dogWeights);

            startTime = System.nanoTime();
            // Sort the array using the quickSort algorithm
            SortingMethods.quickSort(dogWeights);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted weights with Quick Sort: " + dogWeights.toString());
            System.out.println("Quick Sort Time: " + (duration / 1.e6) + " milliseconds \n");

            // shuffle array
            SortingMethods.shuffle(dogWeights);

        } else if (sortType.contentEquals("name")) {

            startTime = System.nanoTime();
            SortingMethods.SelectionSortString(names);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted names with Selection Sort: " + names.toString());
            System.out.println("Selection Sort Time: " + (duration / 1.e6) + " milliseconds +\n");

            // shuffle array
            SortingMethods.shuffleString(names);

            // Sort name array using quick sort
            startTime = System.nanoTime();
            SortingMethods.quickSortString(names);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted names with Quick Sort: " + names.toString());
            System.out.println("Quick Sort Time: " + (duration / 1.e6) + " milliseconds \n");

            // shuffle array
            SortingMethods.shuffleString(names);

        }

        System.out.println(
                "Now, for the Linear and Binary Search Algorithms, would you like to search for a dog with a specific weight or name? Please type 'weight' or 'name': ");
        String searchType = userScan.next();
        while (!searchType.contentEquals("weight") && !searchType.contentEquals("name")) {
            System.out.println("Please type 'weight' or 'name': ");
            searchType = userScan.next();
        }

        if (searchType.contains("weight")) {
            // Choose a random weight from dogWeights array as our target
            double targetWeight = dogWeights.get(rand.nextInt(dogWeights.size()));
            System.out.println(
                    "We will do both a linear and binary search through our shuffled array for a dog with a weight of "
                            + targetWeight + " pounds in our array");
            // Sort name array using linear search
            // Sort the array using the linearSearch algorithm
            startTime = System.nanoTime();
            SortingMethods.linearSearch(dogWeights, targetWeight);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted weights with Linear Search: " + dogWeights.toString());
            System.out.println("Linear Search Time: " + (duration / 1.e6) + " milliseconds \n");

            // shuffle array
            SortingMethods.shuffle(dogWeights);

            // Sort the array using the binarySearch algorithm
            startTime = System.nanoTime();
            SortingMethods.binarySearch(dogWeights, targetWeight);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Sorted weights with Binary Search: " + dogWeights.toString());
            System.out.println("Binary Search Time: " + (duration / 1.e6) + " milliseconds \n");

            System.out.println(
                    "Would you like to see the time differences if the array was already shuffled? Please type 'yes' or 'no': ");
            String shuffle = userScan.next();
            while (!shuffle.contentEquals("yes") && !shuffle.contentEquals("no")) {
                System.out.println("Please type 'yes' or 'no': ");
                shuffle = userScan.next();
            }
            if (shuffle.contentEquals("yes")) {
                // Sort weight array using quickSort algorithm
                SortingMethods.quickSort(dogWeights);
                // Search name array using linear search
                startTime = System.nanoTime();
                SortingMethods.linearSearch(dogWeights, targetWeight);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Linear Search Time: " + (duration / 1.e6) + " milliseconds \n");

                // Search name array using binary search
                startTime = System.nanoTime();
                SortingMethods.binarySearch(dogWeights, targetWeight);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Binary Search Time: " + (duration / 1.e6) + " milliseconds \n");
            } else if (shuffle.contentEquals("no")) {
                System.out.println("Okay, thanks.");
            }

        } else if (searchType.contains("name")) {

            // Choose a random name from names array as our target
            String targetName = names.get(rand.nextInt(names.size()));
            System.out.println(
                    "We will do both a linear and binary search through our shuffled array for a dog with a name of "
                            + targetName + " in our array.");
            // Sort name array using linear search
            startTime = System.nanoTime();
            SortingMethods.linearSearchString(names, "A");
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Linear Search Time: " + (duration / 1.e6) + " milliseconds \n");

            // Sort name array using binary search
            startTime = System.nanoTime();
            SortingMethods.binarySearchString(names, "A");
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Binary Search Time: " + (duration / 1.e6) + " milliseconds \n");

            System.out.println(
                    "Would you like to see the time differences if the array was already shuffled? Please type 'yes' or 'no': ");
            String shuffle = userScan.next();
            while (!shuffle.contentEquals("yes") && !shuffle.contentEquals("no")) {
                System.out.println("Please type 'yes' or 'no': ");
                shuffle = userScan.next();
            }
                if (shuffle.contentEquals("yes")) {
                    // Sort name array using quickSort algorithm
                    SortingMethods.quickSortString(names);
                    // Search name array using linear search
                    startTime = System.nanoTime();
                    SortingMethods.linearSearchString(names, targetName);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Linear Search: " + (duration / 1.e6) + " milliseconds \n");

                    // Search name array using binary search
                    startTime = System.nanoTime();
                    SortingMethods.binarySearchString(names, targetName);
                    endTime = System.nanoTime();
                    duration = (endTime - startTime);
                    System.out.println("Binary Search: " + (duration / 1.e6) + " milliseconds \n");
                } else if (shuffle.contentEquals("no")) {
                    System.out.println("Okay, thanks.");
                }
            }
        }
    }