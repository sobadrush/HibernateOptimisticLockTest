package com.ctbc.model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name = "EmpVOFuck")
@Table(name = "z40180_empTB")
public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empno")
	private Integer empId;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "job")
	private String empJob;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "hiredate" , columnDefinition = "DATE")
	private java.util.Date empHiredate;
	
	@JoinColumn(name = "deptno")
	@ManyToOne(fetch = FetchType.EAGER)
	private DeptVO deptVOGG;
	
	@Version
	@Column(name="version")
	private Integer version;
	
	public EmpVO() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public java.util.Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(java.util.Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	public DeptVO getDeptVOGG() {
		return deptVOGG;
	}

	public void setDeptVOGG(DeptVO deptVOGG) {
		this.deptVOGG = deptVOGG;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "EmpVO [empId=" + empId + ", empName=" + empName + ", empJob=" + empJob + ", empHiredate=" + empHiredate + ", version=" + version + "]";
	}

}
