public class trystring {
    public static void main(String[] args) {
        int ElevatorCheck = 3;
        if (ElevatorCheck==1 || ElevatorCheck==3)
        {
            topdesign(3, 4);
            RightElevOpening();
            Delay(3000);
            DeleteLine(5);
            RightElevClosing();
        }
        else if (ElevatorCheck==2)
        {
            topdesign(ElevatorCheck, ElevatorCheck);
            LeftElevOpening();
            Delay(3000);
            DeleteLine(5);
            LeftElevClosing();
        }
        /* 
        topdesign(6, 7);
        LeftElevFullOpen();
        Delay(2000);
        DeleteLine(5);
        ElevClosing();
        topdesign(6, 7);
        ElevIdle();*/
        System.out.print("COME IN YO!");
    }
    public static void topdesign(int x, int y)
    {
        System.out.println("_______________________________________");
        System.out.println("|      "+x+"                     "+y+"        |");
        System.out.println("|_____________________________________|");    
    }
    public static void ElevIdle()
    {
        System.out.println("|  ______________   "+5+"  ______________ |");
        System.out.println("|  |     |      |   "+5+"  |     |      | |");
        System.out.println("|  |     |      |   "+5+"  |     |      | |");
        System.out.println("|  |     |      |   "+5+"  |     |      | |");
        System.out.println("|__|_____|______|______|_____|______|_|");
    }

    public static void RightElevHalfOpen()
    {
        System.out.println("|  ______________   "+5+"  ______________ |");
        System.out.println("|  |     |      |   "+5+"  |    | |     | |");
        System.out.println("|  |     |      |   "+5+"  |    | |     | |");
        System.out.println("|  |     |      |   "+5+"  |    | |     | |");
        System.out.println("|__|_____|______|______|____|_|_____|_|");
    }

    public static void RightElevFullOpen()
    {
        System.out.println("|  ______________   "+5+"  ______________ |");
        System.out.println("|  |     |      |   "+5+"  | |        | | |");
        System.out.println("|  |     |      |   "+5+"  | |        | | |");
        System.out.println("|  |     |      |   "+5+"  | |        | | |");
        System.out.println("|__|_____|______|______|_|________|_|_|");
    }

    public static void RightElevOpening()
    {
        ElevIdle();
        Delay(1000);
        DeleteLine(5);

        RightElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        RightElevFullOpen();
    }
    public static void RightElevClosing()
    {
        RightElevFullOpen();
        Delay(1000);
        DeleteLine(5);

        RightElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        ElevIdle();
    }

    public static void LeftElevHalfOpen()
    {
        System.out.println("|  ______________   "+5+"  ______________ |");
        System.out.println("|  |    | |     |   "+5+"  |     |      | |");
        System.out.println("|  |    | |     |   "+5+"  |     |      | |");
        System.out.println("|  |    | |     |   "+5+"  |     |      | |");
        System.out.println("|__|____|_|_____|______|_____|______|_|");
    }

    public static void LeftElevFullOpen()
    {
        System.out.println("|  ______________   "+5+"  ______________ |");
        System.out.println("|  | |        | |   "+5+"  |     |      | |");
        System.out.println("|  | |        | |   "+5+"  |     |      | |");
        System.out.println("|  | |        | |   "+5+"  |     |      | |");
        System.out.println("|__|_|________|_|______|_____|______|_|");
    }

    public static void LeftElevOpening()
    {
        ElevIdle();
        Delay(1000);
        DeleteLine(5);

        LeftElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        LeftElevFullOpen();
    }
    public static void LeftElevClosing()
    {
        LeftElevFullOpen(); 
        Delay(1000);
        DeleteLine(5);

        LeftElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        ElevIdle();
    }

    public static void ElevOpening() {

        DesignElevClosed();
        Delay(1000);
        DeleteLine(5);

        DesignElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        DesignElevFullOpen();
    }
    public static void ElevClosing() {
        
        DesignElevFullOpen();
        Delay(1000);
        DeleteLine(5);

        DesignElevHalfOpen();
        Delay(1000);
        DeleteLine(5);

        DesignElevClosed();
    }

    public static void DesignElevClosed() {
        System.out.println("______________");
        System.out.println("|     |      |");
        System.out.println("|     |      |");
        System.out.println("|     |      |");
        System.out.println("|_____|______|");
    }
    public static void DesignElevHalfOpen() {
        System.out.println("______________");
        System.out.println("|    | |     |");
        System.out.println("|    | |     |");
        System.out.println("|    | |     |");
        System.out.println("|____|_|_____|");
    }
    public static void DesignElevFullOpen() {
        System.out.println("______________");
        System.out.println("| |        | |");
        System.out.println("| |        | |");
        System.out.println("| |        | |");
        System.out.println("|_|________|_|");
    }

    public static void DeleteLine(int x) 
    {
        //int x is for the number of lines to delete
        for (int y = 1 ; y<=x; y++)
        {
            System.out.print(String.format("\033[%dA",1)); // Move up
            System.out.print("\033[2K"); // Erase line content
        }    
    }
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
}
