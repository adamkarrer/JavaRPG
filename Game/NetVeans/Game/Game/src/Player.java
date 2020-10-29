import java.util.Random;
import java.util.Scanner;

public class Player
{
	protected String name;
	protected int health, damage, defense, magic, dropRating, mp, exp, level, expNeed, gold;
	int maxHealth, maxMp;
	
	enum Element {FIRE, WATER, AIR, EARTH}; 
	
	Element element;
	Element defaultElement;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Player()//Constructor
	{
		setExp(0);
		setExpNeed(250);
		setLevel(1);
		setGold(100);
	}

	public void Swordsman()
	{
		setHealth(100); //338 //1711
		setDamage(15); //51  //258
		setDefense(10); //34 //172
		setMagic(5);
		setMP(10);
		setElement(Element.AIR);
		defaultElement = Element.AIR;
		maxHealth = health;
		maxMp = mp;
	}

	public void Sentry()
	{
		setHealth(115);
		setDamage(10);
		setDefense(15);
		setMagic(0);
		setMP(0);
		setLevel(1);
		setElement(Element.EARTH);
		defaultElement = Element.EARTH;
		maxHealth = health;
		maxMp = mp;
	}

		public void Wizard()
	{
		setHealth(80);
		setDamage(5);
		setDefense(5);
		setMagic(15);
		setMP(25);
		setLevel(1);
		setElement(Element.WATER);
		defaultElement = Element.WATER;
		maxMp = mp;
		maxHealth = health;

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

	public int getHealth()
	{
		return health;
	}

	public int getDamage()
	{
		return damage;
	}

	public int getMagic()
	{
		return magic;
	}

	public int getMP()
	{
		return mp;
	}

	public int getExp()
	{
		return exp;
	}

	public int getLevel()
	{
		return level;
	}

	public int getNeed()
	{
		return expNeed;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public Element getElement()
	{
		return element;
	}


//Change

	public void changeHealth(int hltChange)
	{
		health += hltChange;
	}

	public void changeDamage(int dmgChange)
	{
		damage += dmgChange;
	}

	public void changeDefense(int defChange)
	{
		defense += defChange;
	}

		public void changeMagic(int magChange)
	{
		magic += magChange;
	}

		public void changeMP(int mpChange)
	{
		mp += mpChange;
	}

	public void changeExp(int expChange)
	{
		exp += expChange;
	}
	
	public void changeGold(int golChange)
	{
		gold += golChange;
	}
	

//Set

	public void setHealth(int hlthSet)
	{
		health = hlthSet;
	}

	public void setDamage(int dmgSet)
	{
		damage = dmgSet;
	}

	public void setDefense(int defSet)
	{
		defense = defSet;
	}

	public void setName(String namSet)
	{
		name = namSet;
	}

	public void setMagic(int magSet)
	{
		magic = magSet;
	}

	public void setMP(int MpSet)
	{
		mp = MpSet;
	}

	public void setExp(int expSet)
	{
		exp = expSet;
	}

	public void setLevel(int lvlSet)
	{
		level = lvlSet;
	}

	public void setExpNeed(int needSet)
	{
		expNeed = needSet;
	}
	public void setGold(int goldSet)
	{
		gold = goldSet;
	}
	public void setElement(Element element)
	{
		this.element = element;
	}

//Other

	public void Attack()
	{
		Random rand = new Random();
		int dmg = 0;
		int dmgStart = 1;
		
		if (Game.mainChar.element == Element.WATER && Game.enemy.element == Element.FIRE)
		{
			dmgStart = (int)(Game.mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (Game.mainChar.element == Element.EARTH && Game.enemy.element == Element.AIR)
		{
			dmgStart = (int)(Game.mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (Game.mainChar.element == Element.AIR && Game.enemy.element == Element.WATER)
		{
			dmgStart = (int)(Game.mainChar.damage / 2);
			dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.enemy.Defend();
		}
		else if (Game.mainChar.element == Element.FIRE && Game.enemy.element == Element.EARTH)
		{
			dmgStart = (int)(Game.mainChar.damage / 2);
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

		Game.enemy.changeHealth(-dmg);

		System.out.println("The " + Game.enemy.getName() + " is at " + Game.enemy.getHealth() + " health!\n");

		if (Game.mainChar.getHealth() <= 0 && Game.enemy.getHealth() > 0)
		{
			System.out.println("\nYou lose!");
			Game.mainChar.resetHealth();
			Game.mainChar.resetMP();
		}

		else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() > 0)
		{
			Game.Win();
		}
		else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() <= 0)
		{
			System.out.println("\nTie!");
			Game.mainChar.setExp(Game.enemy.getExp() / 2);
			Game.mainChar.resetHealth();
			Game.mainChar.resetMP();
		}

	}

	public void resetHealth()
	{
		health = maxHealth;
	}
	
	public void resetMP()
	{
		mp = maxMp;
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
			Game.mainChar.element = Element.AIR;
			
			Game.mainChar.Attack();
			Game.mainChar.setElement(defaultElement);
			Game.mainChar.mp -= 5;
		}
		else if (s==2)
		{
			System.out.println("You use Fireball!");
			Game.mainChar.element = Element.FIRE;
			Game.mainChar.Attack();
			Game.mainChar.setElement(defaultElement);
			Game.mainChar.mp -= 5;
		}
		else if (s==3)
		{
			System.out.println("You use Ice Spike!");
			Game.mainChar.element = Element.WATER;
			Game.mainChar.Attack();
			Game.mainChar.setElement(defaultElement);
			Game.mainChar.mp -= 5;
		}
		else if (s==4)
		{
			System.out.println("You use Boulder!");
			Game.mainChar.element = Element.EARTH;
			Game.mainChar.Attack();
			Game.mainChar.setElement(defaultElement);
			Game.mainChar.mp -= 5;
		}
		else
			System.out.println("Invalid command!");
	}

	public void LevelUp()
	{
		changeHealth((int)(getHealth() * 1.5));
		maxHealth = getHealth();
		changeDamage((int)(getDamage() * 1.5));
		changeDefense((int)(getDefense() * 1.5));
		changeMagic((int)(getMagic() * 1.5));
		changeMP((int)(getMP() * 1.5));
		setLevel(getLevel() + 1);

		expNeed = (int)(expNeed + (expNeed * 1.68));

		System.out.println("\nYou have leveled up! You are now level " + getLevel() + "!");
	}

	public void showStats()
	{
		System.out.println("\nStats: \n");
		System.out.println("Name: " + getName());
		System.out.println("Level: " + getLevel());
		System.out.println("Health: " + getHealth());
		System.out.println("Damage: " + getDamage());
		System.out.println("Defense: " + getDefense());
		System.out.println("Magic: " + getMagic());
		System.out.println("MP: " + getMP());
		System.out.println("EXP: " + getExp() + "/" + getNeed() + "\n");
		System.out.println("Gold: " + getGold());
		System.out.println("Potions: " + Game.potion.inInventory);

	}

	public void getAllStats()
	{
		getName();
		getLevel();
		getHealth();
		getDamage();
		getDefense();
		getMagic();
		getMP();
		getExp();
		getGold();
	}
	
	public void Wolf()
	{
	}
	
	public void Dragon()
	{
	}
	
	public void Bear()
	{
	}
	
	public void DropItem()
	{
	}
}