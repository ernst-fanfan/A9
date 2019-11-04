//Class: CS 5000
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 9
//IDE Name: IntelliJ
import java.text.DecimalFormat;
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

    //returns an array of the indices (index values) of hotels that have earned five stars at least once over the years.
    public int [] fiveStarsHotels(){
        //decl and init
        int [] fiveStarList = new int[table.length];//array to hold the 5 star hotels
        int index = 0;//index for fiveStarList

        //Init list
        for (int indexI = 0; indexI < fiveStarList.length; indexI++){//loop through list
            fiveStarList[indexI] = -1;//init with -1
        }

        //extracting indices that have a value of 5 in it.
        for (int rows = 0; rows < table.length; rows++){//loop through rows
            for (int columns = 0; columns < table[rows].length; columns++){//loop through columns
                if (table[rows][columns] == 5) {//if found 5 stars
                    fiveStarList [index] = rows;//set to hotel index
                    index++;//update 5 star list index
                    break;
                }else
                    continue;
            }
            if (index == table.length)//
                break;
        }

        //return list
        return fiveStarList;
    }
    //prints out the average rating (double) for each hotel over the years.
    public void averageRatings(){
        DecimalFormat numFormat = new DecimalFormat("###.##");//num format

        for (int row = 0; row < table.length; row++) {//loop through rows
            double average = 0;//holds average
            for (int column = 0; column < table[row].length; column++) {//loop through columns
                average = table[row][column] + average;//sums up all values for row
            }
            average = average/table[row].length;//calculates average
            System.out.println("\t \tHotel "+numFormat.format(row)+":\t \t \t \t \t \t"+average);//prints average
        }
    }
    //prints out the indices (index values) of hotels that have earned four or more starts at least once.
    public void fourOrMoreStars(){
        //extracting indices that have a value of 5 in it.
        for (int columns = 1; columns < table[0].length; columns++){//loop through columns
            if (table[0][columns] > 3) {//if found 4 or more stars
                System.out.print(0);//prints out index
                break;
            }
        }
        for (int rows = 1; rows < table.length; rows++){//loop through rows
            for (int columns = 0; columns < table[rows].length; columns++){//loop through columns
                if (table[rows][columns] > 3) {//if found 4 or more stars
                    System.out.print(", "+rows);//prints out index
                    break;
                }
            }
        }
    }
    //returns true if at least one hotel earned five stars for at least one year; false otherwise.
    public boolean anyFiveStars(){
        boolean found5 = false;//decl and init

        //look for five
        for (int rows = 0; rows < table.length; rows++){//loop through rows
            for (int columns = 0; columns < table[rows].length; columns++){//loop through columns
                if (table[rows][columns] == 5) {//if found 5
                    found5 = true;//set to true
                    break;//leave column loop
                }
                if (found5 == true)//if true
                    break;//leave row loop
            }
        }
        return found5;
    }
    //returns the index for the best quality hotel over the years. If more than one hotel, return the index of the first hotel in the array.
    public int bestHotel(){
        //Decl and Init
        int bestHotel = -1;
        double bestAverage = -1.00;

        //look for best
        for (int row = 0; row < table.length; row++) {//loop through rows
            double average = 0;//holds average
            for (int column = 0; column < table[row].length; column++) {//loop through columns
                average = table[row][column] + average;//sums up all values for row
            }
            average = average/table[row].length;//calculates average
            if (bestAverage < average){//compares average to best average, if not best average
                bestHotel = row;//set best hotel to current row
                bestAverage = average;//set to new best average
            }
        }
        return bestHotel;//returns best Hotel
    }
    //returns the index for the worst quality hotel over the years. If more than one hotel, return the index of the first hotel in the array.
    public int worstHotel(){
        //Decl and Init
        int worstHotel = -1;
        double worstAverage = 5;

        //look for worst
        for (int row = 0; row < table.length; row++) {//loop through rows
            double average = 0;//holds average
            for (int column = 0; column < table[row].length; column++) {//loop through columns
                average = table[row][column] + average;//sums up all values for row
            }
            average = average/table[row].length;//calculates average
            if (worstAverage > average){//compares average to best average, if not best average
                worstHotel = row;//set best hotel to current row
                worstAverage = average;//set to new best average
            }
        }
        return worstHotel;//returns worst Hotel
    }
    //prints out the ratings chart for all hotels
    public void printChart(){
        System.out.print("\n\t \t \t");//initial spacing
        for (int count = 0; count < table[0].length; count++){//loop for num of columns
            System.out.print("Year"+(count+1)+"\t \t");//print header labels
        }

        System.out.print("\n-----------");//init doted line
        for (int count = 0; count < table[0].length; count++){//loop for num of columns
            System.out.print("-------------");//print doted line
        }

        for (int row = 0; row < table.length; row++){//loop through rows
            System.out.print("\nHotel "+row+":");//row labels
            for(int column = 0; column < table[row].length; column++){//loop through columns
                System.out.print("\t");//spacing before
                printStars(row, column);//print stars
                System.out.print(" \t");//spacing after
            }
        }
    }
    //prints starts based on value at indices withing a 5 spaces limit
    private void printStars(int row, int column){
        for (int stars = 0; stars < table[row][column]; stars++)//loop through stars
            System.out.print("*");//print stars
        for (int spaces = 0; spaces < 5-table[row][column];spaces++)//loop through spaces
            System.out.print(" ");//print spaces
    }
}
