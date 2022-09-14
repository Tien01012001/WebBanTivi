package vn.iotstar.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CategoryModel implements Serializable {
	private int id;
	private String name;
	private String icon;

	public CategoryModel(int id, String name, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
	}

	public CategoryModel() {
		super();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
