import java.util.Scanner;

public class TestHotelRating {
    public static void main (String [] Args){
        int choice = 0;//holds choice
        Scanner inputInt = new Scanner(System.in);

        //interactive loop
        while(choice != 1) {
            System.out.print("\nPlease enter number of hotels:\t");//promt
            int numHotels = inputInt.nextInt();//scan
            System.out.print("\nPlease enter number of Years:\t");//prompt
            int numYears = inputInt.nextInt();//Scan

            HotelRating table = new HotelRating(numHotels, numYears);//instacialize Hotel Rating table

            int[] list = new int[numHotels];//list to take indices of 5 star hotels
            list = table.fiveStarsHotels();//recieve list
            System.out.print("\nFive stars hotels indices:\t \t \t \t");//indicator
            for (int index = 0; index < list.length; index++) {//test fiveStarsHotels
                if (list[index] == -1)//if null trigger
                    continue;//do nothing
                else {
                    System.out.print(list[index]);//print num
                    if (index+1 < list.length) {//if not end
                        if (list[index + 1] == -1)//if null trigger
                            continue;//do nothing
                        else
                            System.out.print(", ");//print separator
                    }
                }
            }

            System.out.print("\nAverage Ratings are:\n");//indicator
            table.averageRatings();//test averageRatings

            System.out.print("Four or more stars hotels indices:\t \t");//indicator
            table.fourOrMoreStars();//test fourOrMoreStars

            System.out.print("\nAny five stars hotel?\t \t \t \t \t");//indicator
            System.out.print(table.anyFiveStars());//test anyFiveStars

            System.out.print("\nBest hotel index:\t \t \t \t \t \t");//indicator
            System.out.print(table.bestHotel());//test bestHotel

            System.out.print("\nWorst hotel index:\t \t \t \t \t \t");//indicator
            System.out.print(table.worstHotel());//test worstHotel

            System.out.print("\nRatings chart:");//indicator
            table.printChart();

            boolean goodEntry = false;
            while(goodEntry == false) {//data validation loop
                // exit prompt
                System.out.print("\nExit program?\n\t1.\tYes\n\t2.\tNo\n\t:\t");
                //Scan choice
                choice = inputInt.nextInt();
                //data validation
                if (choice < 1 || choice > 2) {
                    System.out.println("\t \tInvalid Entree");
                    goodEntry = false;
                }
                else
                    goodEntry = true;
            }
        }
    }
}
