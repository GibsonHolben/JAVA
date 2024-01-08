import java.util.ArrayList;
import java.util.Scanner;

public class MainLoop 
{
	/**console colors*/
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	/**Variables*/
	public static Deck MainDeck = new Deck();
	public static Deck Player1Deck = new Deck();
	public static Deck Player2Deck = new Deck();
	public static boolean isWon;
	
	/**The main loop that controls the game and gets input*/
	public static void main(String[] args )
	{
		
		InitGame();
		System.out.println(Player1Deck.Cards.size());
		System.out.println(Player2Deck.Cards.size());
		Scanner sc = new Scanner(System.in);
		while(isWon == false) 
		{
			System.out.println(CYAN + "Are you ready? (y)" + RESET);
			String input = sc.nextLine();
			
			if(input.equals("y"))
			{
				flip();
			}
			if(input.equals("shuffle"))
			{
				Player1Deck.Shuffle();
				Player2Deck.Shuffle();
			}
			if(input.equals("help"))
			{
				System.out.print("The commands are: \n"
						+ "y (Continues the game) \n"
						+ "shuffle (shuffles the decks) \n"
						+ "help (shows this menu) \n"
						+ "view (Shows the players decks) \n"
						+ "ff (Ends the game)\n");
			}
			if(input.equals("view"))
			{
				System.out.println(RED+"***********************************"+RESET);
				System.out.println(RED+"Player1"+RESET);
				Player1Deck.printCards();
				System.out.println(RED+"***********************************"+RESET);
				System.out.println(RED+"Player2"+RESET);
				Player2Deck.printCards();
			}
			if(input.equals("ff"))
			{
				Player1Deck.printCards();
				System.out.println("_____________________________");
				Player2Deck.printCards();
				System.out.println(CYAN + "Game ended by command" + RESET);
				isWon = true;
			}
		}
		
	}
	
	/**Flips the top cards of the decks and gives output based on the outcome of the fight*/
	public static void flip()
	{
		int player1 = Player1Deck.Cards.get(0).number;
		int player2 = Player2Deck.Cards.get(0).number;
		
		if(player1 == player2)
		{
			System.out.println(GREEN + "Player 1 used a " + Player1Deck.Cards.get(0) + RESET);
			System.out.println(BLUE + "Player 2 used a " + Player2Deck.Cards.get(0) + RESET);
			war(player1, player2);
		}
		else 
		{
			if(player1 > player2)
			{
				
				System.out.println(GREEN + "Player one won this round"+ RESET);
				System.out.print(GREEN + "They used a " +  Player1Deck.Cards.get(0).toString() + " and got player 2's: " + Player2Deck.Cards.get(0).toString()+ "\n"+ RESET);
				Player1Deck.Cards.add(Player2Deck.Cards.get(0));
				Player2Deck.Cards.remove(0);
				Player1Deck.Cards.add(Player1Deck.Cards.get(0));
				Player1Deck.Cards.remove(0);
				
			}
			else 
			{
			
				System.out.println(BLUE + "Player two won this round"+ RESET);
				System.out.print(BLUE + "They used a " +  Player2Deck.Cards.get(0).toString() + " and got player 1's: " + Player1Deck.Cards.get(0).toString() + "\n"+ RESET);
				Player2Deck.Cards.add(Player1Deck.Cards.get(0));
				Player1Deck.Cards.remove(0);
				
				Player2Deck.Cards.add(Player2Deck.Cards.get(0));
				Player2Deck.Cards.remove(0);
				
			}
		}
		
		
		if(Player1Deck.Cards.size() < 1 )
		{
			isWon = true;
			System.out.println(RED + "Player 2 wins!" + RESET);
		}
		else if(Player2Deck.Cards.size() < 1)
		{
			isWon = true;
			System.out.println(RED + "Player 1 wins!" + RESET);
		}

	}
	
	/**Occors when the 2 cards in a flip are the same*/
	public static void war(int o, int t)
	{
		System.out.println(RED + "WAR" + RESET);
		int player1 = o;
		int player2 = t;
		
		int player1new = Player1Deck.Cards.get(1).number;
		int player2new = Player2Deck.Cards.get(1).number;
		
		if(player1new > player2new)
		{
			System.out.println("Player one won the war!");
			System.out.print("They used a " +  Player1Deck.Cards.get(1).toString() + " and got player 2's: " + Player2Deck.Cards.get(0).toString() + " and " + Player2Deck.Cards.get(1).toString()+ "\n");
			Player1Deck.Cards.add(Player2Deck.Cards.get(0));
			Player1Deck.Cards.add(Player2Deck.Cards.get(1));
			Player2Deck.Cards.remove(0);
			Player2Deck.Cards.remove(1);
			
			Player1Deck.Cards.add(Player1Deck.Cards.get(0));
			Player1Deck.Cards.remove(0);
			
			Player1Deck.Cards.add(Player1Deck.Cards.get(0));
			Player1Deck.Cards.remove(0);
		}
		else
		{
			System.out.println("Player two won the war!");
			System.out.print("They used a " +  Player2Deck.Cards.get(1).toString() + " and got player 2's: " + Player1Deck.Cards.get(0).toString() + " and " + Player1Deck.Cards.get(1).toString()+ "\n");
			Player2Deck.Cards.add(Player1Deck.Cards.get(0));
			Player2Deck.Cards.add(Player1Deck.Cards.get(1));
			Player1Deck.Cards.remove(0);
			Player1Deck.Cards.remove(1);
			
			Player2Deck.Cards.add(Player2Deck.Cards.get(0));
			Player2Deck.Cards.remove(0);
			
			Player2Deck.Cards.add(Player2Deck.Cards.get(0));
			Player2Deck.Cards.remove(0);
		}
	}
	
	/**Starts the game by creating the cards, shuffling them, and spliting the deck*/
	public static void InitGame()
	{
		MainDeck.Cards = CreateCards();
		MainDeck.Shuffle();
		System.out.println(MainDeck.Cards.size());
		split(MainDeck);
	}
	
	/**Splits the deck*/
	public static void split(Deck d)
	{
		while(MainDeck.Cards.size() > 0)
		{
			Player1Deck.Cards.add(MainDeck.Cards.get(0));
			MainDeck.Cards.remove(0);
			Player2Deck.Cards.add(MainDeck.Cards.get(0));
			MainDeck.Cards.remove(0);
		}
	}
	
	/**Creates all the cards needed*/
	public static ArrayList<Card> CreateCards()
	{
		ArrayList<Card> Cards = new ArrayList<Card>();
		String[] colors = {"Spades", "Hearts", "Clubs", "Diamonds"};
		
		for(int i = 0; i < colors.length; i++)
		{
			for(int j = 1; j < 14; j++)
			{
				Cards.add(new Card(j, colors[i]));
			}
		}
		
		return Cards;
	}

}
