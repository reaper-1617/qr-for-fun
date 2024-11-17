package com.gerasimchuk.maksim.qrforfun.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContentService {

    private static final String[] PHRASES = new String[]{
            "Мало пива взяли",
            "Скоооолько?",
            "Эт сексизм",
            "Я из бедной семьи",
            "Нормальная у тебя валына барбос))))"
    };

    private final Set<Integer> lastUsedIndicies = new CopyOnWriteArraySet<>();


    public String generateResponse() {
        var size = PHRASES.length;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int pos;
        do {
            pos = random.nextInt(size);
        }
        while (lastUsedIndicies.contains(pos));
        lastUsedIndicies.add(pos);
        if (lastUsedIndicies.size() == PHRASES.length){
            lastUsedIndicies.clear();
        }
        return PHRASES[pos];
    }
}
