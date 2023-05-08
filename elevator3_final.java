import java.util.Scanner;
public class elevator3_final {

public static void main(String args[]) {

    Scanner scan = new Scanner (System.in);
    char doYouWant; //do you want to use the elevator?
    int contStart = 1; //checker if the user wants to try the elevator
    int contRandMan = 1; //checker if user wants to choose random or manual
    int contUD = 1; //checker if user wants to go Up or Down

    int elevatorLocation; //to get which elevator is nearest to you
    int character = 1; //variable for character location
    int elevator1 = 5; //variable for  elevator1 location
    int elevator2 = 7; //variable for elevator 2 location
    int min = 1; // Minimum value of range
    int max = 7; // Maximum value of range
    elevator1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
    elevator2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
    topdesign(elevator1, elevator2);
    elevIdle();
    System.out.print("\n    Do you want to use the ELEVATOR? Y or N:");

    do {
        doYouWant = scan.next().charAt(0);

        if (doYouWant == 'Y' || doYouWant =='y') {
            contStart = 1;
            deleteLine(2);

            System.out.print("\n    Do you want to manually place the elevators or make it random? R or M:");            
            do {
                contRandMan = 1;
                doYouWant = scan.next().charAt(0);
                if (doYouWant == 'R' || doYouWant =='r') {
                    deleteLine(2);
                    System.out.print("\n    Random!");
                    contRandMan = 0;
                }
                else if (doYouWant == 'M' || doYouWant =='m') {
                    deleteLine(2);
                    System.out.print("\n    Manual!");
                    contRandMan = 0;
                }
                else {
                    deleteLine(2);
                    contRandMan = 1;
                    System.out.print("\n    Please choose between R(andom) or M(anual): ");
                }
            } while (contRandMan == 1);

            delay(1000);

            //RANDOMIZER//
            if (doYouWant == 'R' || doYouWant =='r') {
            elevator1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            elevator2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
            }

            else if (doYouWant == 'M' || doYouWant =='m') {
                deleteLine(1);
                System.out.print("\n    Which floor will be the RIGHT ELEVATOR? 1 - 7: ");
                do {
                    contRandMan = 1;
                    elevator1 = scan.nextInt();
                    if (elevator1 < 1) {
                        deleteLine(2);
                        System.out.print("\n    Number is too low! Pick from 1 - 7: ");
                        contRandMan = 1;
                    }
                    else if (elevator1 > 7) {
                        deleteLine(2);
                        System.out.print("\n    Number is too high! Pick from 1 - 7: ");
                        contRandMan = 1;
                    }
                    else {
                        contRandMan = 0;
                    }
                } while (contRandMan == 1);

                deleteLine(2);
                do {
                    contRandMan = 1;
                    System.out.print("\n    Which floor will be the LEFT ELEVATOR? 1 - 7: ");
                    elevator2 = scan.nextInt();
                    if (elevator2 < 1) {
                        deleteLine(2);
                        System.out.print("\n    Number is too low! Pick from 1 - 7: ");
                        contRandMan = 1;
                    }
                    else if (elevator2 > 7) {
                        deleteLine(2);
                        System.out.print("\n    Number is too high! Pick from 1 - 7: ");
                        contRandMan = 1;
                    }
                    else {
                        contRandMan = 0;
                    }
                } while (contRandMan == 1);
            }

            deleteLine(11);
            System.out.println();
            topdesign(elevator1, elevator2);
            elevIdle();

            System.out.print("\n    Which floor will YOU be at? 1 - 7: ");
            do {
                contRandMan = 1;
                character = scan.nextInt();
                if (character < 1) {
                    deleteLine(2);
                    System.out.print("\n    Number is too low! Pick from 1 - 7: ");
                    contRandMan = 1;
                }
                else if (character > 7) {
                    deleteLine(2);
                    System.out.print("\n    Number is too high! Pick from 1 - 7: ");
                    contRandMan = 1;
                }
                else {
                    contRandMan = 0;
                }
            } while (contRandMan == 1);

            deleteLine(11);
            System.out.println();
            topdesign(elevator1, elevator2, character);
            elevIdle();

            if (character <= 1) {
                System.out.print("\n    Please pick U: ");
            }
            else if (character >= 7) {
                System.out.print("\n    Please pick D: ");
            }
            else if (character > 1 && character < 7) {
                System.out.print("\n    Please pick U or D: ");
            }
            do {
                contUD = 1;
                if (character <= 1) {
                    doYouWant = scan.next().charAt(0);
                    if (doYouWant == 'U' || doYouWant =='u') {
                        contUD = 0;
                    }
                    else {
                        contUD = 1;
                        deleteLine(2);
                        System.out.print("\n    U(p) only: ");
                    }
                }
                else if (character >= 7) {
                    doYouWant = scan.next().charAt(0);
                    if (doYouWant == 'D' || doYouWant =='d') {
                        contUD = 0;
                    }
                    else {
                        contUD = 1;
                        deleteLine(2);
                        System.out.print("\n    D(own) only: ");
                    }
                }
                else if (character > 1 && character < 7) {
                    doYouWant = scan.next().charAt(0);
                    if (doYouWant == 'D' || doYouWant =='d') {
                        contUD = 0;
                    }
                    else if (doYouWant == 'U' || doYouWant =='u') {
                        contUD = 0;
                    }
                    else {
                        contUD = 1;
                        deleteLine(2);
                        System.out.print("\n    U(p) or D(own): ");
                    }
                }
            } while (contUD == 1);

            deleteLine(2);

            //checker of Elevator level (Absolute Difference)
            elevatorLocation = elevatorCheck(character, elevator1, elevator2);
            char top = ' ';
            char mid = ' ';
            char bot = ' ';
            String upDown = " ";
            int checkUpOrDown = elevatorStatus(elevatorLocation, character,elevator1,elevator2);

            if (doYouWant == 'U' || doYouWant =='u') {
                top = '^';
                mid = '|';
                bot = '|';
            }
            if (doYouWant == 'D' || doYouWant =='d') {
                top = '|';
                mid = '|';
                bot = 'V';
            }
    
            //Visual changer for elevators to move up or down
            if (checkUpOrDown == 1 || checkUpOrDown == 3)
            {
                upDown = "/\\";
            }
            else if (checkUpOrDown == 2 || checkUpOrDown == 4)
            {
                upDown = "\\/";
            }

            if (elevatorLocation == 1 || elevatorLocation == 3)
            {
                if (elevator2<character)
                {
                    for (int y = elevator2; y <=character;y++)
                    {
                        elevator2 = y;
                        deleteLine(9);
                        topdesignRight(elevator1, elevator2, character, upDown);
                        elevIdle(top,mid,bot);
                        delay(2000);
                    }
                }
                else if (elevator2>character)
                {
                    for (int y = elevator2; y >=character;y--)
                    {
                        elevator2 = y;
                        deleteLine(9);
                        topdesignRight(elevator1, elevator2, character, upDown);
                        elevIdle(top,mid,bot);
                        delay(2000);
                    }
                } 

                delay(1000);
                deleteLine(9);
                topdesign(elevator1, elevator2, character);
    
                rightElevOpening();

                delay(1000);
                deleteLine(7);
    
                rightElevClosing();
            }
            else if (elevatorLocation == 2)
            {
                if (elevator1<character)
                {
                    for (int y = elevator1; y <=character;y++)
                    {
                        elevator1 = y;
                        deleteLine(9);
                        topdesignLeft(elevator1, elevator2, character, upDown);
                        elevIdle(top,mid,bot);
                        delay(2000);
                    }
                }
                else if (elevator1>character)
                {
                    for (int y = elevator1; y >=character;y--)
                    {
                        elevator1 = y;
                        deleteLine(9);
                        topdesignLeft(elevator1, elevator2, character, upDown);
                        elevIdle(top,mid,bot);
                        delay(2000);
                    }
                } 

                delay(1000);
                deleteLine(9);
                topdesign(elevator1, elevator2, character);
    
                leftElevOpening();

                delay(1000);
                deleteLine(7);
    
                leftElevClosing();
            }
            
            deleteLine(2);

            System.out.print("\n    Do you want to use the ELEVATOR? Y or N:");
        }
        else if (doYouWant == 'N' || doYouWant =='n') {
            contStart = 0;
            deleteLine(2);
        }
        else {
            contStart = 1;
            deleteLine(2);
            System.out.print("\n    Please choose between Y or N:");
        }

    } while (contStart == 1);

    System.out.println("\n    Thank you for using our Elevator !!!\n");

    }

public static void delay(int x) //waiting for few seconds
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

public static int returnAbsDifference (int charlvl, int elev1, int elev2) //basically the same with elevatorCheck() but only returns the abs floor difference
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

public static void deleteLine(int x) 
    {
        //int x is for the number of lines to delete
        for (int y = 1 ; y<=x; y++)
        {
            System.out.print(String.format("\033[%dA",1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }    
    }

public static void topdesign(int x, int y)
    {
        System.out.println("    ___________________________________________");
        System.out.println("    |      |     |               |     |      |");
        System.out.println("    |      |  "+x+"  |               |  "+y+"  |      |");
        System.out.println("    |______|_____|_______________|_____|______|");    
    }
public static void topdesign(int x, int y, int z)
    {
        System.out.println("    ___________________________________________");
        System.out.println("    |      |     |    ,-----,    |     |      |");
        System.out.println("    |      |  "+x+"  |    |  "+z+"  |    |  "+y+"  |      |");
        System.out.println("    |______|_____|____'_____'____|_____|______|");    
    }
public static void topdesignRight(int x, int y, int z, String a)
    {
        System.out.println("    ___________________________________________");
        System.out.println("    |      |     |    ,-----,    |     |      |");
        System.out.println("    |      |  "+x+"  |    |  "+z+"  |    |  "+y+"  |  "+a+"  |");
        System.out.println("    |______|_____|____'_____'____|_____|______|");    
    }
    public static void topdesignLeft(int x, int y, int z, String a)
    {
        System.out.println("    ___________________________________________");
        System.out.println("    |      |     |    ,-----,    |     |      |");
        System.out.println("    |  "+a+"  |  "+x+"  |    |  "+z+"  |    |  "+y+"  |      |");
        System.out.println("    |______|_____|____'_____'____|_____|______|");    
    }
    public static void topdesignBoth(int x, int y, int z, String a, String b)
    {
        System.out.println("    ___________________________________________");
        System.out.println("    |      |     |    ,-----,    |     |      |");
        System.out.println("    |  "+a+"  |  "+x+"  |    |  "+z+"  |    |  "+y+"  |  "+b+"  |");
        System.out.println("    |______|_____|____'_____'____|_____|______|");    
    }
public static void elevIdle(char x, char y, char z)
    { 
        //x = top, y = mid, z= bot
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |   "+x+"   |      |      |  |");
        System.out.println("    |  |      |      |   "+y+"   |      |      |  |");
        System.out.println("    |  |      |      |   "+z+"   |      |      |  |");
        System.out.println("    |__|______|______|_______|______|______|__|");
    }
public static void elevIdle()
    { 
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |       |      |      |  |");
        System.out.println("    |  |      |      |       |      |      |  |");
        System.out.println("    |  |      |      |       |      |      |  |");
        System.out.println("    |__|______|______|_______|______|______|__|");
    }

public static void rightElevHalfOpen()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |       |    |   |    |  |");
        System.out.println("    |  |      |      |       |    |   |    |  |");
        System.out.println("    |  |      |      |       |    |   |    |  |");
        System.out.println("    |__|______|______|_______|____|___|____|__|");
    }

public static void rightElevHalfClose()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |       |    | O |    |  |");
        System.out.println("    |  |      |      |       |    |/|\\|    |  |");
        System.out.println("    |  |      |      |       |    | | |    |  |");
        System.out.println("    |__|______|______|_______|____|/_\\|____|__|");
    }

public static void rightElevFullOpen()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |       | |         | |  |");
        System.out.println("    |  |      |      |       | |         | |  |");
        System.out.println("    |  |      |      |       | |         | |  |");
        System.out.println("    |__|______|______|_______|_|_________|_|__|");
    }

