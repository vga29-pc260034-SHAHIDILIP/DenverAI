import java.io.*;
import java.util.HashMap;

public class MemoryManager {

    private static HashMap<String, String> memory = new HashMap<>();
    private static final String FILE = "memory.txt";

    static {
        loadMemory();
    }

    public static void remember(String key, String value) {
        memory.put(key, value);
        saveMemory();
    }

    public static String recall(String key) {
        return memory.get(key);
    }

    private static void saveMemory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE))) {

            for (String key : memory.keySet()) {
                writer.println(key + "=" + memory.get(key));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadMemory() {
        try {
            File file = new File(FILE);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split("=", 2);

                if (parts.length == 2) {
                    memory.put(parts[0], parts[1]);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}