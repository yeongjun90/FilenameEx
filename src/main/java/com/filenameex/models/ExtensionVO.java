package com.filenameex.models;

import java.util.List;

public class ExtensionVO {

	private int e_tb_id;
	private String name;
	private String type;
	private String status;
	private List<ExtensionVO> elist;

	public List<ExtensionVO> getElist() {
		return elist;
	}

	public void setElist(List<ExtensionVO> elist) {
		this.elist = elist;
	}

	public int getE_tb_id() {
		return e_tb_id;
	}

	public void setE_tb_id(int e_tb_id) {
		this.e_tb_id = e_tb_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
