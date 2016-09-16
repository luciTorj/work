package com.example.service;

import com.example.model.App;
import com.example.model.State;
import com.example.repo.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by internship on 16.09.2016.
 */
@Service
public class AppService {
    @Autowired
    private AppRepo repo;

    public App save(App app) {

        List<App> appExists = repo.checkIfAppExists(app.getTitle(), app.getProcessName());

        if (appExists.size() > 0) {

            if (! statesAreEqual(getLastStateForApp(appExists.get(0)), app.getStates().get(0))) {
                appExists.get(0).getStates().add(app.getStates().get(0));
            }

            app = appExists.get(0);
        }

        return repo.save(app);
    }

    public boolean statesAreEqual(State state1, State state2) {
        return state1.equals(state2);
    }

    public State getLastStateForApp(App app) {
        if (app.getStates().size() > 0) {
            return app.getStates().get(app.getStates().size() - 1);
        }

        return null;
    }

    public Iterable<App> findAll() {
        return repo.findAll();
    }

    public App findOne(long l) {
        return repo.findOne(l);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
