package test.test_service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import services.TodoListService;
import services.TodoListServiceImpl;

public class TodoListServiceTes {
    public static void main(String[] args) {
        // testShowTodoList();
        // testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepositoryImp = new TodoListRepositoryImpl();
        todoListRepositoryImp.data[0] = new TodoList("Belajar Java Dasar");
        todoListRepositoryImp.data[1] = new TodoList("Belajar Java OOP");
        todoListRepositoryImp.data[2] = new TodoList("Belajar Java Standar Classes");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepositoryImp);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();

    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();

        todoListService.removeTodoList(4);
        todoListService.removeTodoList(2);

        todoListService.showTodoList();
    }
}
