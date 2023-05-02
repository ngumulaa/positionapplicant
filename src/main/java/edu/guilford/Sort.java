package edu.guilford;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Sort 
{
    public static void main( String[] args ) {
        final int MAX; 
        final int RANGE = 100;
        Random rand = new Random(); 

        // ask the user how many objects do they want to create
        System.out.println("How many applicants do you want to create?");
        Scanner scan = new Scanner(System.in);
        MAX = scan.nextInt();

        // create an array of PositionApplicant with random values
        PositionApplicant[] applicants = new PositionApplicant[MAX];
        for (int i = 0; i < MAX; i++) {
            applicants[i] = new PositionApplicant(i, rand.nextInt(RANGE), 
            rand.nextInt(RANGE), rand.nextInt(RANGE), rand.nextInt(RANGE), 
            rand.nextInt(RANGE), rand.nextInt(RANGE));
        }

        // print the array for the selection sort
        long startTime = System.nanoTime();
        PositionApplicant.selectionSort(applicants);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Selection Sort took " + (duration / 1.e6) + " milliseconds");
        // System.out.println("Sorted array:" + Arrays.toString(applicants)); 

        // shuffle the array for the quickSort
        shuffle(applicants);
        startTime = System.nanoTime();
        PositionApplicant.quickSort(applicants);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Quick Sort took " + (duration / 1.e6) + " milliseconds");
        

        shuffle(applicants);
        // print the array using linear search 
        int randValue = rand.nextInt(RANGE);
        startTime = System.nanoTime();
        int index = PositionApplicant.linearSearch(applicants, randValue);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        // System.out.println("Random index: " + index);
        System.out.println("Linear Search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Linear Search found " + randValue + " at index " + index);
        
        shuffle(applicants);
        // print the sorted array
        index = PositionApplicant.binarySearch(applicants, randValue);
        System.out.println("Binary Search took " + (duration / 1.e6) + " milliseconds");
        System.out.println("Binary search found " + randValue + " at index " + index);
        
}
    // shuffle the array
    public static void shuffle(PositionApplicant[] applicants) {
        for (int i = 0; i < applicants.length; i++) {
            int randomIndexToSwap = (int) (Math.random() * applicants.length);
           // swap the current element with the random element 
            PositionApplicant temp = applicants[randomIndexToSwap];
            applicants[randomIndexToSwap] = applicants[i];
            applicants[i] = temp;
        }
    }

    //Add a static method to swap two elements in an array
    public static void swap(PositionApplicant[] applicants, int i, int j) {
        PositionApplicant temp = applicants[i];
        applicants[i] = applicants[j];
        applicants[j] = temp;
    }

    
}
