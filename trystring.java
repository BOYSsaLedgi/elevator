public class trystring {
    public static void main(String[] args) {
        DesignElevClosed();
        Delay(2000);
        DeleteLine(5);
        DesignElevHalfOpen();
        Delay(2000);
        DeleteLine(5);
        DesignElevFullOpen();
        
        System.out.print("COME IN YO!");
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
