package com.bijay.springbootjpa.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findByFirstName(String firstName, Pageable pageable);
    Slice<Employee> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

}
