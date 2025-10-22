package com.prog3.demo.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node("Movie")
public class MovieEntity {
    @Id
    private String title;
    @Property("tagline")
    private  String description;
    @Relationship(type="ACTED_IN", direction=Direction.INCOMING)
    private Set<PersonEntity> actors = new HashSet<>();
    @Relationship(type="DIRECTED", direction=Direction.INCOMING)
    private Set<PersonEntity> directors=new HashSet<>();
    public MovieEntity(String title, String description) {
        this.title=title;
        this.description=description;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getDescription(String description) {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public Set<PersonEntity> getActors() {
        return actors;
    }

    public void setActors(Set<PersonEntity> actors) {
        this.actors=actors;
    }

    public Set<PersonEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<PersonEntity> directors) {
        this.directors=directors;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", directors=" + directors +
        '}';
    }
}
