package com.permispiste.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by seljo on 5/4/2017.
 */
@Entity
@Table(name = "mission", schema = "permispiste")
public class MissionEntity implements IEntity {
    private int nummission;
    private String libmission;
    private JeuEntity jeuByNumjeu;

    private Set<ObjectifEntity> objectives = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "fixe", joinColumns = {
            @JoinColumn(name = "nummission", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "numobjectif",
                    nullable = false, updatable = false) })
    public Set<ObjectifEntity> getObjectives() {
        return objectives;
    }

    public void setObjectives(Set<ObjectifEntity> objectives) {
        this.objectives = objectives;
    }

    @Id
    @Column(name = "NUMMISSION")
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Basic
    @Column(name = "LIBMISSION")
    public String getLibmission() {
        return libmission;
    }

    public void setLibmission(String libmission) {
        this.libmission = libmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (nummission != that.nummission) return false;
        if (libmission != null ? !libmission.equals(that.libmission) : that.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + (libmission != null ? libmission.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU", nullable = false)
    public JeuEntity getJeuByNumjeu() {
        return jeuByNumjeu;
    }

    public void setJeuByNumjeu(JeuEntity jeuByNumjeu) {
        this.jeuByNumjeu = jeuByNumjeu;
    }
}
