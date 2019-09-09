package pl.hackyeah.bot.hackyeahbot.sentence.storage.entity;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sentences")
public class Sentence {

    @Id
    @GeneratedValue(generator = "sentence_generator")
    @SequenceGenerator(
            name = "sentence_generator",
            sequenceName = "sentence_sequence"
    )
    private Long id;

    @NotBlank
    @NaturalId
    @Column(unique = true)
    private String sentenceContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentenceContent() {
        return sentenceContent;
    }

    public void setSentenceContent(String sentenceContent) {
        this.sentenceContent = sentenceContent;
    }
}
