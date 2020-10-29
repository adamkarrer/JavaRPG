/* A simple text-based game by Adam Karrer (2013)

TODO:
Add more items and enemies.
Tweak stats for more even gameplay.
Come up with more TODO.
*/
import java.util.Random;
import java.io.*;
import java.util.*;

public class Game
{
	static MainMenu menu = new MainMenu();
	static Player mainChar = new Player();
	static Player enemy = new Enemy();
	static Battle newBattle = new Battle();
	static Shop newShop = new Shop();
	static Item potion = new Potion("Potion", 10,10);
	static Item sword = new Sword("Sword", 50, 5);
	static Item shield = new Shield("Shield", 50, 5);

	static Random rand = new Random();

	static Item[] ItemArray = {null, potion, sword, shield};

	public static void main(String[] args)
	{
		menu.NewGameMenu();
	}

	public static void Win()
	{
		System.out.println("You win!\n");
		mainChar.changeExp(enemy.getExp());
		DropItem();
		//Game.enemy.resetHealth();
		mainChar.resetMP();
		mainChar.resetHealth();

		if (mainChar.getExp() >= mainChar.getNeed() )
		{
			mainChar.LevelUp();
		}

	MainMenu.menuStep = 3;
	menu.NewGameMenu();
	}

	public static void Save()
	{
		try
		{
			PrintWriter charSave = new PrintWriter("mainChar.txt");

			charSave.println(mainChar.getName());
			charSave.println(mainChar.getLevel());
			charSave.println(mainChar.getHealth());
			charSave.println(mainChar.getDamage());
			charSave.println(mainChar.getDefense());
			charSave.println(mainChar.getMagic());
			charSave.println(mainChar.getMP());
			charSave.println(mainChar.getExp());
			charSave.println(mainChar.getNeed());
			charSave.println(mainChar.getGold());
			charSave.println(potion.inInventory);
			charSave.println(sword.inInventory);

			charSave.close();
		}

		catch(IOException ex)
		{
			System.out.println("Error!");
		}
	}

	public static void Load()
	{
		try
		{
			File charSave = new File("mainChar.txt");
			Scanner loadSave = new Scanner (charSave);

			mainChar.setName(loadSave.next());
			mainChar.setLevel(loadSave.nextInt());
			mainChar.setHealth(loadSave.nextInt());
			mainChar.setDamage(loadSave.nextInt());
			mainChar.setDefense(loadSave.nextInt());
			mainChar.setMagic(loadSave.nextInt());
			mainChar.setMP(loadSave.nextInt());
			mainChar.setExp(loadSave.nextInt());
			mainChar.setExpNeed(loadSave.nextInt());
			mainChar.setGold(loadSave.nextInt());
			potion.addInventory(loadSave.nextInt());
			sword.addInventory(loadSave.nextInt());

			loadSave.close();
		}

		catch(IOException ex)
		{
			System.out.println("Error!");
		}

		MainMenu.menuStep = 3;
		menu.NewGameMenu();
	}
	
	public static void DropItem()
	{
		int r = rand.nextInt(Game.enemy.dropRating);
		int g = (rand.nextInt(Game.enemy.dropRating) + 1) * 10;
		
		if (g > 0)
		{
			if (Math.random() < .33)
			Game.mainChar.changeGold(g);
			System.out.println(Game.enemy.name + " dropped " + g + " gold!");
		}
		
		if (r == 0)
		{
			System.out.println("No item dropped!");
		}
		
		else if (r > 0)
		{
			if (Math.random() < ItemArray[r].dropPercent)
			{
					ItemArray[r].addInventory(1);
					System.out.println(Game.enemy.name + " dropped a " + ItemArray[r].getName() + "!");
			}
			else
				System.out.println("No item dropped!");
		}
	}
}