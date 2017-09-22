package com.londonappbrewery.destini;

/**
 * Created by omaru on 20/09/17.
 */

public class Answer {
    private Story story;
    private int id;

    public Answer(int id,Story story){
        this.story = story;
        this.id = id;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

