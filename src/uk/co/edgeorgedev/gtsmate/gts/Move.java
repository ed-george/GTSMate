package uk.co.edgeorgedev.gtsmate.gts;

import com.google.gson.annotations.Expose;

public class Move {
	
	@Expose
	private String typeName;	
	@Expose
	private String name;
	@Expose
	private String typeId;

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
