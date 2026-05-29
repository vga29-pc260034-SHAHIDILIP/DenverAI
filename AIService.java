import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AIService {

    public static String askAI(String prompt) {

        HttpURLConnection conn = null;

        try {
           URL url = URI.create("http://localhost:11434/api/generate").toURL();
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            // 🔥 SAFE JSON BUILD
           String json = "{"
        + "\"model\":\"llama3\","
        + "\"prompt\":\"You are Denver AI. Always reply clearly and correctly in English. User: "
        + escapeJson(prompt)
        + "\","
        + "\"stream\":false"
        + "}";

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }

            int code = conn.getResponseCode();

            InputStream is = (code >= 200 && code < 300)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            String response = readStream(is);

            // Extract "response" field from Ollama JSON
            String result = extractResponse(response);

           if(result != null){
    return result
            .replaceFirst("^[^a-zA-Z]*", "")
            .trim();
}

return "AI parse error";

        } catch (Exception e) {
            return "AI error: " + e.getMessage();
        } finally {
            if (conn != null) conn.disconnect();
        }
    }

    // 🔥 read full response
    private static String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    // 🔥 safer JSON escaping
    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "")
                   .replace("\t", " ");
    }
private static String extractResponse(String json) {

    try {

        String key = "\"response\":\"";

        int start = json.indexOf(key);

        if (start == -1)
            return null;

        start += key.length();

        int end = json.indexOf("\",", start);

        if (end == -1)
            end = json.indexOf("\"}", start);

        if (end == -1)
            return null;

        return json.substring(start, end)
                .replace("\\n", "\n")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");

    } catch (Exception e) {
        return null;
    }
}
}

   