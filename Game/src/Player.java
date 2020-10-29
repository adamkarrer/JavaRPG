import java.util.Random;
import java.util.Scanner;

public class Player
{
	protected String name;
	protected int currentHealth, damage, defense, currentMana, mp, currentExp, level, expNeeded, gold;
	protected int maxHealth, maxMana;
	
	enum Element {FIRE, WATER, AIR, EARTH}; 
	
	protected Element element;
	protected Element defaultElement;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Player(String t)//Constructor
	{
		System.out.println("What is your name?");
		setName(keyboard.nextLine());
		setCurrentExp(0);
		setexpNeededed(250);
		setLevel(1);
		setGold(100);
		
		switch(t)
		{
		case "Swordsman":
			setMaxHealth(100); //338 //1711 Leveling up?
			setDamage(15); //51  //258
			setDefense(10); //34 //172
			setMaxMana(5);
			setMP(10);
			setElement(Element.AIR);
			defaultElement = Element.AIR;
			fullHeal();
			fullMana();
			break;
		case "Sentry":
			setMaxHealth(115);
			setDamage(10);
			setDefense(15);
			setMaxMana(0);
			setMP(0);
			setLevel(1);
			setElement(Element.EARTH);
			defaultElement = Element.EARTH;
			fullHeal();
			fullMana();
			break;
		case "Wizard":
			setMaxHealth(80);
			setDamage(5);
			setDefense(5);
			setMaxMana(15);
			setMP(25);
			setLevel(1);
			setElement(Element.WATER);
			defaultElement = Element.WATER;
			fullHeal();
			fullMana();
			break;
			default:
				System.out.println("ERROR: INVALID ENEMY TYPE!");
		}
	}
//Get

public String getName()
	{
		return name;
	}

	public int getDefense()
	{
		return defense;
	}

	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getDamage()
	{
		return damage;
	}

	public int getCurrentMana()
	{
		return currentMana;
	}
	
	public int getMaxMana()
	{
		return maxMana;
	}
	
	public int getMP()
	{
		return mp;
	}
	
	public int getCurrentExp()
	{
		return currentExp;
	}

	public int getExpNeeded()
	{
		return expNeeded;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public Element getElement()
	{
		return element;
	}


//Add

	public void addCurrentHealth(int health)
	{
		currentHealth += health;
	}
	
	public void addMaxHealth(int maxHealth)
	{
		this.maxHealth += maxHealth;
	}

	public void addDamage(int damage)
	{
		this.damage += damage;
	}

	public void addDefense(int defense)
	{
		this.defense += defense;
	}

		public void addCurrentMana(int mana)
	{
		currentMana += mana;
	}
		
	public void addMaxMana(int maxMana)
	{
		this.maxMana += maxMana;
	}

		public void addMp(int mp)
	{
		this.mp += mp;
	}

	public void addCurrentExp(int exp)
	{
		this.currentExp += exp;
	}
	
	public void addexpNeededed(int expNeeded)
	{
		this.expNeeded += expNeeded;
	}
	
	public void addLevel(int level)
	{
		this.level += level;
	}
	
	public void addGold(int gold)
	{
		this.gold += gold;
	}
	

//Set

	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}
	
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCurrentMana(int currentMana)
	{
		this.currentMana = currentMana;
	}
	
	public void setMaxMana(int maxMana)
	{
		this.maxMana = maxMana;
	}

	public void setMP(int mp)
	{
		this.mp = mp;
	}

