package com.example.model;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Timestamp;

/**
 * Created by internship on 15.09.2016.
 */
@Entity
@Setter
@Getter
@Table(name = "state")
@NoArgsConstructor
public class State extends Base {
    private long start;
    private long stop;
    private Boolean active;
    private long time;

    public State(long start, long stop, Boolean active, long time) {
        this.start = start;
        this.stop = stop;
        this.active = active;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (getStart() != state.getStart()) return false;
        if (getStop() != state.getStop()) return false;
        return getActive().equals(state.getActive());

    }

    @Override
    public int hashCode() {
        int result = (int) (getStart() ^ (getStart() >>> 32));
        result = 31 * result + (int) (getStop() ^ (getStop() >>> 32));
        result = 31 * result + getActive().hashCode();
        return result;
    }
}
