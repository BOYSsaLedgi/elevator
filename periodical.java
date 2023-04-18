import java.util.Scanner;
import java.lang.*;

public class periodical {
    //input
    // get input, floor number first then letter 'u', 'd'
    //get number location of 2 elevators
    //if elevator 1 and 2 is in the same floor, both will go up
    //if not on the same floor,the one who will go to you is the smallest number
        //java delay elevator moving, sysout, elevator opening, 
    //if absolute difference is the same but different floor, when Up is pressed, the one on the bottom will go to you.
    //if down is pressed, the one on the top will go to you.
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int ElevatorLocation;
        int character = 3;
        int elevator1 = 5;
        int elevator2 = 1;
        ElevatorLocation = ElevatorCheck(character, elevator1, elevator2);
        ElevatorStatus(ElevatorLocation, character, elevator1, elevator2);
        //pass the character level to the elevator going up
        //elvator delay
        //opening door , tell what the floor the elevator is in now.
        //delayy 1 second
        //door opened

    }

    public static int ElevatorCheck(int charlvl, int elev1, int elev2)
    {
        int difference1 = charlvl-elev1;
        int difference2 = charlvl-elev2;

        int absdiff1 = Math.abs(difference1);
        int absdiff2 = Math.abs(difference2);

        int x=0;

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
            x = 3; //both on the same floor
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
