//Class: CS 5000
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 9
//IDE Name: IntelliJ
import java.util.Scanner;
import java.text.NumberFormat;

public class testSummerStats {
    public static void main(String [] Args){
        int choice = 0;//holds choice
        Scanner inputInt = new Scanner(System.in);
        NumberFormat ft = NumberFormat.getCurrencyInstance();
        NumberFormat ft2 = NumberFormat.getCurrencyInstance();
        ft.setMinimumFractionDigits(0);
        //interactive loop
        while(choice != 1) {
            System.out.print("\nPlease enter number of Employees:\t");//prompt
            int numEmployees = inputInt.nextInt();//scan
            System.out.print("\nPlease enter number of Years:\t");//prompt
            int numYears = inputInt.nextInt();//Scan

            SummerStats table = new SummerStats(numEmployees, numYears);//test object
            System.out.print("Employee Data:\n");//indicator
            table.printSalaries();//test printSalaries

            System.out.print("\n \nEmployee"+table.mostMoney()+" made most money over the years.");//test mostMoney

            System.out.print("\nHighest salary was made in Year"+(table.highestSalaryYear()+1)+".");//test highestSalaryYear

            System.out.print("\nTotal earning by Employee1 is "+ft.format(table.totalEarnings(1))+".");//test totalEarnings

            System.out.print("\nTotal earning by all Employees is "+ft.format(table.allEarnings())+".");//test allEarnings

            System.out.print("\nIn year3, Employee"+table.highestSalaryPerson(3)+" has the highest salary.");//test highestSalaryPerson

            System.out.print("\nThe average salary for year:");//indicator
            double [] array = table.averageSalaryEachYear();

            System.out.print("\n\t \t");//initial spacing
            for (int i = 0; i < array.length; i++){//loop through num of columns
                System.out.print("Year"+(i+1)+"\t \t");//print header labels
            }

            System.out.print("\n\t \t");//initial spacing
            for (int i = 0; i < array.length; i++){//loop through num of columns
                System.out.print("-------------");//print doted line
            }

            System.out.print("\n \t \t");//initial space
            for (int i = 0; i < array.length; i++ ) {//loop through num of columns
                System.out.print(ft2.format(array[i]) + "\t");//print average
            }


            boolean goodEntry = false;
            while(goodEntry == false) {//data validation loop
                // exit prompt
                System.out.print("\n \nExit program?\n\t1.\tYes\n\t2.\tNo\n\t:\t");
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
