package pl.dmcs.nsai.struts2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import pl.dmcs.nsai.struts2.entities.SecurityRoleData;
import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.repositories.SecurityRoleDAO;
import pl.dmcs.nsai.struts2.repositories.UserDAO;
import pl.dmcs.nsai.struts2.utils.CollectionUtil;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SecurityRoleDAO securityRoleDAO;

	@Autowired
	private PasswordEncoder encoder;

	public UserData save(UserData entity) {
		if (entity.getId() == null && !StringUtils.isEmpty(entity.getPasswordEncrypted())) {
			// encrypt password
			entity.setPasswordEncrypted(this.encodePassword(entity.getPasswordEncrypted()));

			SecurityRoleData userRole = this.securityRoleDAO.findByName(SecurityRoleData.USER_ROLE_NAME);
			if (userRole != null) {
				entity.getSecurityRoles().add(userRole);
			}
		}
		entity = this.userDAO.save(entity);

		return entity;
	}
	
	public String encodePassword(String password) {
		String encodedPassword = encoder.encode(password);
		return encodedPassword;
	}

	public void remove(Integer userId) {
		this.userDAO.delete(userId);
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

	public UserData loginUser(String login, String password) {
		UserData user = this.userDAO.findByLogin(login);

		if (user != null && !StringUtils.isEmpty(password) && password.equals(user.getPasswordEncrypted())) {
			return user;
		}

		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return this.findByLogin(arg0);
	}
}
