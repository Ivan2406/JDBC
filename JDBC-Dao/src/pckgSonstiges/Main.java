package pckgSonstiges;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import pckgDao.*;
import pckgDomain.*;

public class Main 
{
	public static void main(String[] args) 
	{
		KlassenDAOImpl    k = new KlassenDAOImpl();
		LehrerDAOImpl     l = new LehrerDAOImpl();
		UnterrichtDAOImpl u = new UnterrichtDAOImpl();

		Lehrer l1 = new Lehrer(1, "Gustav", "Zimmerer");
		Lehrer l2 = new Lehrer(2, "Peter", "Maurer");
		Lehrer l3 = new Lehrer(3, "Thomas", "M�ller");
		
		Klassen k1 = new Klassen ("4AHIF");
		Klassen k2 = new Klassen ("4BHIFS");
		Klassen k3 = new Klassen ("4CHIF");
		
		Unterricht u1 = new Unterricht(l1.getId(), k1.getId(),"MO1");
		Unterricht u2 = new Unterricht(l1.getId(), k1.getId(),"MO2");
		Unterricht u3 = new Unterricht(l2.getId(), k1.getId(),"MO4");

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdao?user=root&password=");
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM klassen;");
		
			System.out.println("---Nach Insert von den 2 Klassen---");
			rs = stmt.executeQuery("SELECT * FROM klassen;");
			k.insert(con, k1);
			k.insert(con, k2);
			showRS(rs,1);
			
			l.insert(con, l1);
			l.insert(con, l2);
			System.out.println("---Nach Insert von den 2 Lehrern---");
			rs = stmt.executeQuery("SELECT * FROM lehrer;");
			showRS(rs,3);
			
			u.insert(con, u1);
			u.insert(con, u2);
			u.insert(con, u3);
			System.out.println("---Nach Insert von den 3 Unterricht---");
			rs = stmt.executeQuery("SELECT * FROM unterricht;");
			showRS(rs,3);
			
			System.out.println("---Nach Update von Klasse 1---");
			rs = stmt.executeQuery("Update klassen set id = '4AHIFS' where id = '4AHIF';");
			showRS(rs,1);
			
			System.out.println("---Nach Update von Lehrer 2---");
			rs = stmt.executeQuery("Update lehrer set Vorname = 'Franz' where id = 'Peter';");
			showRS(rs,3);
			
			System.out.println("---Nach Update von Unterricht 2---");
			rs = stmt.executeQuery("Update Unterricht set tagstunde = 'DI1' where tagstunde = 'MO2';");
			showRS(rs,3);
			
			System.out.println("---Nach Delete von Unterricht 2---");
			rs = stmt.executeQuery("delete from Unterricht where tagstunde = 'DI1'");
			showRS(rs,3);
			
			System.out.println("---Truncate von unterricht---");
			rs = stmt.executeQuery("truncate unterricht");
			try
			{
				rs.first();
			}
			catch(SQLException ex)
			{
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			System.out.println("---l�schen aller Klassen---");
			rs = stmt.executeQuery("delete from klassen where 1 = 1");
			try
			{
				rs.first();
			}
			catch(SQLException ex)
			{
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			System.out.println("---l�schen aller lehrer---");
			rs = stmt.executeQuery("delete from lehrer where 1 = 1");
			try
			{
				rs.first();
			}
			catch(SQLException ex)
			{
				System.out.println("Im Catch-Block nach rs.first() -> tabelle leer");
			}
			
			rs.close();
			stmt.close();
			
		}
		catch(SQLException e)
		{
			System.out.println("Verbindung funktioniert nicht!!");
		} 
		catch (Exception e)
		{
			System.err.println("Fehler bei 'Class.forName(\"com.mysql.jdbc.Driver\").newInstance();'");
		}
	}
	
	private static void showRS(ResultSet rs, int num)
	{
		try {
			while ( rs.next() ) 
			{
				ResultSetMetaData rsmd = rs.getMetaData();
				
				for(int i = 1; i<=num; ++i)
				{
					System.out.print(rsmd.getColumnName(i) + ":" + rs.getString(i) + " ;");
				}
				System.out.println("");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("Fehler!");
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
