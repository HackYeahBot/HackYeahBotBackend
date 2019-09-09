package pl.hackyeah.bot.hackyeahbot.sentence.similarity.boundary;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity.SentenceSimilarityDTO;


@Component
public class SentenceSimilarityResourceAssembler implements ResourceAssembler<SentenceSimilarityDTO, Resource<SentenceSimilarityDTO>> {

    @Override
    public Resource<SentenceSimilarityDTO> toResource(SentenceSimilarityDTO sentenceSimilarity) {
        return new Resource<>(sentenceSimilarity);
    }
}
