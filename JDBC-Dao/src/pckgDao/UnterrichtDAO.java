package pckgDao;

import java.sql.Connection;
import java.util.List;

import pckgDomain.Unterricht;

public interface UnterrichtDAO 
{
	public abstract int insert(Connection con, Unterricht u);

	public abstract int update(Connection con, Unterricht u);
	
	public abstract int delete(Connection con, Unterricht u);

	public abstract List<Unterricht> findAllUnterricht(Connection con);
}
