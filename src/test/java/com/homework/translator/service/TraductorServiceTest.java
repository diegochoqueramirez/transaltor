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
        String original = "src/main/java/com/homework/translator/Original.txt";
        String estrofasEnOrdenamiento = "src/main/java/com/homework/translator/estrofasEnOrdenInverso.txt";

        File order = new File(estrofasEnOrdenamiento);
        OutputStream outStanzas = new FileOutputStream(order);

        String originalFile = traductorService.getStringFromInputStream(new FileInputStream(original));
        StreamUtils.copy(traductorService.revert(originalFile), StandardCharsets.UTF_8, outStanzas);
    }

    @Test
    void saveStatistics() throws IOException {
        String estrofasEnOrdenamiento = "src/main/java/com/homework/translator/estrofasEnOrdenInverso.txt";
        String statistics = "src/main/java/com/homework/translator/statistics.txt";

        File count = new File(statistics);
        OutputStream outStatistic = new FileOutputStream(count);

        String estrofasOrdenadas = traductorService.getStringFromInputStream(new FileInputStream(estrofasEnOrdenamiento));
        StreamUtils.copy(traductorService.count(estrofasOrdenadas), StandardCharsets.UTF_8, outStatistic);

    }

    @Test
    void saveOutputFile() throws IOException {
        String estrofasEnOrdenamiento = "src/main/java/com/homework/translator/estrofasEnOrdenInverso.txt";
        String finalOutput = "src/main/java/com/homework/translator/finaloutput.txt";

        File output = new File(finalOutput);
        OutputStream outFinal = new FileOutputStream(output);

        String estrofasOrdenadas = traductorService.getStringFromInputStream(new FileInputStream(estrofasEnOrdenamiento));
        StreamUtils.copy(traductorService.replace(estrofasOrdenadas), StandardCharsets.UTF_8, outFinal);
    }


}