package com.example.bookstore_backend.repository;

import com.example.bookstore_backend.entity.Category;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

@Repository
public interface CategoryRepository extends Neo4jRepository<Category, Long> {

    @Query("""
        MATCH (c:Category {name: $type})
        OPTIONAL MATCH (c)-[:INCLUDES*..2]->(related:Category)
        RETURN DISTINCT related.name AS name
    """)
    List<String> findRelatedCategories(@Param("type") String type);
}
