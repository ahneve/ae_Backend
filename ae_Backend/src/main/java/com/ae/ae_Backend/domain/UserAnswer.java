package com.ae.ae_Backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class UserAnswer {
    @Id
    @GeneratedValue
    @Column(name = "user_answer_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "storycard_id")
    private StoryCard storycard;

    private String answer;

    public static UserAnswer createUserAnswer(User user, StoryCard storyCard, String answer) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setStorycard(storyCard);
        userAnswer.setAnswer(answer);
        return userAnswer;
    }
}
