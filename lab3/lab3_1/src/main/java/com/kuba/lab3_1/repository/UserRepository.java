package com.kuba.lab3_1.repository;

import com.kuba.lab3_1.domain.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {}
