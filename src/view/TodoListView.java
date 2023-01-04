package view;

import services.TodoListService;
import util.inputUtil;

public class TodoListView {
    
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            // System.out.println("Todo List");
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = inputUtil.input("Pilih");

            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ditemukan");
            }
        }
    }

    public void addTodoList(){
        System.out.println("Menambah TodoList");

        var todo = inputUtil.input("Todo (x Jika Batal)");
        if (todo.equals("x")){
            // stop
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("Menghapus TodoList");

        var number = inputUtil.input("Nomor yang dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }

}
