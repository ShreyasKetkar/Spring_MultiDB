package com.multidata.connect.main.db1.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.multidata.connect.main.db1.entities.StudentData;
@Repository
public interface StudentRepository extends JpaRepository<StudentData, Integer>{

}
