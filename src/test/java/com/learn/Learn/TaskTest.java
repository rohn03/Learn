package com.learn.Learn;

import com.learn.Learn.enums.TaskStatus;
import com.learn.Learn.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    Task task = new Task(
            "feature001",
            "Create Task",
            "should create a task",
            TaskStatus.BACKLOG
    );

    @Test
    void shouldCreateTaskWithExpectedValues() {
        assertEquals("feature001", task.getId());
        assertEquals("Create Task", task.getTitle());
        assertEquals("should create a task", task.getDescription());
        assertEquals(TaskStatus.BACKLOG, task.getStatus());
    }

    @Test
    void shouldUpdateTaskStatus() {

        task.setStatus(TaskStatus.SPRINT_READY);
        assertEquals(TaskStatus.SPRINT_READY, task.getStatus());
    }

    @Test
    void shouldUpdateTitle(){
        task.rename("renamed Title");
        assertEquals("renamed Title", task.getTitle());
    }

}
