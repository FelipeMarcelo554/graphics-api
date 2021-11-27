package com.felipemarcelo554.graphicsAPI.repository;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import com.felipemarcelo554.graphicsAPI.domain.GraphicValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicValueRepository extends JpaRepository<GraphicValue, Long> {

    List<GraphicValue> findAllByGraphic(Graphic graphic);

}
