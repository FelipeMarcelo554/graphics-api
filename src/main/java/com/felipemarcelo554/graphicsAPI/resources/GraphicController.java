package com.felipemarcelo554.graphicsAPI.resources;

import com.felipemarcelo554.graphicsAPI.client.LoginClient;
import com.felipemarcelo554.graphicsAPI.domain.request.GraphicRequest;
import com.felipemarcelo554.graphicsAPI.domain.response.GraphicUserResponse;
import com.felipemarcelo554.graphicsAPI.exception.GraphicNotFoundException;
import com.felipemarcelo554.graphicsAPI.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(value = "/api/graphics")
public class GraphicController {

    @Autowired
    private GraphicService graphicService;

    @Autowired
    private LoginClient loginClient;

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public ResponseEntity<GraphicUserResponse> getGraphicsByUser(@RequestHeader("Authentication") String jwt, @PathVariable Long userID) {
        try {
            System.out.println("GET - getGraphicsByUser - " + userID);

            if(!loginClient.isValid(jwt)){
                return ResponseEntity.badRequest().build();
            };

            return ResponseEntity.ok().body(graphicService.getGraphicsByUser(userID));
        } catch (GraphicNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GraphicUserResponse> postGhaphic(@RequestHeader("Authentication") String jwt, @RequestBody GraphicRequest graphicRequest){

//        if(!loginClient.isValid(jwt)){
//            return ResponseEntity.badRequest().build();
//        };

        System.out.println("POST - postGhaphic -");
        System.out.println(graphicRequest.toString());
        graphicService.persistGraphic(graphicRequest);

        return ResponseEntity.ok().build();
    }
}
