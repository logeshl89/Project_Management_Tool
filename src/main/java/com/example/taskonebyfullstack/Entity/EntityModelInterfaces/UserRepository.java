package com.example.taskonebyfullstack.Entity.EntityModelInterfaces;

import com.example.taskonebyfullstack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(nativeQuery = true,value = "select * from users where email=?1")
    List<User> FindEmailIdExistOrNot(String email);
    @Query(nativeQuery = true,value = "select * from users where phone_number=?1")
    List<User> PhoneNumberExistOrNot(String phonenumber);
    List<User> findByUsernameAndPassword(String username,String password);
    @Query(nativeQuery = true,value = "select tasks_completed from users where user_id=?1")
    long GetTheNumberOfTaskCompletedById(long id);
    @Query(nativeQuery = true,value = "UPDATE users set tasks_completed=?1 where user_id=?2")
    long UpdateUserTaskCompletedById(long task,long userid);
    @Query(nativeQuery = true,value = "select user_id from first_full_stack.users where username=?1")
    long findByUsername(String username);
}
