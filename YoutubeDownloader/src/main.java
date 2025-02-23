import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        try {
            String playlistUrl = "https://www.youtube.com/playlist?list=PLn8Bo36g1_eC6SGAb8Z1GEYG-RoGtka9u"; // Replace with your playlist URL
            String outputDir = "mp3_output"; // Specify the output directory

            // Create the output directory if it doesn't exist
            File outputDirectory = new File(outputDir);
            if (!outputDirectory.exists()) {
                outputDirectory.mkdirs();
            }

            // Specify the full path to yt-dlp executable
            String ytDlpPath = "yt-dlp.exe"; // Replace with the actual path

            // Construct the yt-dlp command
            String[] command = {
                    ytDlpPath+
                    "--extract-audio",
                    "--audio-format", "mp3",
                    "--audio-quality", "320K",
                    "--output", outputDir + "/%(title)s.%(ext)s",
                    playlistUrl
            };

            // Execute the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Playlist downloaded successfully. MP3 files saved in " + outputDir);
            } else {
                System.err.println("Error occurred while downloading the playlist.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
