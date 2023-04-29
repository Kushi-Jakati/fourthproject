package edu.guilford;

import java.util.ArrayList;

public class SortingMethods {
    // Add a static selectionSort method that takes an arraylist of double  as a
    // as a parameter and sorts the array using the selection sort algorithm
    public static void SelectionSort(ArrayList<Double> array) {
        for (int i = 0; i < array.size(); i++) {
            // find the smallest element in the array is the first elements
            int smallest = i; // Keeping track of index of the smallest elements
            // not its value
            // loop over all elements after the first elements
            for (int j = i; j < array.size(); j++) {
                // if the current element is smaller than the smallest
                if (array.get(j) < array.get(smallest)) {
                    // Set the smallest element to the current element
                    smallest = j;
                }
            }
            // swap the smallest element with the first element
            swap(array, i, smallest);
        }
    }

    // Add a static selectionSort method that takes an arraylist of Strings as a
    // as a parameter and sorts the array using the selection sort algorithm
    public static void SelectionSortString(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            // find the smallest element in the array is the first elements
            int smallest = i; // Keeping track of index of the smallest elements
            // not its value
            // loop over all elements after the first elements
            for (int j = i; j < array.size(); j++) {
                // if the current element is smaller than the smallest
                if (array.get(j).compareTo(array.get(smallest)) < 0) {
                    // Set the smallest element to the current element
                    smallest = j;
                }
            }
            // swap the smallest element with the first element
            swapString(array, i, smallest);
        }
    }

    //Method that swaps smallest element in the array with the first element
    public static void swap(ArrayList<Double> array, int i, int j) {
        // Store the value of the first element in a temp variable
        double temp = array.get(i);
        // Set the value of the first element to the value of the second parameter
        array.set(i, array.get(j));
        // Set the value of the second parameter to the value of the temp variable
        array.set(j, temp);
    }

    //Method that swaps smallest element in the array with the first element
    public static void swapString(ArrayList<String> array, int i, int j) {
        // Store the value of the first element in a temp variable
        String temp = array.get(i);
        // Set the value of the first element to the value of the second parameter
        array.set(i, array.get(j));
        // Set the value of the second parameter to the value of the temp variable
        array.set(j, temp);
    }

    // Add a static quickSort method that takes a double ArrayList as a
    // parameter and sorts the array using the quick sort algorithm
    public static void quickSort(ArrayList<Double> array, int start, int end) {
        // If the array is empty or has one element, it is already sorted
        if (array.size() == 0 || array.size() == 1) {
            return;
        }
        // If the start index is less than the end index
        if (start < end) {
            // Partition the array
            int partitionIndex = partition(array, start, end);
            // Sort the left side of the partition
            quickSort(array, start, partitionIndex - 1);
            // Sort the right side of the partition
            quickSort(array, partitionIndex + 1, end);
        }
    }

    // Add a static quickSort method that takes a String ArrayList as a
    // parameter and sorts the array using the quick sort algorithm
    public static void quickSortString(ArrayList<String> array, int start, int end) {
        // If the array is empty or has one element, it is already sorted
        if (array.size() == 0 || array.size() == 1) {
            return;
        }
        // If the start index is less than the end index
        if (start < end) {
            // Partition the array
            int partitionIndex = partitionString(array, start, end);
            // Sort the left side of the partition
            quickSortString(array, start, partitionIndex - 1);
            // Sort the right side of the partition
            quickSortString(array, partitionIndex + 1, end);
        }
    }


    //Add a static quickSort method that takes a double ArrayList as a parameter and calls the quickSort
    //method that takes three parameters
    public static void quickSort(ArrayList<Double> array) {
        quickSort(array, 0, array.size() - 1);
    }

    //Add a static quickSort method that takes a String ArrayList as a parameter and calls the quickSort
    //method that takes three parameters
    public static void quickSortString(ArrayList<String> array) {
        quickSortString(array, 0, array.size() - 1);
    }

    // Add a static partition method that takes an ArrayList of doubles as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partition(ArrayList<Double> array, int start, int end) {
        // Set the pivot to the last element in the array
        double pivot = array.get(end);
        // Set the partition index to the start of the array
        int partitionIndex = start;
        // Loop through the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array.get(i) < pivot) {
                // Swap the current element with the element at the partition index
                swap(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }

        // Swap the element at the partition index with the pivot
        swap(array, partitionIndex, end);
        // Return the partition index
        return partitionIndex;
    }

    // Add a static partition method that takes an ArrayList of Strings as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partitionString(ArrayList<String> array, int start, int end) {
        // Set the pivot to the last element in the array
        String pivot = array.get(end);
        // Set the partition index to the start of the array
        int partitionIndex = start;
        // Loop through the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array.get(i).compareTo(pivot) < 0) {
                // Swap the current element with the element at the partition index
                swapString(array, i, partitionIndex);
                // Increment the partition index
                partitionIndex++;
            }
        }

        // Swap the element at the partition index with the pivot
        swapString(array, partitionIndex, end);
        // Return the partition index
        return partitionIndex;
    }

    //Static method that shuffles an ArrayList
    public static void shuffle(ArrayList<Double> array) {
        // Loop through the array
        for (int i = 0; i < array.size(); i++) {
            // Generate a random index
            int randomIndex = (int) (Math.random() * array.size());
            // Swap the current element with the element at the random index
            swap(array, i, randomIndex);
        }
    }

    //Static method that shuffles a String ArrayList
    public static void shuffleString(ArrayList<String> array) {
        // Loop through the array
        for (int i = 0; i < array.size(); i++) {
            // Generate a random index
            int randomIndex = (int) (Math.random() * array.size());
            // Swap the current element with the element at the random index
            swapString(array, i, randomIndex);
        }
    }

    //Add a linear search method that takes an ArrayList of doubles and a double as parameters
    //and returns the index of the double in the ArrayList
    public static int linearSearch(ArrayList<Double> array, double value) {
        // Loop through the array
        for (int i = 0; i < array.size(); i++) {
            // If the current element is equal to the value
            if (array.get(i) == value) {
                // Return the index of the current element
                return i;
            }
        }
        // If the value is not in the array, return -1
        return -1;
    }

    //Add a linear search method that takes an ArrayList of Strings and a String as parameters
    //and returns the index of the String in the ArrayList
    public static int linearSearchString(ArrayList<String> array, String value) {
        // Loop through the array
        for (int i = 0; i < array.size(); i++) {
            // If the current element is equal to the value
            if (array.get(i).equals(value)) {
                // Return the index of the current element
                return i;
            }
        }
        // If the value is not in the array, return -1
        return -1;
    }

    //Add a binary search method that takes an ArrayList of doubles
    // and a double as parameters
    //and returns the index of the double in the ArrayList
    public static int binarySearch(ArrayList<Double> array, double value) {
        // Set the start index to 0
        int start = 0;
        // Set the end index to the last index in the array
        int end = array.size() - 1;
        // Loop while the start index is less than or equal to the end index
        while (start <= end) {
            // Set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // If the value is equal to the value at the middle index
            if (value == array.get(middle)) {
                // Return the middle index
                return middle;
            }
            // If the value is less than the value at the middle index
            if (value < array.get(middle)) {
                // Set the end index to the middle index minus one
                end = middle - 1;
            }
            // If the value is greater than the value at the middle index
            if (value > array.get(middle)) {
                // Set the start index to the middle index plus one
                start = middle + 1;
            }
        }
        // If the value is not in the array, return -1
        return -1;
    }

    //Add a binary search method that takes an ArrayList of Strings
    // and a String as parameters
    //and returns the index of the String in the ArrayList
    public static int binarySearchString(ArrayList<String> array, String value) {
        // Set the start index to 0
        int start = 0;
        // Set the end index to the last index in the array
        int end = array.size() - 1;
        // Loop while the start index is less than or equal to the end index
        while (start <= end) {
            // Set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // If the value is equal to the value at the middle index
            if (value.equals(array.get(middle))) {
                // Return the middle index
                return middle;
            }
            // If the value is less than the value at the middle index
            if (value.compareTo(array.get(middle)) < 0) {
                // Set the end index to the middle index minus one
                end = middle - 1;
            }
            // If the value is greater than the value at the middle index
            if (value.compareTo(array.get(middle)) > 0) {
                // Set the start index to the middle index plus one
                start = middle + 1;
            }
        }
        // If the value is not in the array, return -1
        return -1;
    }
}
