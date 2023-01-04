package test.test_view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        // testShowTodoList();
        // testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListViewTest = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standar Classes");

        todoListViewTest.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListViewTest = new TodoListView(todoListService);

        todoListViewTest.addTodoList();
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListViewTest = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Dasar");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standar Classes");

        todoListService.showTodoList();
        todoListViewTest.removeTodoList();
        todoListService.showTodoList();
    }
    
}
