//Class: CS 5000
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 9
//IDE Name: IntelliJ
public class HotelRating {
    private int [] [] table;//rating table

    public HotelRating (int numOfHotels, int numOfYears){//constructor
        table = new int [numOfHotels][numOfYears];//Assign table rows and columns

        //Initializing table with random numbers with numbers between 1-5
        for (int rows = 0; rows < table.length; rows++){//loop through rows
            for (int columns = 0; columns < table[rows].length; columns++){//loop through columns
                table[rows][columns] = (int)(1 + Math.random()*5);//assign random number between 1-5
            }
        }
    }

}
