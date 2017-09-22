package com.londonappbrewery.destini;

import java.io.Serializable;

/**
 * Created by omaru on 20/09/17.
 */

public class Story implements Serializable {
    private int id;
    private Answer top;
    private Answer bottom;
    public Story(int id){
        this.id = id;
    }
    public Story(int id,Answer top,Answer bottom){
        this.id = id;
        this.top = top;
        this.bottom = bottom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer getTop() {
        return top;
    }

    public void setTop(Answer top) {
        this.top = top;
    }

    public Answer getBottom() {
        return bottom;
    }

    public void setBottom(Answer bottom) {
        this.bottom = bottom;
    }


}
