package com.jderuere;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author DERUERE Julien
 */
@Embeddable
public class LocalizedField implements Serializable {

    private Map<Locale, String> localized = new HashMap<Locale, String>();

    public LocalizedField() {
    }

    public LocalizedField(Locale locale, String field) {
        addField(locale, field);
    }

    @ElementCollection
    @CollectionTable(name="localized", joinColumns=@JoinColumn(name="id"))
    @Column(name="localized")
    public Map<Locale, String> getLocalized() {
        return localized;
    }

    public void setLocalized(Map<Locale, String> localized) {
        this.localized = localized;
    }

    public String getField(Locale locale) {
       String result = localized.get(locale);
        if (!locale.equals(Locale.ENGLISH) && result == null) {
            result = localized.get(Locale.ENGLISH);
        }
        return result;
    }

    public void addField(Locale locale, String field) {
        localized.put(locale, field);
    }
}