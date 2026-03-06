package pro1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        Path outputDirPath = Paths.get(userDir, "output");
        Files.createDirectories(outputDirPath);
        Path inputDirPath = Paths.get(userDir, "input");
        File[] files = inputDirPath.toFile().listFiles();

        assert files != null;
        for (File f : files) {

            Path inputFilePath = Paths.get(userDir, "input", f.getName());
            Path outputFilePath = Paths.get(userDir, "output", f.getName());

            List<String> lines = Files.readAllLines(inputFilePath);
            List<String> newLines = new ArrayList<>();

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] split = line.split("[:=;]");
                if (split.length < 2) {continue;}
                String name = split[0].trim();
                String rating = split[1].trim();
                Fraction fraction = Fraction.parse(rating);
                ExamRecord examRecord = new ExamRecord(name, fraction);
                String formatedFraction = examRecord.getScore().toString().replaceAll(" ","");
                String newLine = examRecord.getPersonId() + "," + formatedFraction;
                newLines.add(newLine);

            }

            Files.write(outputFilePath, newLines);

        }
    }
}
