package com.felipemarcelo554.graphicsAPI.resources;

import com.felipemarcelo554.graphicsAPI.domain.request.GraphicRequest;
import com.felipemarcelo554.graphicsAPI.domain.response.GraphicUserResponse;
import com.felipemarcelo554.graphicsAPI.exception.GraphicNotFoundException;
import com.felipemarcelo554.graphicsAPI.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(value = "/api/graphics")
public class GraphicController {

    @Autowired
    private GraphicService graphicService;

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public ResponseEntity<GraphicUserResponse> getGraphicsByUser(@PathVariable Long userID) {
        try {
            System.out.println("GET - getGraphicsByUser - " + userID);
            return ResponseEntity.ok().body(graphicService.getGraphicsByUser(userID));
        } catch (GraphicNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GraphicUserResponse> postGhaphic(@RequestBody GraphicRequest graphicRequest){

        System.out.println("POST - postGhaphic -");
        System.out.println(graphicRequest.toString());
        graphicService.persistGraphic(graphicRequest);

        return ResponseEntity.ok().build();
    }
}
