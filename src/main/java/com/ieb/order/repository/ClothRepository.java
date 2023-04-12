package com.ieb.order.repository;

import com.ieb.order.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Isaias Espejo
 */
@Repository
public interface ClothRepository  extends JpaRepository<Cloth, Long> {

}