public static void rightElevFullClose()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |      |      |       | |    O    | |  |");
        System.out.println("    |  |      |      |       | |   /|\\   | |  |");
        System.out.println("    |  |      |      |       | |    |    | |  |");
        System.out.println("    |__|______|______|_______|_|___/_\\___|_|__|");
    }

public static void rightElevOpening()
    {
        elevIdle();
        System.out.println("\n    Right Elevator Opening.");
        delay(1000);
        deleteLine(7);

        rightElevHalfOpen();
        System.out.println("\n    Right Elevator Opening..");
        delay(1000);
        deleteLine(7);

        rightElevFullOpen();
        System.out.println("\n    Right Elevator Opening...");
        
    }
public static void rightElevClosing()
    {
        rightElevFullClose();
        System.out.println("\n    Right Elevator Closing.");
        delay(1000);
        deleteLine(7);

        rightElevHalfClose();
        System.out.println("\n    Right Elevator Closing..");
        delay(1000);
        deleteLine(7);

        elevIdle();
        System.out.println("\n    Right Elevator Closing...");
    }

public static void leftElevHalfOpen()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |    |   |    |       |      |      |  |");
        System.out.println("    |  |    |   |    |       |      |      |  |");
        System.out.println("    |  |    |   |    |       |      |      |  |");
        System.out.println("    |__|____|___|____|_______|______|______|__|");
    }

