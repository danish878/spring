package com.danny.crudwebdemo.repository;

import com.danny.crudwebdemo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("SELECT type, COUNT(type) FROM Location GROUP BY type")
    List<Object[]> findTypeAndTypeCount();
}
