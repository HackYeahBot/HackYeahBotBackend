package pl.hackyeah.bot.hackyeahbot.sentence.storage.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.control.SentenceStorageService;
import pl.hackyeah.bot.hackyeahbot.sentence.storage.entity.Sentence;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/sentence", produces = {"application/hal+json"})
public class SentenceStorageController {

    private SentenceStorageService sentenceService;

    private SentenceStorageResourceAssembler sentenceResourceAssembler;

    @GetMapping
    public Resources<Resource<Sentence>> getAllSentences() {
        List<Sentence> sentences = sentenceService.getAllSentences();
        List<Resource<Sentence>> sentencesResponse = sentences.stream()
                .map(sentenceResourceAssembler::toResource)
                .collect(Collectors.toList());

        Link selfLink = linkTo(SentenceStorageController.class).withSelfRel();
        return new Resources<>(sentencesResponse, selfLink);
    }

    @PostMapping
    public Resource<Sentence> createSentence(@RequestBody Sentence sentence) {
        Sentence createdSentence = sentenceService.createSentence(sentence);
        return sentenceResourceAssembler.toResource(createdSentence);
    }

    @Autowired
    public void setSentenceService(SentenceStorageService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @Autowired
    public void setSentenceResourceAssembler(SentenceStorageResourceAssembler sentenceResourceAssembler) {
        this.sentenceResourceAssembler = sentenceResourceAssembler;
    }
}
