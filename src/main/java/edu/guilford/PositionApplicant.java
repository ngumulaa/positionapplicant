package edu.guilford;

public class PositionApplicant {
    // attributes: These are what we want each Life object to know about itself

    private int applicantNumber;
    private int introCompProg;
    private int advCompProg;
    private int operatingSystems; 
    private int networking; 
    private int databaseSystems; 
    private int algorithms; 
     

    // constructor
    public PositionApplicant(int applicantNumber, int introCompProg, int advCompProg, int operatingSystems, int networking, int databaseSystems, int algorithms) {
        this.applicantNumber = applicantNumber;
        this.introCompProg = introCompProg;
        this.advCompProg = advCompProg;
        this.operatingSystems = operatingSystems;
        this.networking = networking;
        this.databaseSystems = databaseSystems;
        this.algorithms = algorithms;
        
    }

    // getters and setters
   
    public int getApplicantNumber() {
        return applicantNumber;
    }

    public int getIntroCompProg() {
        return introCompProg;
    }

    public int getAdvCompProg() {
        return advCompProg;
    }

    public int getOperatingSystems() {
        return operatingSystems;
    }

    public int getNetworking() {
        return networking;
    }

    public int getDatabaseSystems() {
        return databaseSystems;
    }

    public int getAlgorithms() {
        return algorithms;
    }

    public void setApplicantNumber(int applicantNumber) {
        this.applicantNumber = applicantNumber;
    }

    public void setIntroCompProg(int introCompProg) {
        this.introCompProg = introCompProg;
    }

    public void setAdvCompProg(int advCompProg) {
        this.advCompProg = advCompProg;
    }

    public void setOperatingSystems(int operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public void setNetworking(int networking) {
        this.networking = networking;
    }

    public void setDatabaseSystems(int databaseSystems) {
        this.databaseSystems = databaseSystems;
    }

    public void setAlgorithms(int algorithms) {
        this.algorithms = algorithms;
    }

    //add a static quickSort method that uses an array of PositionApplicant as a parameter
    //and sorts the array in quicksort
    public static void quickSort(PositionApplicant[] applicants) {
        quickSort(applicants, 0, applicants.length - 1);
    }

    // add a selection sort method that uses an array of integers  as a parameter
    // and sorts the array in selection sort
    public static void selectionSort(PositionApplicant[] applicants) {
        // loop through the array
        for (int i = 0; i < applicants.length; i++) {
            // find the smallest element in the array
            int smallest = i;
            for (int j = i + 1; j < applicants.length; j++) {
                if (applicants[j].applicantNumber < applicants[smallest].applicantNumber) {
                    smallest = j;
                }
            }
            // swap the smallest element with the first element in the array
            PositionApplicant temp = applicants[i];
            applicants[i] = applicants[smallest];
            applicants[smallest] = temp;
        }
    }

    // add a static quicksort method that uses an array of integers as a parameter
    // and sorts the array in quicksort
    public static void quickSort(PositionApplicant[] applicants, int start, int end) {
        // if the array has more than one element
        if (start < end) {
            // partition the array
            int partitionIndex = partition(applicants, start, end);
            // sort the left side of the array
            quickSort(applicants, start, partitionIndex - 1);
            // sort the right side of the array
            quickSort(applicants, partitionIndex + 1, end);
        }
    }

    // add a static partition method that uses an array of integers as a parameter
    // and returns the partition index
    public static int partition(PositionApplicant[] applicants, int start, int end) {
        // set the pivot to the last element in the array
        int pivot = applicants[end].applicantNumber;
        // set the partition index to the first element in the array
        int partitionIndex = start;
        // loop through the array
        for (int i = start; i < end; i++) {
            // if the current element is less than or equal to the pivot
            if (applicants[i].applicantNumber <= pivot) {
                // swap the current element with the element at the partition index
                PositionApplicant temp = applicants[i];
                applicants[i] = applicants[partitionIndex];
                applicants[partitionIndex] = temp;
                // increment the partition index
                partitionIndex++;
            }
        }
        // swap the element at the partition index with the pivot
        PositionApplicant temp = applicants[partitionIndex];
        applicants[partitionIndex] = applicants[end];
        applicants[end] = temp;
        // return the partition index
        return partitionIndex;
    }


    // add a PositionApplicant sort method using linear search 
    public static int linearSearch(PositionApplicant[] applicants, int applicantNumber) {
        // loop through the array
        for (int i = 0; i < applicants.length; i++) {
            // if the current element is equal to the value we are searching for, return the index
            if (applicants[i].applicantNumber == applicantNumber) {
                return i;
            }
        }
        // if we get here, the value was not found, so return -1
        return -1;
    }

    //add a binarySearch algorithm
    public static int binarySearch(PositionApplicant[] applicants, int applicantNumber) {
        // set the start index to 0
        int start = 0;
        // set the end index to the length of the array minus 1
        int end = applicants.length - 1;
        // while the start index is less than or equal to the end index
        while (start <= end) {
            // set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // if the value at the middle index is equal to the value we are searching for, return the index
            if (applicants[middle].applicantNumber == applicantNumber) {
                return middle;
            }
            // if the value at the middle index is less than the value we are searching for, set the start index to the middle index plus 1
            else if (applicants[middle].applicantNumber < applicantNumber) {
                start = middle + 1;
            }
            // if the value at the middle index is greater than the value we are searching for, set the end index to the middle index minus 1
            else {
                end = middle - 1;
            }
        }
        // if we get here, the value was not found, so return -1
        return -1;
    }





}
