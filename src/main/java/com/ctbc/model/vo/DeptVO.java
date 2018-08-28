package com.ctbc.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DeptVO")
@Table(name = "z40180_deptTB")
public class DeptVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deptno")
	private Integer deptId;

	@Column(name = "dname")
	private String deptName;

	@Column(name = "loc")
	private String deptLoc;

	public DeptVO() {
		super();
	}

	@Override
	public String toString() {
		return "DeptVO [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
