package com.github.theinfinity007.hibernate_advance_cli.dao;

import com.github.theinfinity007.hibernate_advance_cli.entity.Instructor;
import org.springframework.stereotype.Repository;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
