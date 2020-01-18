package com.godson.kekbot.responses;

import net.dv8tion.jda.api.entities.User;

public class ResponseSuggestion {
    private String suggesterID;
    private String actionName;
    private String suggestedResponse;

    public ResponseSuggestion(User suggester, Action action, String response) {
        suggesterID = suggester.getId();
        actionName = action.name();
        suggestedResponse = response;
    }

    public String getSuggesterID() {
        return suggesterID;
    }

    public String getActionName() {
        return actionName;
    }

    public String getSuggestedResponse() {
        return suggestedResponse;
    }
}
