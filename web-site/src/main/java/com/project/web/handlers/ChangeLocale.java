package com.project.web.handlers;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "changeLocale")
@RequestScoped
public class ChangeLocale {

    private final FacesContext context;
    private final ExternalContext ex;

    private String languageCode;
    private String english = "en";
    private String russian = "ru";
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
            // System.out.println("viewId " + viewId);
            redirectAfterChangeLocale();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void changeLocaleToEn() {
        try {
            context.getViewRoot().setLocale(new Locale(english));
            ex.getSessionMap().put("localeCode", english);
            String viewId = context.getViewRoot().getViewId();
            // System.out.println("viewId " + viewId);
            redirectAfterChangeLocale();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void changeLocaleToRu() {
        try {
            ex.getSessionMap().put("localeCode", russian);
            context.getViewRoot().setLocale(new Locale(russian));
            String viewId = context.getViewRoot().getViewId();
            //System.out.println("viewId " + viewId);
            redirectAfterChangeLocale();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void redirectAfterChangeLocale() {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ChangeLocale.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public String getArmenian() {
        return armenian;
    }

    public void setArmenian(String armenian) {
        this.armenian = armenian;
    }

}
