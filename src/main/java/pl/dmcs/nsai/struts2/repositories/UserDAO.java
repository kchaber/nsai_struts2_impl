package pl.dmcs.nsai.struts2.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.dmcs.nsai.struts2.entities.UserData;

public interface UserDAO extends CrudRepository<UserData, Integer> {
	
	UserData findByLogin(String login);
	
}
