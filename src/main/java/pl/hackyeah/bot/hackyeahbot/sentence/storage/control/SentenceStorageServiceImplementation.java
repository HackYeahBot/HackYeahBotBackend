package pl.hackyeah.bot.hackyeahbot.sentence.storage.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.util.List;

@Service
public class SentenceStorageServiceImplementation implements SentenceStorageService {

    private SentenceStorageRepository sentenceStorageRepository;

    @Override
    public List<Sentence> getAllSentences() {
        return sentenceStorageRepository.findAll();
    }

    @Override
    public Sentence createSentence(Sentence sentence) {
        return sentenceStorageRepository.save(sentence);
    }

    @Autowired
    public void setSentenceStorageRepository(SentenceStorageRepository sentenceStorageRepository) {
        this.sentenceStorageRepository = sentenceStorageRepository;
    }
}