public static void leftElevHalfClose()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  |    | O |    |       |      |      |  |");
        System.out.println("    |  |    |/|\\|    |       |      |      |  |");
        System.out.println("    |  |    | | |    |       |      |      |  |");
        System.out.println("    |__|____|/_\\|____|_______|______|______|__|");
    }

public static void leftElevFullOpen()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  | |         | |       |      |      |  |");
        System.out.println("    |  | |         | |       |      |      |  |");
        System.out.println("    |  | |         | |       |      |      |  |");
        System.out.println("    |__|_|_________|_|_______|______|______|__|");
    }

public static void leftElevFullClose()
    {
        System.out.println("    |  _______________       _______________  |");
        System.out.println("    |  | |    O    | |       |      |      |  |");
        System.out.println("    |  | |   /|\\   | |       |      |      |  |");
        System.out.println("    |  | |    |    | |       |      |      |  |");
        System.out.println("    |__|_|___/_\\___|_|_______|______|______|__|");
    }

public static void leftElevOpening()
    {
        elevIdle();
        System.out.println("\n    Left Elevator Opening.");
        delay(1000);
        deleteLine(7);

        leftElevHalfOpen();
        System.out.println("\n    Left Elevator Opening..");
        delay(1000);
        deleteLine(7);

        leftElevFullOpen();
        System.out.println("\n    Left Elevator Opening...");
    }

