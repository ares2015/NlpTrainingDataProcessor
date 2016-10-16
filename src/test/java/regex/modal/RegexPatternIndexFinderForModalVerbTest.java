package regex.modal;

import com.trainingdataprocessor.data.RegexPatternIndexData;
import com.trainingdataprocessor.regex.RegexPatternIndexFinder;
import com.trainingdataprocessor.regex.RegexPatternIndexFinderImpl;
import org.junit.Test;

import java.util.List;

import static com.trainingdataprocessor.regex.RegexExpressions.*;
import static com.trainingdataprocessor.regex.RegexExpressions.NOUN_VERB_DO_NOT_RELATION_PATTERN;
import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 10/11/2016.
 */
public class RegexPatternIndexFinderForModalVerbTest {

    private RegexPatternIndexFinder regexPatternIndexFinder = new RegexPatternIndexFinderImpl();

    @Test
    public void testFindNounModalVerbNounRelationWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "John can speak Spanish";
        encodedPath = "NMVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John can speak Spanish fluently";
        encodedPath = "NMVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John can fluently speak Spanish";
        encodedPath = "NMVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

    }

    @Test
    public void testFindNounModalVerbNounNoPatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "John can speak";
        encodedPath = "NMV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John speaks Spanish fluently";
        encodedPath = "NVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John fluently speaks Spanish";
        encodedPath = "NAVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());
    }


    @Test
    public void testFindNounModalNotVerbNounWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        //John can speak Spanish
        sentence = "John can not speak Spanish";
        encodedPath = "NMOVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        //John can speak Spanish fluently
        sentence = "John can not speak Spanish fluently";
        encodedPath = "NMOVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        //John can speak Spanish fluently
        sentence = "John can not fluently speak Spanish";
        encodedPath = "NMOVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }


    @Test
    public void testFindNounModalVerbRelationWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "gray wolf can eat";
        encodedPath = "JNMV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "boys can play at school";
        encodedPath = "NMVPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "Fans of Russia could celebrate at European Championships";
        encodedPath = "NPNMVPNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "gray wolf can't eat";
        encodedPath = "JNMV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "boys can't play at school";
        encodedPath = "NMVPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "Fans of Russia couldn't celebrate at European Championships";
        encodedPath = "NPNMVPNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }

    @Test
    public void testFindNounModalVerbNotRelationWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "gray wolf can not eat";
        encodedPath = "JNMOV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "boys can not play at school";
        encodedPath = "NMOVPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "Fans of Russia could not celebrate at European Championships";
        encodedPath = "NPNMOVPNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_MODAL_VERB_NOT_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }

}
