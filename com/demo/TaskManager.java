package com.demo;


	import java.util.*;

	public class TaskManager {

	    private HashMap<Integer, Task> taskPool = new HashMap<>();
	    private Random rand = new Random();

	    public void addTask(Task t) {
	        taskPool.put(taskPool.size(), t);
	    }

	    public List<Task> assignTasks() {

	        List<Task> assigned = new ArrayList<>();

	        if (taskPool.isEmpty()) return assigned;

	        Object[] keys = taskPool.keySet().toArray();

	        int count = rand.nextInt(4) + 1;

	        for (int i = 0; i < count; i++) {
	            int key = (int) keys[rand.nextInt(keys.length)];
	            assigned.add(taskPool.get(key));
	        }

	        return assigned;
	    }
	}