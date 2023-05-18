package app.domain.repository;

import app.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight) { throw new NotImplementedException(); }
}