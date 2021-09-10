package com.homework.translator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.*;
@SpringBootTest
public class TraductorServiceTest {

    @Autowired
    private TraductorService traductorService;

    @Test
    void revertSong() throws IOException {
        String inputFileName = "src/main/java/com/homework/translator/Original.txt";
        String outputFileName = "src/main/java/com/homework/translator/estrofasEnOrdenInverso.txt";
        File outputFile = new File(outputFileName);
        InputStream in = new FileInputStream(inputFileName);
        OutputStream out = new FileOutputStream(outputFile);

        String inputFileContent = traductorService.getStringFromInputStream(new FileInputStream(inputFileName));
        StreamUtils.copy(traductorService.revert(inputFileContent), StandardCharsets.UTF_8,out);
    }
}