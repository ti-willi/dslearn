package com.tiwilli.dslearn.repositories;

import com.tiwilli.dslearn.entities.Role;
import com.tiwilli.dslearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByAuthority(String msg);
}
