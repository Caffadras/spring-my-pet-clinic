package com.caffadras.springmypetclinic.services.map;

import com.caffadras.springmypetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Number & Comparable<ID>>  {
    protected Map<ID, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if(object != null){
            object.setId((Long) nextId());
            map.put((ID) object.getId(), object);
        }
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    protected Number nextId(){
        if (map.isEmpty()) return 1L;

        return (Long) Collections.max(map.keySet()) + 1L;
    }
}
