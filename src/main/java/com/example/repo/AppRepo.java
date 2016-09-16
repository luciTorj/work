package com.example.repo;

import com.example.model.App;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
public interface AppRepo extends CrudRepository<App, Long> {
    @Query("select a from App a where a.title = :title and a.processName = :processName")
    public List<App> checkIfAppExists(@Param("title") String title,
                                      @Param("processName") String processName);

}
