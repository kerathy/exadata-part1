package com.example.mvvmpatternretrofitpractice.util;

import java.util.List;

public class Util {

    public String StringJoin(List<String> authors, String concatenation) {
        StringBuilder res = new StringBuilder();
        for (String author : authors) {
            res.append(author).append(concatenation);
        }
        return res.toString();
    }
}
