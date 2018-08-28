package com.ctbc.model.vo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "deptVOGG" , cascade = CascadeType.ALL)  
	private Set<EmpVO> emps;
	
	public DeptVO() {
		super();
	}
	
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public Set<EmpVO> getEmps() {
		return emps;
	}

	public void setEmps(Set<EmpVO> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "DeptVO [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
