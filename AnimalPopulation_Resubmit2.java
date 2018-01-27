/**
 * The purpose of this program is to determine the average number of squirrels seen until a fox squirrel is seen.
 *
 * @author Briana Berger
 * @version 12/21/17
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
class AnimalPopulation_Resubmit2
{
    public static void main (String [ ] args) throws IOException
    {
       Scanner in = new Scanner(System.in);
       PrintWriter outputFile = new PrintWriter(new File("trials.txt"));
       Scanner inFile = new Scanner(new File("trials.txt"));
       
       Random r = new Random();
       
       int squirrelType = 0;
       //The numbers 1–9 represent other types of squirrels and 10 represented a fox squirrel.

       int count = 0;
       int trials;
       int total = 0;
       int totalSquirrelsPerTrial = 0;
       
       System.out.println();
       
       System.out.println("Welcome to the Fox Squirrel Simulator!");
       System.out.println();
       System.out.println("How many trials should be simulated?");
       System.out.print("Enter a value greater than 1000: " );
       trials = in.nextInt();
       System.out.println();
       
       if (trials <= 1000)
       {
           System.out.println("Please try again. Enter a number greater than 5.");
           System.out.println();
       }
       else if (trials > 1000)
       {
           System.out.println("simulating trials now... one moment please...");
           System.out.println();
           for (int i = 1; i <= trials; i++)
           {
               squirrelType = -1;
               count = 0;
               while(squirrelType != 10)
               {
                   squirrelType = r.nextInt(10) + 1;
                   count++;
               }
               outputFile.println(count);
           }
       }
       outputFile.close();
       
       while(inFile.hasNext())
       {
           totalSquirrelsPerTrial = inFile.nextInt();
           inFile.nextLine(); //purpose: to use the new line character of '\n'
           total += totalSquirrelsPerTrial;
       }
       
       double averageNumberOfFSPerTotal = Math.round(((double)total/trials) * 1000.0)/1000.0; 
       System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
       System.out.println();
       System.out.println("The results!");
       System.out.println("The average number of squirrels observed until spotting a Fox Squirrel at the city park are: " + averageNumberOfFSPerTotal);
    }
}