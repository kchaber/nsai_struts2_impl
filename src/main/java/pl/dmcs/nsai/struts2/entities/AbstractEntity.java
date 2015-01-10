package pl.dmcs.nsai.struts2.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 8952231252036895274L;

	public abstract Integer getId();

	public abstract void setId(Integer id) ;

}
