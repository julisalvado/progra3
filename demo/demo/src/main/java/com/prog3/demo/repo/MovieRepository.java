package com.prog3.demo.repo;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import com.prog3.demo.model.MovieEntity;

import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveNeo4jRepository<MovieEntity,String>{
    Mono<MovieEntity>findOneByTitle(String title);
}
