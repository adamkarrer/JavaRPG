import java.util.Random;

public class Enemy extends Player
{
	Random rand = new Random();
	protected int dropRating, expGive;

	public Enemy(String e)
	{
		switch(e)
		{
		case "Wolf":
			setName("Wolf");
			setMaxHealth(100);
			setDamage(10);
			setDefense(1);
			setCurrentExp(50);
			setElement(Element.AIR);
			fullHeal();
			setDropRating(1);
			break;
		case "Bear":
			setName("Bear");
			setMaxHealth(500);
			setDamage(50);
			setDefense(10);
			setCurrentExp(200);
			setElement(Element.EARTH);
			fullHeal();
			setDropRating(3);
			break;
		case "Dragon":
			setName("Dragon");
			setMaxHealth(2000);
			setDamage(300);
			setDefense(150);
			setCurrentExp(500);
			setElement(Element.FIRE);
			fullHeal();
			setDropRating(5);
			break;
		default:
			System.out.println("ERROR: INVALID ENEMY TYPE!");
		}
	}

//Other
		public int getDropRating()
		{
			return dropRating;
		}
		
		public void setDropRating(int dropRating)
		{
			this.dropRating = dropRating;
		}

	/*	public void Attack()
		{
			Random rand = new Random();
			int dmg = 0;
			int dmgStart = 1;
			
			if (Enemy.getElement() == Element.WATER && Game.mainChar.element == Element.FIRE)
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
				Game.mainChar.resetCurrentHealth();
			}

			else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() > 0)
			{
				Game.Win();
				Game.mainChar.resetCurrentHealth();
			}
			else if (Game.enemy.getHealth() <= 0 && Game.mainChar.getHealth() <= 0)
			{
				System.out.println("\nTie!");
				Game.mainChar.setCurrentExp(Game.enemy.getExp() / 2);
			}
			
		}*/
	
}