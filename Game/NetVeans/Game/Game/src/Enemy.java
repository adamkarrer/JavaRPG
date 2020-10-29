import java.util.Random;

public class Enemy extends Player
{
	Random rand = new Random();
	
	public Enemy()
	{
	}

	public void Wolf()
	{
		setName("Wolf");
		setHealth(100);
		setDamage(10);
		setDefense(1);
		setExp(50);
		setElement(Element.AIR);
		dropRating = 2;

		maxHealth = health;
	}

	public void Bear()
	{
		setName("Bear");
		setHealth(500);
		setDamage(50);
		setDefense(10);
		setExp(200);
		setElement(Element.EARTH);
		dropRating = 3;

		maxHealth = health;
	}

		public void Dragon()
	{
		setName("Dragon");
		setHealth(2000);
		setDamage(300);
		setDefense(150);
		setExp(500);
		setElement(Element.FIRE);
		dropRating = 5;

		maxHealth = health;
	}

//Other

		public void Attack()
		{
			Random rand = new Random();
			int dmg = 0;
			int dmgStart = 1;
			
			if (Game.enemy.element == Element.WATER && Game.mainChar.element == Element.FIRE)
			{
				dmgStart = (int)(Game.enemy.damage / 2);
				dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.mainChar.Defend();
			}
			else if (Game.enemy.element == Element.EARTH && Game.mainChar.element == Element.AIR)
			{
				dmgStart = (int)(Game.enemy.damage / 2);
				dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.mainChar.Defend();
			}
			else if (Game.enemy.element == Element.AIR && Game.mainChar.element == Element.WATER)
			{
				dmgStart = (int)(Game.enemy.damage / 2);
				dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.mainChar.Defend();
			}
			else if (Game.enemy.element == Element.FIRE && Game.mainChar.element == Element.EARTH)
			{
				dmgStart = (int)(Game.enemy.damage / 2);
				dmg = (rand.nextInt(getDamage()) + dmgStart) - Game.mainChar.Defend();
			}
			else
			{
				dmg = rand.nextInt((getDamage()) + 1) - Game.mainChar.Defend();
			}
			
			if (dmg < 0)
			{
				dmg = 0;
			}
			
			Game.mainChar.changeHealth(-dmg);

			System.out.println("The " + Game.enemy.getName() + " does " + dmg + " damage!");
			System.out.println("You are at " + Game.mainChar.getHealth() + " health!");

			if (Game.mainChar.getHealth() <= 0 && Game.enemy.getHealth() > 0)
			{
				System.out.println("\nYou lose!");
				Game.mainChar.resetHealth();
			}

			else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() > 0)
			{
				Game.Win();
				Game.mainChar.resetHealth();
			}
			else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() <= 0)
			{
				System.out.println("\nTie!");
				Game.mainChar.setExp(Game.enemy.getExp() / 2);
			}
			
		}
	
}