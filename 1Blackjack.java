
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        P1Random rng = new P1Random();
        // must declare all int
        boolean restart = true;
        int gamesPlayed = 0;
        int playerWin = 0;
        int dealerWin = 0;
        int tie = 0;
        int gameNum = 1;
        int playerHand=0;
        int dealerHand=0;


        while (true) {
            // While loop keeps going
            // if restart = true in any statement it will loop back here
            // and will "restart the game"
            if (restart) {
                playerHand = 0; //reset values to 0
                dealerHand = 0;
                int player1 = rng.nextInt(13) + 1;  //pull card
                playerHand += player1;
                System.out.println("START GAME #" + gameNum + "\n");
                System.out.println("Your card is a " + player1 + "!");
                System.out.println("Your hand is: " + playerHand + "\n");
                restart = false;    //must put false or else will loop
            }
            System.out.println( "1. Get another card\n" +
                                "2. Hold hand\n" +
                                "3. Print statistics\n" +
                                "4. Exit\n");
            System.out.print("Choose an option: ");
            int input = scan.nextInt();

            //switch loop, depending on input it will go to case #
            switch (input) {


                case 1: //get another card option

                    int player = rng.nextInt(13) + 1;

                    if (player == 1) {
                        System.out.println("Your card is an ACE!");
                        playerHand += player;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    if (player >= 2 && player <= 10) {
                        System.out.println("Your card is a " + player + "!");
                        playerHand += player;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    if (player == 11) { //11 identifies jack though value is 10
                        System.out.println("Your card is a Jack!");
                        player -= 1;
                        playerHand += player;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    if (player == 12) {//12 identifies queen though value is 10
                        System.out.println("Your card is a Queen!");
                        player -= 2;
                        playerHand += player;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    if (player == 13) {//13 identifies king though value is 10
                        System.out.println("Your card is a King!");
                        player -= 3;
                        playerHand += player;
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    if (playerHand == 21) {
                        System.out.println("BLACKJACK! You win!\n");
                        playerWin++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                    }
                    if (playerHand > 21) {
                        System.out.print("Dealer Wins!" + "\n");
                        dealerWin++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                        break;
                    }
                    if (playerHand == dealerHand) {
                        System.out.println("It is a tie!" + "\n");
                        tie++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                        break;
                    }
                    break;  //must break if not will go to next case

                case 2: // hold hand option
                    int dealer = rng.nextInt(11) + 16;
                    dealerHand += dealer;
                    System.out.println("Dealers hand: " + dealerHand + "\n");

                    if (dealerHand > 21) {
                        System.out.println("Player Wins!" + "\n");
                        playerWin++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                        break;
                    }
                    if (dealerHand == 21) {
                        System.out.print("Dealer Wins!" + "\n");
                        dealerWin++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                        break;
                    }
                    if (playerHand == dealerHand) {
                        System.out.println("It is a tie!" + "\n");
                        tie++;
                        gamesPlayed++;
                        gameNum++;
                        restart = true;
                        break;
                    }
                    break;

                case 3: //Print statistics option
                    // must multiply first idk why*****
                    double percent = 100 * playerWin / gamesPlayed;
                    System.out.println("\nNumber of Player wins: " + playerWin);
                    System.out.println("Number of Dealer wins: " + dealerWin);
                    System.out.println("Number of tie games: " + tie);
                    System.out.println("Total # of games played is: " + gamesPlayed);
                    System.out.println("Percentage of player wins:  " + percent + "%\n");
                    break;

                case 4: // exit option
                    System.out.print("Later Gator!\n");
                    break;

                default: // if user inputs something else than 1 - 4
                    System.out.print("Invalid input! " +
                            "\nPlease enter an integer value between 1 and 4.\n");
                    break;
            }
        }
    }
}