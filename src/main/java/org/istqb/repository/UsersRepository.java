package org.istqb.repository;

import org.istqb.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query("select c from Users AS c")
	public Page<Users> fetch(Pageable pageable);
}
