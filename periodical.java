import java.util.Scanner;
import java.lang.*;
import java.util.Date; 
//import java.util.Random;

public class periodical {
    //input
    // get input, floor number first then letter 'u', 'd'
    //get number location of 2 elevators
    //if elevator 1 and 2 is in the same floor, both will go up
    //if not on the same floor,the one who will go to you is the smallest number
        //java delay elevator moving, sysout, elevator opening, 
    //if absolute difference is the same but different floor, when Up is pressed, the one on the bottom will go to you.
    //if down is pressed, the one on the top will go to you.

    //MAIN FUNCTION//
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        //RANDOMIZER//
        int min = 1; // Minimum value of range
        int max = 7; // Maximum value of range
        int elevator1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int elevator2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println(elevator1);
        System.out.println(elevator2);

        int ElevatorLocation; //to get which elevator is nearest to you
        int character = 1; //variable for character location
        //int elevator1 = 5; //variable for  elevator1 location
        //int elevator2 = 7; //variable for elevator 2 location

        ElevatorLocation = ElevatorCheck(character, elevator1, elevator2);
        ElevatorStatus(ElevatorLocation, character, elevator1, elevator2);

        //GETTING THE FLOOR NUMBER OF NEAREST ELEVATOR//
        int NearestElevator = 0;
        if (ElevatorLocation == 1)
        {
            NearestElevator = elevator2;
        }
        else if (ElevatorLocation == 2)
        {
            NearestElevator = elevator1;
        }
        else if ( ElevatorLocation == 3)
        {
            NearestElevator = elevator2;
        }

        
        

        //elevator delay
        int AbsFloorDiff = ReturnAbsDifference(character, elevator1, elevator2);
        Delay(2000, AbsFloorDiff, NearestElevator); //It takes 2 seconds to travel in each floor.


        //pass the character level to the elevator going up
        if (ElevatorLocation==1)
        {
            elevator2 = character;
            System.out.println("elevator 2: " + elevator2);
        }
        else if (ElevatorLocation==2)
        {
            elevator1 = character;
            System.out.println("elevator 1: " + elevator1);
        }
        else if(ElevatorLocation==3)
        {
            elevator2 = character;
            System.out.println("elevator 2: " + elevator2);
        }
        
        //opening door , tell what the floor the elevator is in now.
        System.out.print("Elevator 1: " + elevator1);
        System.out.println(" || Elevator 2: " + elevator2);

        //delayy 1 second
        Delay(1000); //it takes 1 second for the door to open

        //door opened
        System.out.println("Open sesame");

        //delay 1 second
        Delay(1000); //it takes 1 second for the door to close

        //door closed
        System.out.println("Door closed");
    }
    // DELAY FUNCTION FOR 1 SECOND
    public static void Delay(int x) //waiting for few seconds
    {
            try
            {
                Thread.sleep(x);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        
    }
    // DELAY FUNCTION FOR ELEVATOR MOVING
    public static void Delay(int x, int floordiff, int floorlvl) //waiting for few seconds
    {
        
        for (int y = 1; y<=floordiff; y++)
        {
            System.out.print("HITLER");
            try
            {
                Thread.sleep(x);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        System.out.println();
        /*
         * IF FLOORLVL > CHARACTER
         *  FOR LOOP FLOOR LVL --
         * ELSE IF FLOORLVL < CHARACTER
         *  FOR LOOP FLOOR LVL ++
         */
    }
    public static int ElevatorCheck(int charlvl, int elev1, int elev2) //to check which elevator is nearest to you
    {
        int difference1 = charlvl-elev1; //how far elev1 from character
        int difference2 = charlvl-elev2; //how far elev2 from character

        int absdiff1 = Math.abs(difference1); //absolute value of elev1
        int absdiff2 = Math.abs(difference2); //absolute value of elev2

        int x=0; //x will serve as return value

        if (absdiff1>absdiff2)
        {
            x = 1; //elevator 2 is nearer
        }
        else if (absdiff1<absdiff2)
        {
            x = 2; //elevator 1 is nearer
        }
        else if (absdiff1==absdiff2)
        {
            x = 3; //both on the same floor or same distance
        }
        return x;
    }
    public static int ReturnAbsDifference (int charlvl, int elev1, int elev2) //basically the same with ElevatorCheck() but only returns the abs floor difference
    {
        int difference1 = charlvl-elev1; //how far elev1 from character
        int difference2 = charlvl-elev2; //how far elev2 from character

        int absdiff1 = Math.abs(difference1); //absolute value of elev1
        int absdiff2 = Math.abs(difference2); //absolute value of elev2

        int x=0; //x will serve as return value

        if (absdiff1>absdiff2)
        {
            x = absdiff2; //elevator 2 is nearer
        }
        else if (absdiff1<absdiff2)
        {
            x = absdiff1; //elevator 1 is nearer
        }
        else if (absdiff1==absdiff2)
        {
            x = absdiff2; //both on the same floor or same distance
        }
        return x;
    }
    public static void ElevatorStatus(int x, int charlvl, int elev1, int elev2) //TO DETERMINE IF ELEV WILL GO UP OR DOWN
    {
        if (x == 1) //elevator 2 is nearer
        {
            int location = charlvl - elev2; //to check if elevator is above or below you
            if (location > 0)
            {
                System.out.println("ELEVATOR 2 IS GOING UP");
            }
            else if (location<0)
            {
                System.out.println("ELEVATOR 2 IS GOING DOWN");
            }
        }
        else if (x == 2) //elevator 1 is nearer
        {
            int location = charlvl - elev1; //to check if elevator is above or below you
            if (location > 0)
            {
                System.out.println("ELEVATOR 1 IS GOING UP");
            }
            else if (location<0)
            {
                System.out.println("ELEVATOR 1 IS GOING DOWN");
            }
        }
        else if (x == 3) // elevators are both on the same floor
        {
            int location = charlvl - elev2; //to check if elevator is above or below you
            if (location > 0)
            {
                System.out.println("ELEVATOR 2 IS GOING UP");
            }
            else if (location<0)
            {
                System.out.println("ELEVATOR 2 IS GOING DOWN");
            }
        }
    }
}

