package com.trainingdataprocessor.semantics;

import com.trainingdataprocessor.tags.EncodedTags;

import java.util.List;

import static com.trainingdataprocessor.semantics.SemanticExtractionUtils.getStartIndexForPredicateExtraction;

/**
 * Created by Oliver on 10/15/2016.
 */
public class PredicateExtractorImpl implements PredicateExtractor {

    @Override
    public String extractExtendedPredicate(List<String> subSentence, List<String> encodedTags,
                                           int constantIndex, SemanticRelationConstantType constantType) {
        String extendedPredicate = "";
        int startIndex = getStartIndexForPredicateExtraction(constantIndex, encodedTags, constantType);
        for (int i = startIndex; i <= subSentence.size() - 1; i++) {
            if (i < subSentence.size() - 1)
                extendedPredicate += subSentence.get(i) + " ";
            else
                extendedPredicate += subSentence.get(i);
        }
        return extendedPredicate;
    }

    @Override
    public String extractExtendedPredicate(List<String> subSentence, List<String> encodedTags,
                                           int constantIndex, int prepositionIndex, SemanticRelationConstantType constantType) {
        String extendedPredicate = "";
        int startIndex = getStartIndexForPredicateExtraction(constantIndex, encodedTags, constantType);
        for (int i = startIndex; i < prepositionIndex; i++) {
            if (i < subSentence.size() - 1)
                extendedPredicate += subSentence.get(i) + " ";
            else
                extendedPredicate += subSentence.get(i);
        }
        return extendedPredicate;
    }

    @Override
    public String extractPrepositionPredicate(List<String> subSentence, List<String> encodedTags, int constantIndex,
                                       SemanticRelationConstantType constantType) {
        String prepositionPredicate = "";
        int startIndex = getStartIndexForPredicateExtraction(constantIndex, encodedTags, constantType);
        for (int i = startIndex; i <= subSentence.size() - 1; i++) {
            if (i < subSentence.size() - 1)
                prepositionPredicate += subSentence.get(i) + " ";
            else
                prepositionPredicate += subSentence.get(i);
        }
        return prepositionPredicate;
    }

}
