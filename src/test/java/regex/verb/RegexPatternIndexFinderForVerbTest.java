package regex.verb;

import com.trainingdataprocessor.data.RegexPatternIndexData;
import com.trainingdataprocessor.regex.RegexPatternIndexFinder;
import com.trainingdataprocessor.regex.RegexPatternIndexFinderImpl;
import org.junit.Test;

import java.util.List;

import static com.trainingdataprocessor.regex.RegexExpressions.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Oliver on 10/11/2016.
 */
public class RegexPatternIndexFinderForVerbTest {

    private RegexPatternIndexFinder regexPatternIndexFinder = new RegexPatternIndexFinderImpl();

    @Test
    public void testFindNounVerbNounRelationWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "gray wolf eats meat";
        encodedPath = "JNVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "boys play football at school";
        encodedPath = "NVNPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "Fans of Russia attacked English fans at European Championships";
        encodedPath = "NPN$NNPNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }

    @Test
    public void testFindNounVerbNounRelationPartialPatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "gray wolf eats meat and vegetables";
        encodedPath = "JNVN>N";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals("JNVN", regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "boys and girls play football at school";
        encodedPath = "N>NVNPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals("NVNPN", regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "Fans of Russia attacked English fans and players at European Championships";
        encodedPath = "NPN$NN>NPNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals("NPN$NN", regexPatternIndexFinderList.get(0).getPattern());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }

    @Test
    public void testFindNounVerbNounRelationNoPatternFound(){
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "John speaks";
        encodedPath = "NV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());


        sentence = "John can speak Spanish";
        encodedPath = "NMVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John can speak Spanish fluently";
        encodedPath = "NMVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John can fluently speak Spanish";
        encodedPath = "NMVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John don't speak Spanish";
        encodedPath = "NLVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John don't speak Spanish fluently";
        encodedPath = "NLVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John don't fluently speak Spanish";
        encodedPath = "NLVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John does not speak Spanish";
        encodedPath = "NLOVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John does not speak Spanish fluently";
        encodedPath = "NLOVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "John does not fluently speak Spanish";
        encodedPath = "NLOVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());
    }

    @Test
    public void testFindNounVerbDontNounRelationWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "John don't speak Spanish";
        encodedPath = "NLVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John don't speak Spanish fluently";
        encodedPath = "NLVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John don't fluently speak Spanish";
        encodedPath = "NLVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

    }

    @Test
    public void testFindNounVerbDontNounRelationNoPatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "gray wolf eats";
        encodedPath = "JNV";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());


        sentence = "boys play at school";
        encodedPath = "NVPN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());

        sentence = "Fans of Russia celebrated at European Championships";
        encodedPath = "NPN$PNN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DONT_NOUN_RELATION_PATTERN);
        assertEquals(0, regexPatternIndexFinderList.size());
    }

    @Test
    public void testFindVerbDoNotRelationshipWholePatternFound() {
        String sentence = "";
        List<RegexPatternIndexData> regexPatternIndexFinderList = null;
        String encodedPath = null;

        sentence = "John does not speak Spanish";
        encodedPath = "NLOVN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DO_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John does not speak Spanish fluently";
        encodedPath = "NLOVNA";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DO_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());

        sentence = "John does not fluently speak Spanish";
        encodedPath = "NLOVAN";
        regexPatternIndexFinderList = regexPatternIndexFinder.find(encodedPath, NOUN_VERB_DO_NOT_NOUN_RELATION_PATTERN);
        assertEquals(1, regexPatternIndexFinderList.size());
        assertEquals(encodedPath, regexPatternIndexFinderList.get(0).getPattern());
        assertEquals(sentence.split("\\ ").length, encodedPath.length());
        System.out.println(sentence + ": " + regexPatternIndexFinderList.get(0).getPattern());
    }


}