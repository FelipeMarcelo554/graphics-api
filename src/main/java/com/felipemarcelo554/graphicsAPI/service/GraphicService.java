package com.felipemarcelo554.graphicsAPI.service;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import com.felipemarcelo554.graphicsAPI.domain.GraphicValue;
import com.felipemarcelo554.graphicsAPI.domain.dto.ValuesDto;
import com.felipemarcelo554.graphicsAPI.domain.request.GraphicRequest;
import com.felipemarcelo554.graphicsAPI.domain.response.GraphicUserResponse;
import com.felipemarcelo554.graphicsAPI.exception.GraphicNotFoundException;
import com.felipemarcelo554.graphicsAPI.repository.GraphicRepository;
import com.felipemarcelo554.graphicsAPI.repository.GraphicValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphicService {

    @Autowired
    private GraphicRepository graphicRepository;

    @Autowired
    private GraphicValueRepository graphicValueRepository;

    public GraphicUserResponse getGraphicsByUser(Long userID) throws GraphicNotFoundException {

        List<Graphic> lstGraphics = graphicRepository.findAllByUserId(userID);
        if (lstGraphics.isEmpty()) {
            throw new GraphicNotFoundException("Gráfico não encontrado!");
        }
        for (Graphic gr :
                lstGraphics) {
            gr.setValues(graphicValueRepository.findAllByGraphic(gr));
        }

        return GraphicUserResponse.toResponse(lstGraphics);
    }

    public void persistGraphic(GraphicRequest graphicRequest) {

        if (graphicRequest != null) {

            Graphic graphic = new Graphic();
            graphic.setUser(graphicRequest.getUserId());
            graphic.setName(graphicRequest.getNomeGrafico());
            //graphic.setValues();

            Graphic graphicEntity = graphicRepository.save(graphic);

            for (ValuesDto dto : graphicRequest.getValues()) {
                for (String str : dto.getValues().split(", ")) {

                    GraphicValue graphicValue = new GraphicValue();
                    graphicValue.setGraphic(graphicEntity);
                    graphicValue.setName(dto.getName());
                    graphicValue.setValue(str);

                    graphicValueRepository.save(graphicValue);
                }
            }
        }
    }
}
