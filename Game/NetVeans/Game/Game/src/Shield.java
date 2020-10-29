
public class Shield extends Item {

	public Shield(String name, int worth, int modStat1)
	{
		super(name, worth, modStat1);
		dropPercent = 0.20;
	}
	
	public void Equip()
	{
		if (has) //If they have it
		{
			if (!equipped) //and it's not equipped
			{
				equipped = true; //equip it
				Game.mainChar.changeDefense(modStat1); //and change stats.
			}
			else //if they have it AND it's equipped.
				System.out.println("You already have a" + name + " equipped!"); //let them know.
		}
		else //if they don't have it.
			System.out.println("You don't have a " + name + "!"); //let them know.
	}
	
	public void Unequip()
	{
			if (equipped) //if it's equipped
			{
				equipped = false; //unequip it
				Game.mainChar.changeDefense(-modStat1); //and change stats back.
			}
			else //If it's not equipped.
				System.out.println("You don't have a" + name + " equipped!"); //let them know.
	}

}
