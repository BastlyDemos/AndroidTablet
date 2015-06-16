package com.bastly.midigrid.models;

/**
 * Created by goofyahead on 16/06/15.
 */
public class Sound {
    private String instrument;
    private String note;

    public Sound(String instrument, String note) {
        this.instrument = instrument;
        this.note = note;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
