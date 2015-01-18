package pl.dmcs.nsai.struts2.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class UserData extends AbstractEntity implements UserDetails {
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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userData")
	private List<ParkingPlaceReservationData> placeReservations;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<SecurityRoleData> securityRoles;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.securityRoles;
	}

	@Override
	public String getPassword() {
		return this.passwordEncrypted;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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

	public List<ParkingPlaceReservationData> getPlaceReservations() {
		if (this.placeReservations == null) {
			this.placeReservations = new ArrayList<>();
		}
		return placeReservations;
	}

	public void setPlaceReservations(List<ParkingPlaceReservationData> placeReservations) {
		this.placeReservations = placeReservations;
	}

	public Set<SecurityRoleData> getSecurityRoles() {
		if (this.securityRoles == null) {
			this.securityRoles = new HashSet<>();
		}
		return securityRoles;
	}

	public void setSecurityRoles(Set<SecurityRoleData> securityRoles) {
		this.securityRoles = securityRoles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
