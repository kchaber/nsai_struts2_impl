package pl.dmcs.nsai.struts2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.repositories.UserDAO;
import pl.dmcs.nsai.struts2.utils.CollectionUtil;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserData save(UserData entity) {
		entity = this.userDAO.save(entity);
		
		return entity;
	}

	public List<UserData> findAll() {
		return CollectionUtil.iterableToList(this.userDAO.findAll());
	}
	
	public UserData findById(Integer id) {
		return this.userDAO.findOne(id);
	}
	
	public UserData findByLogin(String login) {
		return this.userDAO.findByLogin(login);
	}
	
	public boolean loginUser(String login, String password) {
		UserData user = this.userDAO.findByLogin(login);
		
		if (user != null && !StringUtils.isEmpty(password) && password.equals(user.getPasswordEncrypted())) {
			return true;
		}
		
		return false;
	}
}
