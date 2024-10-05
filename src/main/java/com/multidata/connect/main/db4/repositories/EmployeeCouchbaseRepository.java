package com.multidata.connect.main.db4.repositories;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.multidata.connect.main.db4.entities.Employee;

@Repository
public interface EmployeeCouchbaseRepository extends CouchbaseRepository<Employee, Integer>{

}
