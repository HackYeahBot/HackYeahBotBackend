package pl.hackyeah.bot.hackyeahbot.sentence.storage.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.util.List;

@Service
public class SentenceStorageServiceImplementation implements SentenceStorageService {

    private SentenceRepository sentenceRepository;

    @Override
    public List<Sentence> getAllSentences() {
        return sentenceRepository.findAll();
    }

    @Override
    public Sentence createSentence(Sentence sentence) {
        return sentenceRepository.save(sentence);
    }

    @Autowired
    public void setSentenceRepository(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }
}
