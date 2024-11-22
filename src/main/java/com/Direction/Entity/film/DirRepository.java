package com.Direction.Entity.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirRepository extends JpaRepository<Director,Integer>{

}
