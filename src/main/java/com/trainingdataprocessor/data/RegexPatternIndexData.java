package com.trainingdataprocessor.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliver on 8/17/2016.
 */
public class RegexPatternIndexData {

    private String pattern;

    private int startIndex;

    private int endIndex;

    public RegexPatternIndexData(String pattern, int startIndex, int endIndex) {
        this.pattern = pattern;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public String getPattern() {
        return pattern;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

}