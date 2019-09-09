package pl.hackyeah.bot.hackyeahbot.sentence.storage.control;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

public interface SentenceStorageRepository extends JpaRepository<Sentence, Long> {
}
