public class App {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // testShowTodoList();
        // testAddTodoList();
        // testRemoveTodoList();
        // testInput();
        // testViewShowTodolist();
        // testViewAddTodoList();
        testViewRemoveTodoList();

        // viewShowTodoList();

    }

    // menampilkan todolist
    public static void showTodolist() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Membuat Aplikasi Todo List";
        showTodolist();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
        // mengecek apakah model full
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika model full resize model 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // menambahkan data ke model
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {
            addTodoList("Contoh Todo List ke " + i);
        }

        showTodolist();
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        // result = removeTodoList(4);
        // System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);

        showTodolist();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        var data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * meanampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            System.out.println("Todo List");
            showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ditemukan");
            }
        }
    }

    public static void testViewShowTodolist(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        viewShowTodoList();
    }

    /**
     * meanampilkan view tambah todo list
     */
    public static void viewAddTodoList() {
        System.out.println("Menambahkan Todolist");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();

        showTodolist();
    }

    /**
     * meanampilkan view hapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus TODOLIST");

        var number = input("Nomor yang dihapus (x Jika Batal)");

        if(number.equals("x")){
            // Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodolist();

        viewRemoveTodoList();

        showTodolist();
    }
}
