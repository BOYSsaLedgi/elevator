public class trystring {
    public static void main(String[] args) {
        topdesign(6, 7);
        ElevOpening();
        DeleteLine(5);
        ElevClosing();
        topdesign(6, 7);
        ElevIdle();
        
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
