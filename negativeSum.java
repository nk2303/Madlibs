import java.io.*;
import java.util.Scanner;

public class negativeSum {  

    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Please input");
    }

    public static boolean returnSum(Scanner input) {
        if (input == null) {
          return false;
        }

        int sum = 0;
        int count = 0;
        while (input.hasNextInt()) {
          int next = input.nextInt();
          sum += next;
          count++;
          if (sum < 0) {
            System.out.println("sum of " + sum + " after "
                + count + " steps");
            return true;
          }
        }
        System.out.println("no negative sum");
        return false;
      }
} 

