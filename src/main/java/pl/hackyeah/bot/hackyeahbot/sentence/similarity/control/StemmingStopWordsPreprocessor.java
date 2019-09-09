package pl.hackyeah.bot.hackyeahbot.sentence.similarity.control;

import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.tartarus.snowball.ext.PorterStemmer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * based on raver119@gmail.com StemmingPreprocessor
 */
public class StemmingStopWordsPreprocessor extends CommonPreprocessor {

    private static final String STOP_WORDS_FILE_NAME = "stopWords.txt";

    private List<String> stopWords;

    public StemmingStopWordsPreprocessor() throws IOException {
        this.stopWords = Files.readAllLines(Paths.get(STOP_WORDS_FILE_NAME));
    }

    @Override
    public String preProcess(String token) {
        String preProcessedToken = super.preProcess(token);

        boolean stopWordFound = isStopWord(token);

        if(stopWordFound) {
            return "";
        }

        PorterStemmer stemmer = new PorterStemmer();
        stemmer.setCurrent(preProcessedToken);
        stemmer.stem();
        return stemmer.getCurrent();
    }

    private boolean isStopWord(String token) {
        return stopWords.contains(token);
    }
}