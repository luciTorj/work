package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Table(name = "App")
@NoArgsConstructor
@Setter
@Getter
public class App extends Base {
    private long processId;
    private String title;
    private String processName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<State> states = new ArrayList<>();

    public App(long processId, String title, String processName) {
        this.processId = processId;
        this.title = title;
        this.processName = processName;
    }

    public App(String title, String processName) {
        this.title = title;
        this.processName = processName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof App)) return false;

        App app = (App) o;

        if (!getTitle().equals(app.getTitle())) return false;
        return getProcessName().equals(app.getProcessName());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getProcessName().hashCode();
        return result;
    }
}
