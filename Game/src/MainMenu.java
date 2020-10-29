import java.util.*;
public class MainMenu
{
	static Scanner keyboard = new Scanner(System.in);

	private int nls;
	private int bs;
	protected String nameInput;
	protected static int menuStep;

	boolean foo = true;

	public MainMenu()
	{
		menuStep = 0;
	}

	public void NewGameMenu()
	{
		while (menuStep == 0) //If on step 0, loop first menu.
		{
			System.out.println("  Menu");
			System.out.println("--------");
			System.out.println("1. New Game\n" + "2. Load Game\n" + "3. Save Game\n" + "4. Quit\n");

			nls = keyboard.nextInt();

			switch(nls)
			{
				case 1:
					Game.potion.setInventory(3);
					menuStep = 1; //Go to the next step.
				break;

				case 2:
					Game.Load();
				break;

				case 3:
					Game.Save();
				break;

				case 4:
					System.exit(0);
				break;

				default:
					System.out.println("Invalid command!");
			}
		}
		
		while (menuStep == 1) //If on step 1
		{
			System.out.print("\nWhat is your name?  ");
			keyboard.nextLine();
			nameInput = keyboard.nextLine();
			Game.mainChar.setName(nameInput);
			System.out.println("\nHello, " + nameInput + "!");
			menuStep = 2; //Go to next step
		}

		while (menuStep == 2)
		{
			System.out.println("\nChoose your class:\n" + "1. Swordsman\n" + "2. Sentry\n" + "3. Wizard\n");
			int chooseClass = keyboard.nextInt();

			if(chooseClass == 1)
				Game.mainChar.Swordsman();
			else if (chooseClass == 2)
				Game.mainChar.Sentry();
			else if (chooseClass == 3)
				Game.mainChar.Wizard();
			else
				System.out.println("Invalid command!");

			menuStep = 3;
		}

		while (menuStep == 3)
		{
			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Battle\n" + "2. Check Stats\n" + "3. Return to Main\n" + "4. Shop\n");

			bs = keyboard.nextInt();

			switch(bs)
			{
				case 1:
					Game.newBattle.startBattle();
				break;

				case 2:
					Game.mainChar.showStats();
				break;

				case 3:
					menuStep = 0; //Go back to beginning
					NewGameMenu();
				break;
				
				case 4:
					Game.newShop.openShop();

				default:
				System.out.println("Invalid Command!");
			}
		}
	}
	public void setMenuStep(int menuStep)
	{
		MainMenu.menuStep = menuStep;
	}
}