//Class: CS 5000
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 9
//IDE Name: IntelliJ
import java.text.NumberFormat;

public class SummerStats {

    NumberFormat ft = NumberFormat.getCurrencyInstance();//format
    private double [][] chart;//data array

    SummerStats(int newNumEmployees, int newNumYears) {//constructor

        chart = new double[newNumEmployees] [newNumYears];

        for (int i = 0; i < newNumEmployees; i++) {//init array
            for (int j = 0; j < newNumYears; j++) {
                chart[i][j] = (int)(5000 + Math.random()*50001);
            }
        }
    }

    //returns the index of the person having made the most money over the years.
    public int mostMoney() {
        double max = chart[0][0];
        int index = 0;
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                if (chart[i][j] > max) {
                    max = chart[i][j];
                    index = i;
                }
            }
        }
        return index;
    }

    //returns the index of the year when the highest salary was earned.
    public int highestSalaryYear () {
        double max = chart[0][0];
        int index = 0;
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                if (chart[i][j] > max) {
                    max = chart[i][j];
                    index = j;
                }
            }
        }
        return index;
    }

    //returns the total amount of money made by a specific person
    public double totalEarnings(int personIndex) {
        double total = 0;
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                total = total + chart[personIndex][j];
            }
        }
        return total;
    }

    //returns the total amount of money made by all the employees over the years.
    public double allEarnings() {

        double total = 0;

        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                total = total + chart[i][j];
            }
        }
        return total;
    }

    //returns the index of the person who made the highest salary in a given year
    public int highestSalaryPerson(int yearIndex) {
        double max = 0;
        int index = 0;
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                if (j == yearIndex) {
                    if (chart [i][yearIndex] > max) {
                        max = chart [i][yearIndex];
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    //return a one-dimensional array of the average salary for each year.
    public double [] averageSalaryEachYear () {


        double [] averageSalaries = new double [chart[0].length];
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart[i].length; j++) {
                averageSalaries[j] = averageSalaries[j] + chart[i][j];
            }
        }
        return averageSalaries;
    }

    //prints the salaries array (employees’ data) in tabular format
    public void printSalaries() {
        ft.setMinimumFractionDigits(0);

        System.out.print("\n\t \t \t");//initial spacing
        for (int i = 0; i < chart[0].length; i++){//loop for num of columns
            System.out.print("Year"+(i+1)+"\t \t");//print header labels
        }

        System.out.print("\n-----------");//init doted line
        for (int i = 0; i < chart[0].length; i++){//loop for num of columns
            System.out.print("-------------");//print doted line
        }

        for (int i = 0; i < chart.length; i++){//loop through rows
            System.out.print("\nEmployee"+(i+1));//row labels
            for(int j = 0; j < chart[i].length; j++){//loop through columns
                System.out.print("\t"+ft.format(chart[i][j])+"\t");
            }
        }
    }


}