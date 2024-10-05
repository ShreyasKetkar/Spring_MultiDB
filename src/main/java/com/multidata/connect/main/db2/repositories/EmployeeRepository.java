package com.multidata.connect.main.db2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.multidata.connect.main.db2.entities.EmployeeData;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Integer> {

}
