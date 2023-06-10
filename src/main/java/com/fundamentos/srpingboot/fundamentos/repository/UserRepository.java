package com.fundamentos.srpingboot.fundamentos.repository;

import com.fundamentos.srpingboot.fundamentos.dto.UserDto;
import com.fundamentos.srpingboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query
    Optional<User>findByName(String name);

    @Query("select u from User u where u.name like %?1%")
    List<User>findAndShort(String  name, Sort sort);

    List<User>findByEmail(String  email);

    Optional<User>findByEmailAndName(String  email,  String name);

    List<User>findByNameLike(String name);

    List<User>findByNameOrEmail(String name ,String email);

    List<User>findByBirthDateBetween(LocalDate begin, LocalDate end);

    //List<User>findByNameLikeOrderByIdDesc(String name);

    List<User>findByNameContainingOrderByIdDesc(String name);
    @Query("SELECT new com.fundamentos.srpingboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            "FROM User u " +
            "where u.birthDate=:parametroFecha " +
            "and u.email=:parametroEmaila ")
    Optional<UserDto>getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                               @Param("parametroEmaila") String email);
}
