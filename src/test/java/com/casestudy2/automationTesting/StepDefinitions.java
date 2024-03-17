package com.casestudy2.automationTesting;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.lines;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    @Given("{string} and {string} are present")
    public void filesArePresent(String fileName1, String fileName2) {
        File file1 = new File("src/main/resources/" + fileName1);
        File file2 = new File("src/main/resources/" + fileName2);

        assertThat(file1.exists() && file2.exists()).isTrue();
    }

    @Then("Check whether {string} and {string} has same number of lines")
    public void checkWhetherFilesHasSameNumberOfLines(String fileName1, String fileName2) throws IOException {
        long lineCountOfFile1 = lines(Paths.get("src/main/resources/" + fileName1)).count();
        long lineCountOfFile2 = lines(Paths.get("src/main/resources/" + fileName2)).count();
        assertThat(lineCountOfFile1).isEqualTo(lineCountOfFile2);
    }

    @Then("Check whether all lines in {string} and {string} are same")
    public void checkWhetherAllLinesAreSame(String fileName1, String fileName2) {
        List<String[]> fileData1 = new ArrayList<>();
        List<String[]> fileData2 = new ArrayList<>();

        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/" + fileName1));
            fileData1 = csvReader.readAll();

            csvReader = new CSVReader(new FileReader("src/main/resources/" + fileName2));
            fileData2 = csvReader.readAll();
        } catch(IOException | CsvException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < fileData1.size(); i++) {
            assertThat(fileData1.get(i)[0]).isEqualTo(fileData2.get(i)[0]);
        }
    }
}
