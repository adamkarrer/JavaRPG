import java.util.Random;

public class Potion extends Item
{
	
	public Potion(String name, int worth, int modStat1)
	{
		super(name, worth, modStat1);
		dropPercent = 0.65;
	}
	
	
	public void Use()
	{
		Random rand = new Random();
		int modStat = rand.nextInt(modStat1) + 1;

		if (Game.mainChar.getHealth() >= Game.mainChar.maxHealth)
		{
			System.out.println("\nYou are already at maximum health!");
			System.out.println("Potions: " + inInventory);
		}

		else if (Game.mainChar.getHealth() + modStat > Game.mainChar.maxHealth)
		{
			int healthGained = Game.mainChar.maxHealth - Game.mainChar.getHealth();
			Game.mainChar.changeHealth(healthGained);
			System.out.println("\n You've used " + getName() + "!");
			System.out.println("You gain " + healthGained + " Health!\n");
			System.out.println("You are at " + Game.mainChar.getHealth() + " health!\n");
			inInventory--;
			System.out.println("Potions: " + inInventory);
		}

		else if (Game.potion.inInventory == 0)
		{
			System.out.println("\nNone left!");
		}
		
		else
		{
			Game.mainChar.changeHealth(modStat);
			System.out.println("\nYou've used " + getName() + "!");
			System.out.println ("You gain " + modStat + " Health!\n");
			System.out.println("You are at " + Game.mainChar.getHealth() + " health!\n");
			inInventory--;
			System.out.println("Potions: " + inInventory);
		}
	}
}

