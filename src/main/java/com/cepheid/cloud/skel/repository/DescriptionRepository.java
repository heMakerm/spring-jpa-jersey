package com.cepheid.cloud.skel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.model.Item.State;

public interface DescriptionRepository extends JpaRepository<Description, Long>{
	 @Query("SELECT i FROM Description i WHERE i.item.mId = :item")
	 List<Description> findDescForItem(@Param("item") Long item);
}
