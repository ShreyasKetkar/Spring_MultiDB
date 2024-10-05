package com.multidata.connect.main.dao;

import java.util.List;
import com.multidata.connect.main.db1.entities.StudentData;
import com.multidata.connect.main.db2.entities.EmployeeData;

public class EntityDao {

	private List<StudentData> studentData;
	private List<EmployeeData> employeeData;

    public EntityDao(List<StudentData> studentData,List<EmployeeData> employeeData) {
    	this.employeeData=employeeData;
    	this.studentData=studentData;
    	
    }

	@Override
	public String toString() {
		return "EntityDao [studentData=" + studentData + ", employeeData=" + employeeData + "]";
	}
	
    
    
    
    
    
    
    
    
	
	
	
	
}
