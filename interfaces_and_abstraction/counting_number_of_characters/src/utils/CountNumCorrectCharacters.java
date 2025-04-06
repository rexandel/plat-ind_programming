package utils;

public class CountNumCorrectCharacters {
    private String generatedSting;
    private String userString;

    public CountNumCorrectCharacters(String generatedSting, String userString) {
        setGeneratedSting(generatedSting);
        setUserString(userString);
    }

    private void setGeneratedSting(String generatedSting) {
        this.generatedSting = generatedSting;
    }

    private void setUserString(String userString) {
        this.userString = userString;
    }

    public String getGeneratedSting() {
        return generatedSting;
    }

    public String getUserString() {
        return userString;
    }
}
