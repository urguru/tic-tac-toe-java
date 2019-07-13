import java.util.Scanner;

class tictac {
    //These are the positions where if the player plays then he wins.
    static int wins[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 4, 8 }, { 2, 4, 6 }, { 0, 3, 6 }, { 1, 4, 7 },{ 2, 5, 8 } };
    //This function is for printing the 3*3 tictactoe board
    public static void printBoard(String arr[]) {
        System.out.println("-------------");
        System.out.print("| ");
        System.out.print(arr[0]);
        System.out.print(" | ");
        System.out.print(arr[1]);
        System.out.print(" | ");
        System.out.print(arr[2]);
        System.out.println(" |");
        System.out.println("-------------");
        System.out.print("| ");
        System.out.print(arr[3]);
        System.out.print(" | ");
        System.out.print(arr[4]);
        System.out.print(" | ");
        System.out.print(arr[5]);
        System.out.println(" |");
        System.out.println("-------------");
        System.out.print("| ");
        System.out.print(arr[6]);
        System.out.print(" | ");
        System.out.print(arr[7]);
        System.out.print(" | ");
        System.out.print(arr[8]);
        System.out.println(" |");
        System.out.println("-------------");
    }
    //This returns true if a winning combination has been found from a player's plays
    public static boolean foundWinner(int player[])
    {
        int count=0;
        //This loop runs through the 8 possible winning combiations
        for(int i=0;i<8;++i)
        {
            for(int j=0;j<5;++j)
            {
                //Checks if the winner has played the winning combination
                for(int k=0;k<3;++k)
                {
                    if(wins[i][k]==player[j])
                    count++;
                }
            }
            //If the winner has all the three winning combinations then return true
            if (count == 3)
                return true;
            //Else reset the count to zero and start again
            count=0;
        }
        //If no winning combinations has been found then return false
        return false;
    }

    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        //The initial positions in the printed TICTACTOE board
        String arr[] = { "-", "-", "-", "-", "-", "-", "-", "-", "-" };
        //initialising all the moves to -1.So if a player has not yet played any game then all values will be -1
        //If he plays then the index of the move is stored
        int player1[]={-1,-1,-1,-1,-1};
        int player2[]={-1,-1,-1,-1,-1};
        boolean tie=true;
        //These variables hold the values of how many times each player has played
        int turnCountPlayer1=0,turnCountPlayer2=0;
        System.out.println("Welcome to play TicTacToe game! We have the following 3*3 empty board");
        printBoard(arr);
        //As long as the first player hasnt played 5 moves,both players can play.
        //Once the first player plays 5 times then the game ends
        //Note that the maximum chances that a second player can get is 4 only
        while(turnCountPlayer1<5)
        {
            int col,row;
            //This is to check if player 2 has played a winning combination
            //This is useful after the first execution of the whole loop
            //Because at the end of this while loop the player 2 plays his turn
            if(foundWinner(player2))
            {
                System.out.println("We have a winner Congrats");
                tie=false;
                break;
            }
            System.out.print("Enter the row index :");
            row=in.nextInt();
            System.out.print("Enter the column index :");
            col=in.nextInt();
            //The array index is stored in player moves
            player1[turnCountPlayer1++]=row*3+col;
            //The value to be printed is also changed
            arr[row*3+col]="x";
            //The board is then printed
            printBoard(arr);
            //After player 1 has played.It is checked if he won the game
            if(foundWinner(player1))
            {
                System.out.println("We have a winner Congrats");
                tie=false;
                break;
            }
            //Player 2 plays his turn only if player 1 has played less than 5 turns
            //If player 1 has played 5 turns then the game ends
            else if(turnCountPlayer1<5)
            {
                System.out.print("Enter the row index :");
                row=in.nextInt();
                System.out.print("Enter the column index :");
                col=in.nextInt();
                player2[turnCountPlayer2++]=row*3+col;
                arr[row*3+col]="0";
                printBoard(arr);
            }
        }
        //If the player 1 has played 5 turns and nobody has won yet then the game is a draw
        if(tie==true)
        {
            System.out.println("Its a draw Nobody Wins");
        }
    }
}