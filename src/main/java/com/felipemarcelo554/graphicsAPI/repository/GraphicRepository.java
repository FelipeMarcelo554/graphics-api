package com.felipemarcelo554.graphicsAPI.repository;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Long> {

    List<Graphic> findAllByUserId(Long userId);
}
