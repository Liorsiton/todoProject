package com.lior.springboottodoapplication.repository;

import com.lior.springboottodoapplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {


}
