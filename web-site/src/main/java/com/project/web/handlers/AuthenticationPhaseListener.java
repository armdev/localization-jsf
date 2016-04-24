package com.project.web.handlers;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthenticationPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;
   
    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public synchronized void beforePhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        ExternalContext ex = context.getExternalContext();
        try {


            String localeCode = (String) ex.getSessionMap().get("localeCode");

            if (localeCode != null) {
                ex.getSessionMap().put("localeCode", localeCode);
                context.getViewRoot().setLocale(new Locale(localeCode));
            }

        } catch (Exception ex1) {
         
           // ex1.printStackTrace();
        }
    }

    private static void redirect(FacesContext facesContext, String url) {
        try {
            facesContext.getExternalContext().redirect(url);
        } catch (IOException e) {
           // throw new FacesException("Cannot redirect to " + url + " due to IO exception.", e);
        }
    }

   

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
