package me.gaolei.tutorial.jpa.dao;

import me.gaolei.tutorial.jpa.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    public User findByUserName(String userName);

}
