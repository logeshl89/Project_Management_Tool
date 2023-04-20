package com.example.taskonebyfullstack.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence")
    @SequenceGenerator(name = "task_sequence", sequenceName = "task_sequence", allocationSize = 1)
    @Column(name = "task_id")
    private Long taskId;
    @Column(name = "tasktitle")
    private String tasktitle;
    @Column(name = "receiver_user_id")
    private Long receiverUserId;
    @Column(name = "task_description", length = 2000)
    private String taskDescription;
    @Column(name = "status", nullable = false)
    private boolean status = false;
}

