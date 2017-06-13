package com.project.web.handlers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class ChangeLocale implements Serializable {

    private final FacesContext context;
    private final ExternalContext ex;

    @Setter
    @Getter
    private String languageCode;
    @Setter
    @Getter
    private String english = "en";
    @Setter
    @Getter
    private String russian = "ru";
    @Setter
    @Getter
    private String armenian = "hy";

    public ChangeLocale() {
        context = FacesContext.getCurrentInstance();
        ex = context.getExternalContext();

    }

    public void changeLocaleToAm() {
        try {
            context.getViewRoot().setLocale(new Locale(armenian));
            ex.getSessionMap().put("localeCode", armenian);
            String viewId = context.getViewRoot().getViewId();
            redirectAfterChangeLocale();
        } catch (Exception e) {
        }
    }

    public void changeLocaleToEn() {
        try {
            context.getViewRoot().setLocale(new Locale(english));
            ex.getSessionMap().put("localeCode", english);
            String viewId = context.getViewRoot().getViewId();
            redirectAfterChangeLocale();
        } catch (Exception e) {
        }

    }

    public void changeLocaleToRu() {
        try {
            ex.getSessionMap().put("localeCode", russian);
            context.getViewRoot().setLocale(new Locale(russian));
            String viewId = context.getViewRoot().getViewId();
            redirectAfterChangeLocale();
        } catch (Exception e) {

        }
    }

    public void redirectAfterChangeLocale() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ChangeLocale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
