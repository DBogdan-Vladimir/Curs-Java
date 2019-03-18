package com.bogdand.SpringHibernateX;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long> {
		
	Page<Opinion> findByProductId(Long productId, Pageable pageable);
	
	Optional<Opinion> findByIdAndProductId(Long id, Long productId);
}
