package com.studentspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.studentspringboot.model.Class;
import org.springframework.stereotype.Repository;


@Repository
public interface IClassRepository extends JpaRepository<Class, Long> {
    Page<Class> findAll(Pageable pageable);

}
