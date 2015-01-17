package pl.dmcs.nsai.struts2.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.dmcs.nsai.struts2.entities.SecurityRoleData;

public interface SecurityRoleDAO extends CrudRepository<SecurityRoleData, Integer> {
	SecurityRoleData findByName(String name);
}
