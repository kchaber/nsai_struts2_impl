package pl.dmcs.nsai.struts2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "security_roles")
public class SecurityRoleData extends AbstractEntity implements GrantedAuthority {
	private static final long serialVersionUID = -8635031445997751456L;

	public static final String USER_ROLE_NAME = "ROLE_USER";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(nullable = false)
	private String name;
	
	public SecurityRoleData() {

	}
	
	public SecurityRoleData(String name) {
		this.name = name;
	}

	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
