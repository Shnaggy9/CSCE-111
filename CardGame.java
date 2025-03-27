import java.util.Scanner;

public class CardGame {
    public static void main(String[] Args) {
        
    /*  
    Team Number: Team 6
    Team Members: Parker Hitchcock, Chiggy Ogara, Domenic Hucik, Mia Aquilina
    Team Name: Shifts and Giggles
    Class and Section: CSCE 111- 505
    March 27, 2025
    */ 
       
    //Game title and description
        System.out.println("Welcome to BlackJack!");
        Scanner sncr = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String playerName = sncr.nextLine();
        System.out.println("");
        System.out.println("Hello " + playerName + ", The objective of the game is to get as close to 21 as possible without going over. \n" +
                           "You will be dealt two cards, and the dealer will have one card face up and one card face down.\n" +
                           "Good luck!");
        System.out.println("");
        
    // game loop for replay
        boolean replay = false;
        do {

    // Creating the array for the suits and numbers
        String[] suits = {"H", "D", "C", "S"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        String[] deck = new String[52];

        // Creating the deck with nested loops
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                deck[index++] = numbers[j] + suits[i];
            }
        }

        //Shuffling the deck
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length);
            String rand = deck[randomIndex];
            deck[randomIndex] = deck[i];
            deck[i] = rand;
            }

        //dealing the shuffled deck to 2 players 
        String[] playerHand = new String[10]; // assuming max 10 cards for player
        String[] dealerHand = new String[10];
        int playerCardCount = 2;
        int dealerCardCount = 2;
        playerHand[0] = deck[0]; // first card for player
        playerHand[1] = deck[2]; // second card for player
        dealerHand[0] = deck[1]; // first card for dealer
        dealerHand[1] = deck[3]; // second card for dealer
        
        //printing the hands
        System.out.println("Dealer's Hand: " + dealerHand[0] + " [Hidden]");
        System.out.println();
        System.out.println(playerName + "'s Hand: " + playerHand[0] + " " + playerHand[1]);

        //checking for "Lucky 7's" (parkers rule)
        if (playerHand[0].charAt(0) == '7' && playerHand[1].charAt(0) == '7') {
            System.out.println("Congratulations " + playerName + "! You have Lucky 7's! You win!");
            continue;// end the game if player has lucky 7's
        }

        // Players Turn
        boolean playerBust = false;
        int deckIdex = 4; // start from the 5th card in the deck

        while (true) {
            int playerTotal = 0;
            int aceCount = 0;

            for (int i = 0; i < playerCardCount; i++) {
                char cardValue = playerHand[i].charAt(0);
                if (cardValue == 'A') {
                    aceCount++;
                    playerTotal += 11; // count Ace as 11 initially
                } else if (cardValue == 'K' || cardValue == 'Q' || cardValue == 'J' || cardValue == 'T') {
                    playerTotal += 10; // face cards are worth 10
                } else {
                    playerTotal += cardValue - '0'; // numeric cards are worth their value
                }
            }

            while (playerTotal > 21 && aceCount > 0) {
                playerTotal -= 10; // count Ace as 1 instead of 11
                aceCount--;
            }

            System.out.println("Your total is: " + playerTotal);

            if (playerTotal > 21) {
                System.out.println("");
                System.out.println("Bust! You lose.");
                playerBust = true;
                break; // end the player's turn if bust
            }

            System.out.println();
            System.out.print("Do you want to hit or stand? (h/s): ");
            String action = sncr.nextLine().toLowerCase();
            if (action.equals("h")) {
                playerHand[playerCardCount++] = deck[deckIdex++]; // deal next card
                System.out.print( playerName + "'s Hand: ");
                for (int i = 0; i < playerCardCount; i++) {
                    System.out.print(playerHand[i] + " ");
                }
                System.out.println();
            } else if (action.equals("s")) {
                break; // end the player's turn if stand
            } else {
                System.out.println("Invalid input. Please enter 'h' to hit or 's' to stand.");
            }
        }
        
        // Dealer's Turn
        if (!playerBust) {
            System.out.println("Dealer's Hand: " + dealerHand[0] + " " + dealerHand[1]);

            while (true) {
                int dealerTotal = 0;
                int dealerAceCount = 0;

                for (int i = 0; i < dealerCardCount; i++) {
                    char cardValue = dealerHand[i].charAt(0);
                    if (cardValue == 'A') {
                        dealerAceCount++;
                        dealerTotal += 11; // count Ace as 11 initially
                    } else if (cardValue == 'K' || cardValue == 'Q' || cardValue == 'J' || cardValue == 'T') {
                        dealerTotal += 10; // face cards are worth 10
                    } else {
                        dealerTotal += cardValue - '0'; // numeric cards are worth their value
                    }
                }

                while (dealerTotal > 21 && dealerAceCount > 0) {
                    dealerTotal -= 10; // count Ace as 1 instead of 11
                    dealerAceCount--;
                }

                if (dealerTotal >= 17) {
                    break; // end the dealer's turn if total is 17 or more
                }

                dealerHand[dealerCardCount++] = deck[deckIdex++]; // deal next card
                System.out.print("Dealer's Hand: ");
                for (int i = 0; i < dealerCardCount; i++) {
                    System.out.print(dealerHand[i] + " ");
                }
                System.out.println();

                //determine winner
                int playerTotal = 0; dealerTotal = 0;
                int aceCount = 0; dealerAceCount = 0;

                for (int i= 0; i <playerCardCount; i++) {
                    char cardValue = playerHand[i].charAt(0);
                    if (cardValue == 'A') {
                        aceCount++;
                        playerTotal += 11;
                    } else if (cardValue == 'K' || cardValue == 'Q' || cardValue == 'J' || cardValue == 'T') {
                        playerTotal += 10; 
                    } else {
                        playerTotal += cardValue - '0'; 
                    }
                }

                while (playerTotal > 21 && aceCount > 0) {
                    playerTotal -= 10; 
                    aceCount--;
                }

                for (int i = 0; i < dealerCardCount; i++) {
                    char cardValue = dealerHand[i].charAt(0);
                    if (cardValue == 'A') {
                        dealerAceCount++;
                        dealerTotal += 11; 
                    } else if (cardValue == 'K' || cardValue == 'Q' || cardValue == 'J' || cardValue == 'T') {
                        dealerTotal += 10; 
                    } else {
                        dealerTotal += cardValue - '0'; 
                    }
                }
                
                while (dealerTotal > 21 && dealerAceCount > 0) {
                    dealerTotal -= 10; 
                    dealerAceCount--;
                }

                //printing results
                System.out.println("\nFinal Results:");
                System.out.println(playerName + "'s total: " + playerTotal);
                System.out.println("Dealer's total: " + dealerTotal);
                System.out.println();

                if (dealerTotal > 21 || playerTotal > dealerTotal) {
                    System.out.println(playerName + " wins!");
                    } else if (playerTotal > 21 || dealerTotal > playerTotal) {
                        System.out.println("Dealer wins :( ");
                        } else {
                            System.out.println("It's a tie!");
                }
            }
        }

        // Ask if the player wants to play again
        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = sncr.nextLine().toLowerCase();
        if (playAgain.equals("y")) {
            replay = true; // set replay to true to play again
        } else {
            replay = false; // set replay to false to end the game
            System.out.println("Thank you for playing, " + playerName + "!"); // end message
        }
    } while (replay); // close the do-while loop
    System.out.println();
}
}

