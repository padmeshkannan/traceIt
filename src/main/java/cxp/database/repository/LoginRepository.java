package cxp.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cxp.database.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	List<Login> findByUserNameAndPassword(String userName, String password);
}