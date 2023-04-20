package com.example.taskonebyfullstack.Entity.EntityModelInterfaces;

import com.example.taskonebyfullstack.Entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> getByReceiverUserId(long id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE tasks SET status=1 WHERE receiver_user_id = ?1 AND task_id = ?2",nativeQuery = true)
    int UpdateTheStatusByUserIdAndTaskId(long rui,long ti);
}
