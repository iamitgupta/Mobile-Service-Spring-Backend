package com.ms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ms.entity.Mobile;

@Repository
public interface MobileRepository extends MongoRepository<Mobile, Long>,MobileCustomRepository{
	
	Page<Mobile> findByTitleContainingIgnoreCase(String title, Pageable pageable);
	

}
