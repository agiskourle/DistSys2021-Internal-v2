package gr.hua.dit.ds.housingsys.dao;

import gr.hua.dit.ds.housingsys.entity.User;

public interface UserDAO {

	public int addUser(String username, String password);
	public int deleteUser(String username);
	public User getUser(String password);
	
}
