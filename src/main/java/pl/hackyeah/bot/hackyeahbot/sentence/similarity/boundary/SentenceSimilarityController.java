package pl.hackyeah.bot.hackyeahbot.sentence.similarity.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackyeah.bot.hackyeahbot.sentence.similarity.control.SentenceSimilarityService;
import pl.hackyeah.bot.hackyeahbot.sentence.similarity.entity.SentenceSimilarityDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sentence/similarity", produces = {"application/hal+json"})
public class SentenceSimilarityController {

    private SentenceSimilarityService sentenceSimilarityService;

    private SentenceSimilarityResourceAssembler sentenceSimilarityResourceAssembler;

    @PostMapping
    public Resources<Resource<SentenceSimilarityDTO>> getSimilarSentences(@RequestBody String sentence) {
        List<SentenceSimilarityDTO> similarSentences = sentenceSimilarityService.getMostSimilarSentences(sentence);
        List<Resource<SentenceSimilarityDTO>> similarSentencesResponse = similarSentences.stream()
                .map(sentenceSimilarityResourceAssembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(similarSentencesResponse);
    }

    @Autowired
    public void setSentenceSimilarityService(SentenceSimilarityService sentenceSimilarityService) {
        this.sentenceSimilarityService = sentenceSimilarityService;
    }

    @Autowired
    public void setSentenceSimilarityResourceAssembler(SentenceSimilarityResourceAssembler sentenceSimilarityResourceAssembler) {
        this.sentenceSimilarityResourceAssembler = sentenceSimilarityResourceAssembler;
    }
}
