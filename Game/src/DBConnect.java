import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect 
{
	private Connection con;
	private Statement st;
	private ResultSet rs; 
	private final String DBLOC = "jdbc:mysql://localhost:3306/charSave?useSSL=false";
	private final String DBUSR = "root";
	private final String DBPASS = "Sstrunks1!";
	
	public DBConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBLOC,DBUSR,DBPASS);
			st = con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error:" +ex);
		}
	}
	
	public void getData()
	{
		try
		{
			String query = "SELECT * FROM usr";
			rs = st.executeQuery(query);
			System.out.println("Records from database: ");
			while(rs.next())
			{
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String birth = rs.getString("birth");
				String age = rs.getString("age");
				String id = rs.getString("id");
				System.out.println("ID: " +id+ "\nName: " +name+ "\nSex: " +sex+ "\nBirthday: " +birth+ "\nAge: " +age+ "\n");
			}
		}
		catch(Exception ex)
		{
				System.out.println("Error: " +ex);
		}
		
	}
	
	public void saveChar(Player psv)
	{
		try
		{
			String query = "INSERT INTO `char` (`id`, `name`, `level`, `current_health`, `max_health`, `current_mana`, `max_mana`, `damage`, `defense`, `mp`, `current_exp`, `exp_needed`, `gold`, `element`) VALUES ("+ "NULL, '" +psv.getName()+ "', '" +psv.getLevel()+ "', '" +psv.getCurrentHealth()+ "', '" +psv.getMaxHealth()+ "', '" +psv.getCurrentMana()+ "', '" +psv.getMaxMana()+ "', '" +psv.getDamage()+ "', '" +psv.getDefense()+ "', '" +psv.getMP()+ "', '" +psv.getCurrentExp()+ "', '" +psv.getExpNeeded()+ "', '" +psv.getGold()+ "', '" +psv.getElement()+ "')"; 
			st.executeUpdate(query);
			System.out.println("Character Saved!");
		}
		catch(Exception ex)
		{
			System.out.print("Error: " +ex);
		}
	}

}
