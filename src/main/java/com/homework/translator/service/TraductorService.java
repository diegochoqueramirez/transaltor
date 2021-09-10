package com.homework.translator.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

@Service
public class TraductorService {

    public String revert(String song) {
        String[] arreglo = song.split("\r\n\r\n");
        String result = "";
        for (int i = arreglo.length - 1 ; i >= 0; i--) {
                result += arreglo[i] + "\r\n\r\n";
        }
        return result;
    }

    public String getStringFromInputStream(InputStream input) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, "UTF-8");
        return writer.toString();
    }
}
