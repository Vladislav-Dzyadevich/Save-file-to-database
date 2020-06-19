package com.company.repository;

import com.company.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {
    CustomUser findByLogin(String login);

    CustomUser findByEmail(String email);

    @Query(value = "select c from CustomUser c where" +
            " c.name like %:name% or c.surName like %:name% or c.login like %:name%")
    List<CustomUser> findByNameAndSurName(@Param("name") String name);

}
