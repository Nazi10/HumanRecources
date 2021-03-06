package com.internship.HRapp.dto.taskDto;

import com.internship.HRapp.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class TaskDTO {
    private UUID taskId;
    private UUID projectId;
    private String taskName;
    private TaskStatus taskStatus;
}
