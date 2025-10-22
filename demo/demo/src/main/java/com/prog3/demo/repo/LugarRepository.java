package com.prog3.demo.repo;

import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import com.prog3.demo.model.Lugar;

@Repository
public interface LugarRepository extends Neo4jRepository<Lugar, Long> {

    // Trae todos los lugares con sus relaciones CONECTA (Spring Data Neo4j lo mapea automáticamente)
    @Query("MATCH (l:Lugar) OPTIONAL MATCH (l)-[r:CONECTA]->(m:Lugar) RETURN l")
    List<Lugar> obtenerLugaresConConexiones();


    // 🔹 Agregamos una query de testeo para ver qué llega
    @Query("MATCH (l:Lugar) RETURN l")
    List<Lugar> obtenerSoloLugares();
}
