package com.hussain.hms.DepartmentMicroservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.DepartmentMicroservice.Model.Department;

//It is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long> {

}
