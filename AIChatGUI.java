import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AIChatGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AIChatGUI() {

        setTitle("Denver AI Assistant");

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.GREEN);
        chatArea.setCaretColor(Color.WHITE);

        // Input field
        inputField = new JTextField();
        inputField.setBackground(Color.DARK_GRAY);
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        // Send button
        sendButton = new JButton("Send");
         sendButton.setBackground(Color.GRAY);
        sendButton.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action
        sendButton.addActionListener((ActionEvent e) -> sendMessage());
        inputField.addActionListener((ActionEvent e) -> sendMessage());

        setVisible(true);
    }

private void sendMessage() {

    String userText = inputField.getText().trim();

    if(userText.isEmpty()) return;

    chatArea.append("You: " + userText + "\n");

    inputField.setText("");

    String lower = userText.toLowerCase();


    // ADD TODO
    if(lower.startsWith("add todo")){

        try{

            String[] parts =
                    userText.split(" ",4);

            String priority = parts[2];

            String task = parts[3];

            TodoManager.addTodo(task, priority);

            chatArea.append(
                    "Denver: Todo added -> "
                    + task + "\n\n"
            );

        }catch(Exception e){

            chatArea.append(
                    "Denver: Usage -> add todo high learn java\n\n"
            );
        }

        return;
    }
if(
    lower.equals("show todos")
    || lower.equals("show todo")
    || lower.equals("show me todo")
    || lower.equals("show me todos")
    || lower.equals("my todos")
    || lower.equals("show my todos")
    || lower.contains("todo list")
){

    chatArea.append(
            "Denver:\n"
            + TodoManager.getTodos()
            + "\n"
    );

    return;
}


    // COMPLETE TODO
    if(lower.startsWith("complete todo")){

        try{

            int num =
                    Integer.parseInt(
                            userText.substring(13).trim()
                    );

            chatArea.append(
                    "Denver: "
                    + TodoManager.completeTodo(num)
                    + "\n\n"
            );

        }catch(Exception e){

            chatArea.append(
                    "Denver: Invalid number.\n\n"
            );
        }

        return;
    }


    // REMOVE TODO
    if(lower.startsWith("remove todo")){

        try{

            int num =
                    Integer.parseInt(
                            userText.substring(11).trim()
                    );

            chatArea.append(
                    "Denver: "
                    + TodoManager.removeTodo(num)
                    + "\n\n"
            );

        }catch(Exception e){

            chatArea.append(
                    "Denver: Invalid number.\n\n"
            );
        }

        return;
    }


    // REMEMBER NAME
    if(lower.contains("my name is")){

        String name =
                userText.substring(
                        lower.indexOf("my name is") + 10
                ).trim();

        MemoryManager.remember("name", name);

        chatArea.append(
                "Denver: Nice to meet you, "
                + name + "!\n\n"
        );

        return;
    }


    // RECALL NAME
    if(lower.contains("what is my name")
            || lower.contains("tell me my name")){

        String name =
                MemoryManager.recall("name");

        if(name != null){

            chatArea.append(
                    "Denver: Your name is "
                    + name + "\n\n"
            );

        }else{

            chatArea.append(
                    "Denver: I don't know your name yet.\n\n"
            );
        }

        return;
    }


    // REMEMBER COLOR
    if(lower.contains("my favorite color is")){

        String color =
                userText.substring(
                        lower.indexOf(
                                "my favorite color is"
                        ) + 20
                ).trim();

        MemoryManager.remember("color", color);

        chatArea.append(
                "Denver: Nice! I'll remember your favorite color is "
                + color + "\n\n"
        );

        return;
    }


    // RECALL COLOR
    if(lower.contains("favorite color")){

        String color =
                MemoryManager.recall("color");

        if(color != null){

            chatArea.append(
                    "Denver: Your favorite color is "
                    + color + "\n\n"
            );

        }else{

            chatArea.append(
                    "Denver: I don't know your favorite color yet.\n\n"
            );
        }

        return;
    }


    // WEBSITE COMMANDS
    String commandReply =
            CommandHandler.handle(userText);

    if(commandReply != null){

        chatArea.append(
                "Denver: "
                + commandReply + "\n\n"
        );

        return;
    }


   // AI BRAIN
chatArea.append("Denver: thinking...\n");

String aiReply =
        AIService.askAI(

                "You are Denver , a smart desktop AI assistant created by Dilip Shahi. " +
                "Always reply shortly, clearly, and friendly. " +
                "Never say you are another AI model or university project. " +
                "Never mention OpenAI, Boulder, or training data. " +
                "Act like a real personal AI assistant.\n\n" +

                "User: " + userText
        );

chatArea.append("Denver: ");

for(int i = 0; i < aiReply.length(); i++){

    chatArea.append(
            String.valueOf(aiReply.charAt(i))
    );

    try{
        Thread.sleep(20);
    }catch(Exception e){
        e.printStackTrace();
    }
}

chatArea.append("\n\n");

}
}

