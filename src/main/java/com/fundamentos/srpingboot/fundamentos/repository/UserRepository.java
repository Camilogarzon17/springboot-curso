package com.fundamentos.srpingboot.fundamentos.repository;

import com.fundamentos.srpingboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    Optional<User>findByName(String name);

    @Query("select u from User u where u.name like %?1%")
    List<User>findAndShort(String  name, Sort sort);

}
