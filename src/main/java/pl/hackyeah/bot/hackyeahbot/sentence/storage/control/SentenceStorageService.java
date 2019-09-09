package pl.hackyeah.bot.hackyeahbot.sentence.storage.control;

import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.util.List;

public interface SentenceStorageService {

    List<Sentence> getAllSentences();

    Sentence createSentence(Sentence sentence);
}
