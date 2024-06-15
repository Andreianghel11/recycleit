package com.project.recycleit.services;

import com.project.recycleit.dtos.WasteItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.Map;

@Service
public class PredictionService {
    @Autowired
    private WasteItemService wasteItemService;

    @Autowired
    private UserAchievementService userAchievementService;

    @Autowired
    private UserService userService;

    public WasteItemDto predictImage(Map<String, String> payload) {
        String imageData = payload.get("image");

        byte[] imageBytes = Base64.getDecoder().decode(imageData.split(",")[1]);

        // Save the image to disk
        try {
            File outputFile = new File("uploads/image.png");
            outputFile.getParentFile().mkdirs(); // Create directories if they don't exist
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(imageBytes);
            }
            // Process the image and return the class
            String result = runPythonScriptInWsl();

            // Should update the achievements for the current user
            // based on the result
            userAchievementService.updateUserAchievementsForWasteItem(result);

            // Should increment itemsScanned for the current user
            userService.incrementScannedItemsForUser(result);

            return wasteItemService.getWasteItemByName(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String runPythonScriptInWsl() {
        String result = "";
        try {
            System.out.println("Running Python script");
            System.out.println(System.getProperty("user.dir"));
            ProcessBuilder builder = new ProcessBuilder("wsl.exe", "python3", "uploads/predictImage.py", "uploads/image.png");
            builder.redirectErrorStream(true);
            Process process = builder.start();

            // Read the output from the command
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line + "\n";
                }
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            result = "Error running Python script: " + e.getMessage();
        }

        //Read the result

        File file = new File("result.txt");

        // Check if the file exists
        if (file.exists() && !file.isDirectory()) {
            // File exists, read its content
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder fileContent = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    fileContent.append(line);
                }
                System.out.println("Result: " + fileContent.toString());
                return fileContent.toString();
            } catch (IOException e) {
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            // File does not exist
            System.out.println("The file result.txt does not exist.");
        }
        return "Error processing image";
    }
}
