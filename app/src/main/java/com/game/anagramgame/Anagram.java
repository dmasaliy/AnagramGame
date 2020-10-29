package com.game.anagramgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Anagram {

    public static final Random random = new Random();

    public static final String[] CRISTMAS = {"angel", "tree", "bells", "candy", "garlend",
            "happy", "holiday", "decorations"};

   public static Map<String, String> answer = new HashMap<>();

    public static void zapAnagram(){
        for (int i =0; i<CRISTMAS.length; i++) {
            answer.put(CRISTMAS[i], schuffleW(CRISTMAS[i]));
        }
    }

    public static String randomW() {
        return CRISTMAS[random.nextInt(CRISTMAS.length)];
    }

    public static String schuffleW(String w) {
        if (w != null && !"".equals(w)) {
            char a[] = w.toCharArray();

            for(int i = 0; i < a.length; i++){
                int j = random.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }
        return w;
    }


}
