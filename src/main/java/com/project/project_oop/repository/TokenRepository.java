package com.project.project_oop.repository;

import com.project.project_oop.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(
            value = "select t from Token t inner join User u on t.user.id = u.id where u.id = :id and (t.expired = false or t.revoked = false)"
    )
    List<Token> findAllValidTokenByUser(Long id);

    Token findByToken(String token);

}
