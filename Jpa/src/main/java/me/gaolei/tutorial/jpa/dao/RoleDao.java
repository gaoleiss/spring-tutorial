package me.gaolei.tutorial.jpa.dao;

import me.gaolei.tutorial.jpa.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends PagingAndSortingRepository<Role, Long> {
}
