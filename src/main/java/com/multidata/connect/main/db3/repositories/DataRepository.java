package com.multidata.connect.main.db3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multidata.connect.main.db3.entities.Person;

@Repository
public interface DataRepository extends MongoRepository<Person, Integer>{

}
