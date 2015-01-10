package pl.dmcs.nsai.struts2.actions;


public abstract class AbstractCRUDAction<ENTITY> extends AbstractAction {
	private static final long serialVersionUID = 1454733102689903969L;
	
	protected Integer selectedId;
	protected ENTITY managedEntity;
	
	public String create() {
		this.reset();
		return INPUT;
	}

	public String modify() {
		if (this.selectedId != null) {
			this.managedEntity = this.loadManagedEntity(this.selectedId);
		}
		
		return INPUT;
	}

	protected void reset() {
	}
	
	public abstract ENTITY loadManagedEntity(Integer id);
	
	public Integer getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Integer selectedId) {
		this.selectedId = selectedId;
	}
}
