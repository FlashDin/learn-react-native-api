package com.testapp0.testapp0api.controllers;

import com.testapp0.testapp0api.controllers.rest.TUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<TUsers, Long> {

    Optional<TUsers> findByUname(String uname);

    @Query("SELECT uname,pass FROM t_users where uname=:uname and pass=:pass")
    Optional<TUsers> findByUnamePass(@Param("uname") String uname, @Param("pass") String pass);

}
