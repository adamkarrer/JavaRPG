import java.util.Random;
public class Item
{
	boolean has, equipped;
	String name;
	int inInventory, worth, modStat1;
	double dropPercent;
	
	Random rand = new Random();

	public Item(String name, int worth, int modStat1)
	{
		this.name = name;
		this.worth = worth;
		this.modStat1 = modStat1;
		
		while (inInventory > 0)
		{
			has = true;
		}
	}

	public void Buy(int amt)
	{
		int amount = amt;
		if(amt == 1)
		{
			if(Game.mainChar.getGold() >= worth)
			{
				inInventory++;
				Game.mainChar.changeGold(-worth);
				System.out.println("You have bought a " + name + " for " + worth + " gold!");
				System.out.println("You now have " + inInventory + " " + name + "(s)!");
				System.out.println("You now have " + Game.mainChar.getGold() + " gold!");
			}
			else
			{
				System.out.println("Not enough gold!");
			}
		}

		else if(amt > 1)
		{
			while (amt > 0)
			{
				if(Game.mainChar.getGold() >= worth)
				{
					inInventory++;
					Game.mainChar.changeGold(-worth);
				}
				else
				{
					System.out.println("Not enough gold!");
				}
				amt--;
			}
			System.out.println("\nYou have bought " + amount + " " + name + "s for " + (worth * amount) + " gold!");
			System.out.println("You now have " + inInventory + " " + name + "s in stock!");
			System.out.println("You now have " + Game.mainChar.getGold() + " gold!\n");
		}
		Game.newShop.openShop();
	}


	public void Sell(int amt)
	{
		int amount = amt;
		if(amt == 1)
		{
			if(inInventory >= amt)
			{
				inInventory--;
				Game.mainChar.changeGold(worth - (int)(worth * .2));
				System.out.println("You have sold a " + name + " for " + (worth - (int)(worth * .2))  + " gold!");
				System.out.println("You now have " + inInventory + " " + name + "(s)!");
				System.out.println("You now have " + Game.mainChar.getGold() + " gold!");
			}
			else
			{
				System.out.println("Not enough " + name + "s!");
			}
		}

		else if(amt > 1)
		{
			while (amt > 0)
			{
				if(inInventory >= amt)
				{
					inInventory--;
					Game.mainChar.changeGold(worth - (int)(worth * .2));
				}
				else
				{
					System.out.println("Not enough " + name + "s!");
					Game.newShop.shopSell();
				}
				amt--;
			}
			System.out.println("\nYou have sold " + amount + " " + name + "s for " + ((worth - (int)(worth * .2)) * amount )  + " gold!");
			System.out.println("You now have " + inInventory + " " + name + "s in stock!");
			System.out.println("You now have " + Game.mainChar.getGold() + " gold!\n");
		}
		Game.newShop.openShop();
	}

	public int getInventory()
	{
		return inInventory;
	}
	public String getName()
	{
		return name;
	}
	public void addInventory(int amt)
	{
		inInventory += amt;
	}
	public void setInventory(int amt)
	{
		inInventory = amt;	
	}
	public void Use()
	{
	}
	
	public void Equip()
	{
	}
	
	public void Unequip()
	{
	}

}