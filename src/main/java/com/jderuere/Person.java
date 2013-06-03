package com.jderuere;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Locale;

/**
 * Person
 */
@Entity
public class Person extends GenericObject {

    @Embedded
    private LocalizedField jobTitle;

    public Person() {
	}

    public LocalizedField getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(LocalizedField jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle(Locale locale) {
        if (jobTitle != null)
            return jobTitle.getField(locale);
        return null;
    }

    public void setJobTitle(Locale locale, String jobTitle) {
        if (this.jobTitle != null)
            this.jobTitle.addField(locale, jobTitle);
        else
            this.jobTitle = new LocalizedField(locale, jobTitle);
    }
}
