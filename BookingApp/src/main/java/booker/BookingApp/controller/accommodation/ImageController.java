package booker.BookingApp.controller.accommodation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
    @PostMapping("/upload-multiple")
    public ResponseEntity<String> handleMultipleFileUpload(@RequestParam("files") List<MultipartFile> files) throws IOException {
        // Process the uploaded files (save them, perform operations, etc.)
        // You can access the files using the 'files' parameter, which is a List<MultipartFile>

        // Example: Save the files to a directory
         for (MultipartFile file : files) {
             Path filePath = Paths.get("src/main/resources/images/" + file.getOriginalFilename());
             Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
         }

        return ResponseEntity.ok("Files uploaded successfully");
    }
}
