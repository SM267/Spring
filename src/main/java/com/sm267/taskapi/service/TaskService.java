package com.sm267.taskapi.service;

import com.sm267.taskapi.model.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public synchronized List<Task> findAll() { return new ArrayList<>(tasks); }

    public synchronized Task findById(Long id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public synchronized Task create(Task task) {
        task.setId(nextId.getAndIncrement());
        tasks.add(task);
        return task;
    }

    public synchronized Task update(Long id, Task input) {
        Task task = findById(id);
        if (task == null) return null;
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setCompleted(input.isCompleted());
        return task;
    }

    public synchronized boolean delete(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}
