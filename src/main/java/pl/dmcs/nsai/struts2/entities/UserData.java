package pl.dmcs.nsai.struts2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserData extends AbstractEntity {
	private static final long serialVersionUID = -9088782719960350724L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(nullable = false, length = 30)
	private String login;
	
	@Column(nullable = false)
	private String passwordEncrypted;
	
	@Column(length = 50)
	private String firstName;

	@Column(length = 100)
	private String lastName;
	
	@Column(nullable = false, length = 100)
	private String email;

	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(String passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
