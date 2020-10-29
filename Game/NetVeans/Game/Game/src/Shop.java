import java.util.*;

public class Shop 
{
	
	Scanner keyboard = new Scanner(System.in);

	public Shop()
	{
		
	}
	
	public void openShop()
	{
			System.out.println("Shop Menu    Your gold: " + Game.mainChar.getGold());
			System.out.println("---------");
			System.out.println("1. Buy\n" + "2. Sell\n" + "3. Back\n");
		
			int m = keyboard.nextInt();
	
			if (m==1)
			{
				shopBuy();
			}
			else if(m==2)
			{
				shopSell();
			}
			else if(m==3)
			{
				MainMenu.menuStep = 3;
				Game.menu.NewGameMenu();
			}
	}
	
	public void shopBuy()
	{
		System.out.println("What would you like to buy?    Your gold: " + Game.mainChar.getGold());
		System.out.println("1. Potion["+Game.potion.worth+"]");
		System.out.println("2. Back\n");
	
		int b = keyboard.nextInt();
		
		if (b == 1)
		{
			System.out.print("How many? ");
			Game.potion.Buy(keyboard.nextInt());
		}
	
		else if (b == 2)
		{
			openShop();
		}
	}
	
	public void shopSell()
	{
		System.out.println("What would you like to sell?    Your gold: " + Game.mainChar.getGold());
		System.out.println("1. Potion");
		System.out.println("2. Back\n");
		int s = keyboard.nextInt();
		
		if(s==1)
		{
			System.out.println("How many?");
			Game.potion.Sell(keyboard.nextInt());
		}
		else if (s==2)
		{
			openShop();
		}
	}
}

