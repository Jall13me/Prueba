package com.example.prueba.persistence.repository;

import com.example.prueba.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);
    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id",nativeQuery = true)
    public void markTaskAsFinished(@Param("id")Long id);

}