	public void setCurrentExp(int currentExp)
	{
		this.currentExp = currentExp;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public void setexpNeededed(int expNeeded)
	{
		this.expNeeded = expNeeded;
	}
	
	public void setGold(int gold)
	{
		this.gold = gold;
	}
	
	public void setElement(Element element)
	{
		this.element = element;
	}

//Other
/*
	public void attack()
	{
		Random rand = new Random();
		int dmg = 0;
		int dmgStart = 1;
		
		if (mainChar.element == Element.WATER && Game.enemy.element == Element.FIRE)
		{
			dmgStart = (int)(mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (mainChar.element == Element.EARTH && Game.enemy.element == Element.AIR)
		{
			dmgStart = (int)(mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (mainChar.element == Element.AIR && Game.enemy.element == Element.WATER)
		{
			dmgStart = (int)(mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (mainChar.element == Element.FIRE && Game.enemy.element == Element.EARTH)
		{
			dmgStart = (int)(mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else
		{
			dmg = rand.nextInt((getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		
		if (dmg < 0)
		{
			dmg = 0;
		}
		
		System.out.println("\nYou attack!");
		System.out.println("You do " + dmg + " damage!");

		Game.enemy.addCurrentHealth(-dmg);

		System.out.println("The " + Game.enemy.getName() + " is at " + Game.enemy.getCurrentHealth() + " health!\n");

		if (mainChar.getCurrentHealth() <= 0 && Game.enemy.getCurrentHealth() > 0)
		{
			System.out.println("\nYou lose!");
			mainChar.resetHealth();
			mainChar.resetMP();
		}

		else if (Game.enemy.getCurrentHealth() <= 0 && mainChar.getCurrentHealth() > 0)
		{
			Game.Win();
		}
		else if (Game.enemy.getCurrentHealth() <= 0 && mainChar.getCurrentHealth() <= 0)
		{
			System.out.println("\nTie!");
			mainChar.setExp(Game.enemy.getCurrentExp() / 2);
			mainChar.resetHealth();
			mainChar.resetMP();
		}

	}

	public int Defend()
	{
		Random rand = new Random();

	int n = rand.nextInt(defense) + 1;

	if (n < 0)
			n = 0;
		else
			return n;
		return n;
	}
	
	public void UseSpell()
	{
		System.out.println("Which spell?");
		System.out.println("1. Twister[AIR] " + " 2. Fireball[FIRE] " + " 3. Ice Spike[WATER] " + " 4. Boulder[EARTH] ");
		
		int s = keyboard.nextInt();
		
		if (s==1)
		{
			System.out.println("You use Twister!");
			mainChar.element = Element.AIR;
			
			mainChar.Attack();
			mainChar.setElement(defaultElement);
			mainChar.mp -= 5;
		}
		else if (s==2)
		{
			System.out.println("You use Fireball!");
			mainChar.element = Element.FIRE;
			mainChar.Attack();
			mainChar.setElement(defaultElement);
			mainChar.mp -= 5;
		}
		else if (s==3)
		{
			System.out.println("You use Ice Spike!");
			mainChar.element = Element.WATER;
			mainChar.Attack();
			mainChar.setElement(defaultElement);
			mainChar.mp -= 5;
		}
		else if (s==4)
		{
			System.out.println("You use Boulder!");
			mainChar.element = Element.EARTH;
			mainChar.Attack();
			mainChar.setElement(defaultElement);
			mainChar.mp -= 5;
		}
		else
			System.out.println("Invalid command!");
	}
*/
/*	public void LevelUp()
	{
		addCurrentHealth((int)(getCurrentHealth() * 1.5));
		maxHealth = getCurrentHealth();
		addDamage((int)(getDamage() * 1.5));
		addDefense((int)(getDefense() * 1.5));
		addCurrentMana((int)(getCurrentMana() * 1.5));
		addMp((int)(getMP() * 1.5));
		addLevel(1);

		expNeeded = (int)(expNeeded + (expNeeded * 1.68));

		System.out.println("\nYou have leveled up! You are now level " + getLevel() + "!");
	}
*/
	public void showStats()
	{
		System.out.println("\nStats: \n");
		System.out.println("Name: " + getName());
		System.out.println("Level: " + getLevel());
		System.out.println("Health: " + getCurrentHealth());
		System.out.println("Damage: " + getDamage());
		System.out.println("Defense: " + getDefense());
		System.out.println("Magic: " + getCurrentMana());
		System.out.println("MP: " + getMP());
		System.out.println("EXP: " + getCurrentExp() + "/" + getExpNeeded() + "\n");
		System.out.println("Gold: " + getGold());
	//	System.out.println("Potions: " + Game.potion.inInventory);

	}
	
	public void fullHeal()
	{
		setCurrentHealth(getMaxHealth());
	}
	public void fullMana()
	{
		setCurrentMana(getMaxMana());
	}

	public void getAllStats()
	{
		getName();
		getLevel();
		getCurrentHealth();
		getDamage();
		getDefense();
		getCurrentMana();
		getMP();
		getCurrentExp();
		getGold();
	}
}