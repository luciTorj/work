package com.example.rest;

import com.example.model.App;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@RequestMapping(value = "/")
public interface AppController {
    @RequestMapping(value = "apps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getApps();

    @RequestMapping(value="update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    ResponseEntity updateApps(List<App> apps);
}
