package com.homework.translator.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class TraductorService {

    public String getStringFromInputStream(InputStream input) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, "UTF-8");
        return writer.toString();
    }

    public String revert(String song) {
        String[] words = song.split("\r\n\r\n");
        String result = "";
        for (int i = words.length - 1 ; i >= 0; i--) {
                result += words[i] + "\r\n\r\n";
        }
        return result;
    }

    public String count(String song) {
        Map<String, Integer> ocurrences = new HashMap<String,Integer>();
        String[] stanzas = song.split("\r\n\r\n");
        String[] words = song.split("[\\s,]+");

        for (String word : words) {
            if (ocurrences.containsKey(word)) {
                ocurrences.put(word, ocurrences.get(word)+1);
            } else {
                ocurrences.put(word, 1);
            }
        }

//        for (Map.Entry<String, Integer> entry : ocurrences.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }

        Integer value = ocurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getValue();
        String key = ocurrences.entrySet().stream().max((entry1, entry2) -> entry1.getValue() - entry2.getValue()).get().getKey();
        return "El numero de estrofas es "+ stanzas.length + "\n" + "La palabra que mas se repite es " + key + " con " + value + " veces";
    }

    public String replace(String song) {
        String result = song.replace("beggin'", "you");
        return result;
    }
}
