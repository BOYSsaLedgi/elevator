public class WithDesignPerio {
    public static void main(String[] args) {
        //RANDOMIZER//
        int min = 1; // Minimum value of range
        int max = 7; // Maximum value of range
        int elevator1 = (int)Math.floor(Math.random() * (max - min + 1) + min);//variable for  elevator1 location
        int elevator2 = (int)Math.floor(Math.random() * (max - min + 1) + min);//variable for elevator 2 location
        //int elevator1 = 7;
        //int elevator2 = 5;
        
        //PRINT THIS BEFORE ASKING FOR INPUT
        topdesign(elevator1, elevator2);
        ElevIdle();

        //INPUT HERE
        int character = 1; //variable for character location
        
        int ElevatorLocation; //to get which elevator is nearest to you
        ElevatorLocation = ElevatorCheck(character, elevator1, elevator2);
        
        //variables to use to indicate the status of elevator or which is nearer
        char top = '_';
        char mid = ' ';
        char bot = '_';
        int UpOrDown = ElevatorStatus(ElevatorLocation, character,elevator1,elevator2);

        if (UpOrDown == 1 || UpOrDown == 3)
        {
            top = '^';
            mid = '|';
            bot = '|';
        }
        else if (UpOrDown == 2 || UpOrDown == 4)
        {
            top = '|';
            mid = '|';
            bot = 'V';
        }

        //MADE SOME CHANGES
        //instead of assigning the elevtor value to another variable, it will directly call the methods
        if (ElevatorLocation == 1 || ElevatorLocation == 3)
        {
            if (elevator2<character)
            {
                for (int y = elevator2; y <=character;y++)
                {
                    elevator2 = y;
                    DeleteLine(8);
                    topdesign(elevator1, elevator2);
                    ElevIdle(top,mid,bot);
                    Delay(2000);
                }
            }
            else if (elevator2>character)
            {
                for (int y = elevator2; y >=character;y--)
                {
                    elevator2 = y;
                    DeleteLine(8);
                    topdesign(elevator1, elevator2);
                    ElevIdle(top,mid,bot);
                    Delay(2000);
                }
            } 
            //opening door , tell what the floor the elevator is in now.
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
            Delay(1000);
            DeleteLine(9);

            topdesign(elevator1, elevator2);
            RightElevOpening();
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
            Delay(3000);
            DeleteLine(9);

            topdesign(elevator1, elevator2);
            RightElevClosing();
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
        }
        else if (ElevatorLocation == 2)
        {
            if (elevator1<character)
            {
                for (int y = elevator1; y <=character;y++)
                {
                    elevator1 = y;
                    DeleteLine(8);
                    topdesign(elevator1, elevator2);
                    ElevIdle(top,mid,bot);
                    Delay(2000);
                }
            }
            else if (elevator1>character)
            {
                for (int y = elevator1; y >=character;y--)
                {
                    elevator1 = y;
                    DeleteLine(8);
                    topdesign(elevator1, elevator2);
                    ElevIdle(top,mid,bot);
                    Delay(2000);
                }
            } 
            //opening door , tell what the floor the elevator is in now.
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
            Delay(1000);
            DeleteLine(9);

            topdesign(elevator1, elevator2);
            LeftElevOpening();
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
            Delay(2000);
            DeleteLine(9);

            topdesign(elevator1, elevator2);
            LeftElevClosing();
            System.out.print("Elevator 1: " + elevator1);
            System.out.println(" || Elevator 2: " + elevator2);
        }
        
        DeleteLine(2);
        System.out.print("Elevator 1: " + elevator1);
        System.out.println(" || Elevator 2: " + elevator2);
    }

    //NEW
    public static void topdesign(int x, int y)
    {
        System.out.println("_______________________________________");
        System.out.println("|      "+x+"                     "+y+"        |");
        System.out.println("|_____________________________________|");    
    }
    public static void ElevIdle(char x, char y, char z)
    { 
        //x = top, y = mid, z= bot
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  |     |      |   "+x+"  |     |      | |");
        System.out.println("|  |     |      |   "+y+"  |     |      | |");
        System.out.println("|  |     |      |   "+z+"  |     |      | |");
        System.out.println("|__|_____|______|______|_____|______|_|");
    }
    public static void ElevIdle()
    { 
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  |     |      |   "+"   |     |      | |");
        System.out.println("|  |     |      |   "+"   |     |      | |");
        System.out.println("|  |     |      |   "+"   |     |      | |");
        System.out.println("|__|_____|______|______|_____|______|_|");
    }

    public static void RightElevHalfOpen()
    {
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  |     |      |   "+"   |    | |     | |");
        System.out.println("|  |     |      |   "+"   |    | |     | |");
        System.out.println("|  |     |      |   "+"   |    | |     | |");
        System.out.println("|__|_____|______|______|____|_|_____|_|");
    }

    public static void RightElevFullOpen()
    {
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  |     |      |   "+"   | |        | | |");
        System.out.println("|  |     |      |   "+"   | |        | | |");
        System.out.println("|  |     |      |   "+"   | |        | | |");
        System.out.println("|__|_____|______|______|_|________|_|_|");
    }

    public static void RightElevOpening()
    {
        ElevIdle();
        System.out.println("Right Elevator Opening");
        Delay(1000);
        DeleteLine(6);

        RightElevHalfOpen();
        System.out.println("Right Elevator Opening");
        Delay(1000);
        DeleteLine(6);

        RightElevFullOpen();
        System.out.println("Right Elevator Opening");
        
    }
    public static void RightElevClosing()
    {
        RightElevFullOpen();
        System.out.println("Right Elevator Closing");
        Delay(1000);
        DeleteLine(6);

        RightElevHalfOpen();
        System.out.println("Right Elevator Closing");
        Delay(1000);
        DeleteLine(6);

        ElevIdle();
        System.out.println("Right Elevator Closing");
    }

    public static void LeftElevHalfOpen()
    {
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  |    | |     |   "+"   |     |      | |");
        System.out.println("|  |    | |     |   "+"   |     |      | |");
        System.out.println("|  |    | |     |   "+"   |     |      | |");
        System.out.println("|__|____|_|_____|______|_____|______|_|");
    }

    public static void LeftElevFullOpen()
    {
        System.out.println("|  ______________   "+"   ______________ |");
        System.out.println("|  | |        | |   "+"   |     |      | |");
        System.out.println("|  | |        | |   "+"   |     |      | |");
        System.out.println("|  | |        | |   "+"   |     |      | |");
        System.out.println("|__|_|________|_|______|_____|______|_|");
    }

    public static void LeftElevOpening()
    {
        ElevIdle();
        System.out.println("Left Elevator Opening");
        Delay(1000);
        DeleteLine(6);

        LeftElevHalfOpen();
        System.out.println("Left Elevator Opening");
        Delay(1000);
        DeleteLine(6);

        LeftElevFullOpen();
        System.out.println("Left Elevator Opening");
    }
    public static void LeftElevClosing()
    {
        LeftElevFullOpen(); 
        System.out.println("Left Elevator Closing");
        Delay(1000);
        DeleteLine(6);

        LeftElevHalfOpen();
        System.out.println("Left Elevator Closing");
        Delay(1000);
        DeleteLine(6);

        ElevIdle();
        System.out.println("Left Elevator Closing");
    }
    //UP TO HERE NEW

    public static void DeleteLine(int x) 
    {
        //int x is for the number of lines to delete
        for (int y = 1 ; y<=x; y++)
        {
            System.out.print(String.format("\033[%dA",1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }    
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
    public static int ElevatorStatus(int x, int charlvl, int elev1, int elev2) //TO DETERMINE IF ELEV WILL GO UP OR DOWN
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
}
