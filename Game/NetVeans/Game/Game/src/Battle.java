import java.util.Scanner; //import the scanner


public class Battle
{
	private int input;

 	public Battle()
	{
	}

	public void startBattle()
	{
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		System.out.println("\nChoose your enemy!");
		System.out.println("1. Wolf\n" + "2. Bear\n" + "3. Dragon\n" + "4. Go back\n");

		int x = keyboard.nextInt();

		if (x == 1)
		{
			Game.enemy.Wolf();
		}

		else if (x == 2)
		{
			Game.enemy.Bear();
		}

		else if (x == 3)
		{
			Game.enemy.Dragon();
		}

		else if (x == 4)
		{
			Game.menu.setMenuStep(3);
			Game.menu.NewGameMenu();
		}

		while (Game.mainChar.getHealth() > 0 && Game.enemy.getHealth() > 0)
		{
			if (Game.mainChar.mp <= 0)
				System.out.println("1. Attack\n" + "2. Run\n" + "3. Use Potion\n");
			else if (Game.mainChar.mp > 0)
				System.out.println("1. Attack\n" + "2. Run\n" + "3. Use Potion\n" + "4. Use Magic\n");

			input = keyboard.nextInt();

			switch(input) //Menu
			{
				case 1:
					Game.mainChar.Attack();
					Game.enemy.Attack();

				break;

				case 2:
					System.out.println("\nYou run away!");

					Game.enemy.resetHealth();
					Game.mainChar.resetHealth();
					Game.mainChar.resetMP();
					startBattle();
				break;

				case 3:
					Game.potion.Use();
				break;
				
				case 4:
					if (Game.mainChar.mp > 0)
						Game.mainChar.UseSpell();
				break;

				default:
					System.out.println("Invalid command!");
			}
		}
	}
}