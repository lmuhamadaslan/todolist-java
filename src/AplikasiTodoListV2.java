import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import view.TodoListView;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
        
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();

    }
}
