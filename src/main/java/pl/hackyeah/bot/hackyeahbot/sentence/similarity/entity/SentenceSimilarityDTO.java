package pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class SentenceSimilarityDTO implements Comparable<SentenceSimilarityDTO> {

    @NotBlank
    private String sentence;

    @NotBlank
    private double similarity;

    public SentenceSimilarityDTO(@NotBlank String sentence, @NotBlank double similarity) {
        this.sentence = sentence;
        this.similarity = similarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SentenceSimilarityDTO that = (SentenceSimilarityDTO) o;
        return that.similarity == similarity && that.sentence.equals(sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, similarity);
    }

    @Override
    public int compareTo(SentenceSimilarityDTO o) {
        Double difference = this.similarity - o.similarity;
        return difference.intValue();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
}
