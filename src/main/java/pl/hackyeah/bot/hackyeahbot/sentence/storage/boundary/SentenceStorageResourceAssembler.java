package pl.hackyeah.bot.hackyeahbot.sentence.storage.boundary;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;


@Component
public class SentenceStorageResourceAssembler implements ResourceAssembler<Sentence, Resource<Sentence>> {

    @Override
    public Resource<Sentence> toResource(Sentence sentence) {
        return new Resource<>(sentence);
    }
}
