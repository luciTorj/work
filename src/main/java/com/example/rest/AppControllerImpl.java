package com.example.rest;

import com.example.model.App;
import com.example.repo.AppRepo;
import com.example.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@RestController
public class AppControllerImpl implements AppController {

    @Autowired
    private AppService appService;

    @Override
    public ResponseEntity getApps() {
        List<App> apps = (List<App>) appService.findAll();
        return ResponseEntity.ok().body(apps);
    }

    @Override
    public ResponseEntity updateApps(@RequestBody List<App> apps) {
        List<App> addedApps = new ArrayList<>();

        for (int i = 0; i < apps.size(); i++) {
            App addedApp = appService.save(apps.get(i));
            addedApps.add(i, addedApp);
        }

        return ResponseEntity.ok().body(addedApps);
    }
}
