/* A simple text-based game by Adam Karrer (2013)

TODO:
Get better at Java
Add more items and enemies.
Tweak stats for more even game play.
Add databasing
Come up with more TODO.
*/
import java.util.Random;
import java.io.*;
import java.util.*;
public class Game
{
	Random rand = new Random();

/*	public void Win()
	{
		System.out.println("You win!\n");
		mainChar.addCurrentExp(enemy.getCurrentExp());
		//DropItem();
		//Game.enemy.resetHealth();
		mainChar.fullMana();
		mainChar.fullHeal();

		if (mainChar.getCurrentExp() >= mainChar.getExpNeeded() )
		{
		//	mainChar.LevelUp();
		}
	}

/*	public static void Save()
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
			System.out.println("Error: "+ex);
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
			System.out.println("Error: "+ex);
		}
	}*/
	
	/*public void DropItem()
	{
		int r = rand.nextInt(enemy.getDropRating());
		int g = (rand.nextInt(enemy.getDropRating()) + 1) * 10;
		
		if (g > 0)
		{
			if (Math.random() < .33)
			mainChar.addGold(g);
			System.out.println(enemy.getName() + " dropped " + g + " gold!");
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
	}*/
	
	public static void main(String[] args)
	{

		//Player mainChar = new Player("Swordsman");
		//mainChar.showStats();
		DBConnect con = new DBConnect();
		//con.saveChar(mainChar);
		Player secondChar = new Player("Wizard");
		con.saveChar(secondChar);
		//Player psv = new Player("Swordsman");
		//String query = "INSERT INTO `char` (`name`, `level`, `current_health`, `max_health`, `current_mana`, `max_mana`, `damage`, `defense`, `mp`, `current_exp`, `exp_needed`, `gold`, `element`) VALUES ("+ "NULL, '" +psv.getName()+ "', '" +psv.getLevel()+ "', '" +psv.getCurrentHealth()+ "', '" +psv.getMaxHealth()+ "', '" +psv.getCurrentMana()+ "', '" +psv.getMaxMana()+ "', '" +psv.getDamage()+ "', '" +psv.getDefense()+ "', '" +psv.getCurrentExp()+ "', '" +psv.getExpNeeded()+ "', '" +psv.getGold()+ "', '" +psv.getElement()+ "')"; 
		//System.out.println(query);
	}
	

}