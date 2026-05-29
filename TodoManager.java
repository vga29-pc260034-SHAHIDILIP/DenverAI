import java.io.*;
import java.util.ArrayList;

public class TodoManager {

    private static ArrayList<Todo> todos =
            new ArrayList<>();

    private static final String FILE_NAME =
            "todos.txt";


    // AUTO LOAD
    static{
        loadTodos();
    }


    // ADD TODO
    public static void addTodo(
            String task,
            String priority
    ){

        todos.add(new Todo(task, priority));

        saveTodos();
    }


    // SHOW TODOS
    public static String getTodos(){

        if(todos.isEmpty()){

            return "Todo list is empty.";
        }

        StringBuilder sb =
                new StringBuilder();

        sb.append("===== TODO LIST =====\n");

        for(int i=0;i<todos.size();i++){

            sb.append(i+1)
              .append(". ")
              .append(todos.get(i))
              .append("\n");
        }

        return sb.toString();
    }


    // COMPLETE TODO
    public static String completeTodo(int index){

        if(index < 1 || index > todos.size()){

            return "Invalid todo number.";
        }

        todos.get(index-1).complete();

        saveTodos();

        return "Todo completed.";
    }


    // REMOVE TODO
    public static String removeTodo(int index){

        if(index < 1 || index > todos.size()){

            return "Invalid todo number.";
        }

        Todo removed =
                todos.remove(index-1);

        saveTodos();

        return "Removed: "
                + removed.getTask();
    }


    // SAVE TODOS
    private static void saveTodos(){

        try{

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(FILE_NAME)
                    );

            for(Todo todo : todos){

                writer.println(
                        todo.getTask()
                        + "|"
                        + todo.getPriority()
                        + "|"
                        + todo.isCompleted()
                );
            }

            writer.close();

        }catch(Exception e){

            e.printStackTrace();
        }
    }


    // LOAD TODOS
    private static void loadTodos(){

        try{

            File file =
                    new File(FILE_NAME);

            if(!file.exists()) return;

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while((line = reader.readLine()) != null){

                String[] parts =
                        line.split("\\|");

                if(parts.length == 3){

                    Todo todo =
                            new Todo(
                                    parts[0],
                                    parts[1]
                            );

                    if(Boolean.parseBoolean(parts[2])){

                        todo.complete();
                    }

                    todos.add(todo);
                }
            }

            reader.close();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}