public static void leftElevClosing()
    {
        leftElevFullClose(); 
        System.out.println("\n    Left Elevator Closing.");
        delay(1000);
        deleteLine(7);

        leftElevHalfClose();
        System.out.println("\n    Left Elevator Closing..");
        delay(1000);
        deleteLine(7);

        elevIdle();
        System.out.println("\n    Left Elevator Closing...");
    }

public static int elevatorCheck(int charlvl, int elev1, int elev2) //to check which elevator is nearest to you
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
    
public static int elevatorStatus(int x, int charlvl, int elev1, int elev2) //TO DETERMINE IF ELEV WILL GO UP OR DOWN
    {
        int value = 0;//will hold the return value
        if (x == 1 || x==3) //elevator 2 is nearer
        {
            int location = charlvl - elev2; //to check if elevator is above or below you
            if (location > 0)
            {
                value = 1;//Right or elevator 2 going up
            }
            else if (location<0)
            {
                value = 2;//Right or elevator 2 going down
            }
        }
        else if (x == 2) //elevator 1 is nearer
        {
            int location = charlvl - elev1; //to check if elevator is above or below you
            if (location > 0)
            {
                value = 3; //left or elevator 1 is going up
            }
            else if (location<0)
            {
                value = 4; //left or elevator 1 is going down
            }
        }
        return value;
    }
    public static int elevatorStatus(int charlvl, int elev1, int elev2, char both) //TO DETERMINE IF ELEV WILL GO UP OR DOWN
    {
        int value = 0;//will hold the return value
        int x = elev1-charlvl;
        int y = elev2-charlvl;
        if(x>0) //LEFT GOING DOWN
        {
            if (y>0)
            {
                value =1; //BOTH GOING DOWN
            }
            else if (y<0)
            {
                value = 2; //LEFT GOING DOWN, RIGHT GOING UP
            }
            else if (y==0) 
            {
                value =3; //LEFT GOING DOWN, RIGHT CONSTANT
            }
        }
        else if (x<0)//LEFT GOING UP
        {
            if (y>0)
            {
                value =4; //LEFT GOING UP, RIGHT GOING DOWN
            }
            else if (y<0)
            {
                value = 5; //BOTH UP
            }
            else if (y==0) 
            {
                value =6; //LEFT GOING UP, RIGHT CONSTANT
            }
        }
        else if (x==0) //LEFT CONSTANT
        {
            if (y>0)
            {
                value =7; //LEFT CONSTANT, RIGHT GOING DOWN
            }
            else if (y<0)
            {
                value = 5; //LEFT CONSTANT, RIGHT GOING UP
            }
            else if (y==0) 
            {
                value =3; //BOTH CONSTANT
            }
        }
        return value;
    }
}