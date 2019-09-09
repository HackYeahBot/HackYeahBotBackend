package pl.hackyeah.bot.hackyeahbot.sentence.similarity.control;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.paragraphvectors.ParagraphVectors;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity.SentenceSimilarityDTO;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.control.SentenceStorageService;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentenceSimilarityServiceImplementation implements SentenceSimilarityService {

    private static final String MODEL_FILE_NAME = "outputTwcs3.pv";
    private static final double MINIMAL_SIMILARITY_THRESHOLD = 0.1;
    private static final int DEFAULT_MAX_SIMILAR_SENTENCES_COUNT = 5;

    //TODO: use guava cache for loading all sentences from database?
    private SentenceStorageService sentenceStorageService;

    private ParagraphVectors vectors;

    public SentenceSimilarityServiceImplementation() throws IOException {
        vectors = loadParagraphVectors();
    }

    private ParagraphVectors loadParagraphVectors() throws IOException {
        ParagraphVectors vectorsToLoad = WordVectorSerializer.readParagraphVectors(MODEL_FILE_NAME);
        TokenizerFactory tokenizerFactory = createAndConfigureTokenizerFactory();
        vectorsToLoad.setTokenizerFactory(tokenizerFactory);

        return vectorsToLoad;
    }

    @Override
    public List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence) {
        return getMostSimilarSentences(sentence, DEFAULT_MAX_SIMILAR_SENTENCES_COUNT);
    }

    @Override
    public List<SentenceSimilarityDTO> getMostSimilarSentences(String sentence, int maxSentencesCount) {
        List<SentenceSimilarityDTO> mostSimilarSentences = getSimilarityWithSentencePatterns(sentence, maxSentencesCount);

        return mostSimilarSentences;

    }

    private List<SentenceSimilarityDTO> getSimilarityWithSentencePatterns(String sentence, int maxSentencesCount) {
        INDArray sentenceVector = vectors.inferVector(sentence);
        List<Sentence> sentencesInDatabase = sentenceStorageService.getAllSentences();
        List<SentenceSimilarityDTO> similarities =  sentencesInDatabase.stream()
                .map(Sentence::getSentenceContent)
                .map(sentenceToMatch -> mapSimilarityToSentenceVector(sentenceToMatch, sentenceVector))
                .filter(sentenceSimilarity -> sentenceSimilarity.getSimilarity() > MINIMAL_SIMILARITY_THRESHOLD)
                .sorted()
                .limit(maxSentencesCount)
                .collect(Collectors.toList());

        return similarities;
    }

    private SentenceSimilarityDTO mapSimilarityToSentenceVector(String sentence, INDArray sentenceVector) {
        INDArray sentenceToCompare = getSentenceVector(sentence);
        double similarity = Transforms.cosineSim(sentenceToCompare, sentenceVector);
        SentenceSimilarityDTO sentenceSimilarityDTO = new SentenceSimilarityDTO(sentence, similarity);

        return sentenceSimilarityDTO;
    }

    private INDArray getSentenceVector(String sentence) {
        return vectors.inferVector(sentence);
    }

    private TokenizerFactory createAndConfigureTokenizerFactory() throws IOException {
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        tokenizerFactory.setTokenPreProcessor(new StemmingStopWordsPreprocessor());

        return tokenizerFactory;
    }

    @Autowired
    public void setSentenceStorageService(SentenceStorageService sentenceStorageService) {
        this.sentenceStorageService = sentenceStorageService;
    }
}
