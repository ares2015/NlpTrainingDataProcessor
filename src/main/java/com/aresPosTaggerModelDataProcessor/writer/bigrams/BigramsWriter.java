package com.aresPosTaggerModelDataProcessor.writer.bigrams;

import com.aresPosTaggerModelDataProcessor.data.syntax.BigramData;

import java.util.List;

/**
 * Created by Oliver on 2/7/2017.
 */
public interface BigramsWriter {

    void write(List<BigramData> bigramDataList);

}
