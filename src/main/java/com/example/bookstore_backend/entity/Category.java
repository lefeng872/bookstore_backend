package com.example.bookstore_backend.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node("Category")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String name;

    @Relationship(type = "INCLUDES", direction = Relationship.Direction.OUTGOING)
    private List<Category> relatedCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getRelatedCategories() {
        return relatedCategories;
    }

    public void setRelatedCategories(List<Category> relatedCategories) {
        this.relatedCategories = relatedCategories;
    }
}
