package app.domain.repository;

import app.domain.Knight;
import app.utils.Ids;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() {

    }

    @Override
    public void createKnight(String name, int age) {

        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.generateNewId(knights.keySet()));
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {

        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();

        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id) {

        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Ids.generateNewId(knights.keySet()));
        knights.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{" +
                "knights=" + knights +
                '}';
    }

    @Override
    public void updateKnight(int id, Knight knight) {
        knights.put(id,knight);
    }

}
