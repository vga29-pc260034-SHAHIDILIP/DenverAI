import java.awt.Desktop;
import java.net.URI;

public class CommandHandler {

    public static String handle(String input) {

        input = input.toLowerCase().trim();

        try {

            // Google
            if (input.contains("google")) {
                Desktop.getDesktop().browse(
                    new URI("https://www.google.com")
                );
                return "Opening Google...";
            }

            // YouTube (fix typo support)
            if (input.contains("youtube") || input.contains("youtub")) {
                Desktop.getDesktop().browse(
                    new URI("https://www.youtube.com")
                );
                return "Opening YouTube...";
            }

            // Search
            if (input.startsWith("search ")) {

                String query = input.replace("search ", "");
                String url = "https://www.google.com/search?q=" + query;

                Desktop.getDesktop().browse(new URI(url));

                return "Searching: " + query;
            }

        } catch (Exception e) {
            return "Error opening website.";
        }

        return null;
    }
}