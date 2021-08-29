/* 	
// AUTHOR: Christian Williams
// FILENAME: Collection.java
// SPECIFICATION: Works with Assignment6.java to modify an array
// FOR: CS 1400 - ASSIGNMENT #6
// TIME SPENT: 2 hours 30 mins
//*/

public class Collection { // Collection Class
	
	//instance fields
	private int myArray[];
	private int count;
	 
	//constructor for Collection class
	public Collection(int arraySize) {
		
		//variables 
		count = 0;
		myArray = new int [arraySize];
	}
	
	//method to search if the number is in the array
	private int search(int searchingNum) {
		
		int result = -1;

		//Goes through array and looks for the number	
		for(int i = 0; i < myArray.length; i++) {			
			
			if(myArray[i] == searchingNum) {	
				result = i;	
				break;
				}
			
			}
		//returns the index of the array	
		return result;	
	}
	
	//Method to add a number into an array
	public boolean add(int numberToAdd) {
		
		boolean add = false;
		int result = 0;
		int nextResult = 0;
		
		//Enters this if statement if the number is not in the array already and 
		//if it has not reached capacity
		if(search(numberToAdd) == -1 && myArray[myArray.length - 1] == 0) {
			
			add = true;
			
			//To get the index of the number that user is trying to add
			for(int i = 0; myArray[i]!= 0; i++) {
				result = i + 1;
				
			}
			//Returns false if the number already exists
			for(int i = 0; i <= myArray.length - 1; i++) {
				
				if(myArray[i] == numberToAdd) {
					add = false;
				}
				
			}
		
			myArray[result] = numberToAdd;
			count = count + 1;
		}
		
		//Enters this if the array is at capacity
		if(myArray[myArray.length - 1] != 0) {
			
			//calls doubleArray method
			doubleArray(numberToAdd);
			
			add = true;
			
			// To get index of new number
			for(int i = 0; myArray[i] != 0; i++) {
				nextResult = i + 1;
			}
			myArray[result] = numberToAdd;
			count = count + 1;
		}

		return add;
		
	}
	
	//Method to remove an integer from the array
	public boolean remove(int numberToRemove) {
		
		boolean remove = false;
		
		//Checks if the number is in the array already
		if(search(numberToRemove) != -1) {
			
				remove = true;
		
				//This is to remove the integer and shift the other numbers to the left
				for(int i = search(numberToRemove); i < myArray.length - 1; i++) {
					
					myArray[i] = myArray[i+1];
					myArray[i+1]=0;
				}	
			}
		
			return remove;
	}
		
	//Method to double the array's capacity
	private void doubleArray(int numArray) {
		
		//new array size
		numArray = myArray.length * 2;
		
		//new temporary array
		int biggerArray[];
		
		biggerArray = new int [numArray];
		
		//This is used to copy all of the elements in the first array to the second
		for(int i = 0; i < myArray.length; i++) {
			biggerArray[i] = myArray[i];
		}
		
		myArray = biggerArray;
		 
	}
	
	//Method to find the largest integer in the array
	public int findLargest() {
		
		int highest = myArray[0];
		
		//This loop scans the array to find the largest integer
		//and assigns it to highest
		for(int i = 1; i < myArray.length; i++) {
			
			if(myArray[i]> highest) {
				
				highest = myArray[i];
			}
		}
		
		return highest;
	}
	
	//This method finds the average of the numbers in the array
	public double computeAvg() {
		
		double number = 0;
		double average = 0;
		
		//This loop adds each integer in the array to a value
		for(int i = 0; i < myArray.length -1 ; i++) {
			
			if(myArray[i] != 0) {
				
				number = number + myArray[i];
			
			}
		}
		
		//This is how the average is calculated
		average = number / count ;
		return average;
	}
	
	//This method finds all the positive numbers in the array
	public int countPositives() {
		
		int positive = 0;
		
		//This loop checks every integer to see if it is positive
		for(int i = 0; i <= myArray.length - 1; i++) {
			
			if(myArray[i] >= 0 && myArray[i] != 0) {
				positive = positive + 1;
			}
		}
		return positive;
	}
	
	//This method turns the array to a string
	public String toString() {
		
		String myString = "";
		
		//This for loop makes the value of the array a string
		for(int i = 0; i < myArray.length - 1; i++) {
			
			if(myArray[i] != 0)
			
				myString = myString + myArray[i] + ",";
			
		}
		
		//returns the array as a string
		return String.format("{" + myString + "}");
		
	}

}//end Collection class