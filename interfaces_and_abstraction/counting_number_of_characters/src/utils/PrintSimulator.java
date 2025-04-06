package utils;

public class PrintSimulator {
    private int countOfCorrectCharacters;
    private String generatedSting;
    private String userString;

    public PrintSimulator(String generatedSting, String userString) {
        setGeneratedSting(generatedSting);
        setUserString(userString);
    }

    public void setCountOfCorrectCharacters(int countOfCorrectCharacters) {
        if (countOfCorrectCharacters < 0) {
            throw new IllegalArgumentException("Count cannot be less than zero.");
        }
        this.countOfCorrectCharacters = countOfCorrectCharacters;
    }

    private void setGeneratedSting(String generatedSting) {
        if (generatedSting == null) {
            throw new IllegalArgumentException("Generated string cannot be null.");
        }
        this.generatedSting = generatedSting;
    }

    private void setUserString(String userString) {
        if (userString == null) {
            throw new IllegalArgumentException("User string cannot be null.");
        }
        this.userString = userString;
    }

    public int getCountOfCorrectCharacters() {
        return countOfCorrectCharacters;
    }

    public String getGeneratedSting() {
        return generatedSting;
    }

    public String getUserString() {
        return userString;
    }

    public void calculateCountOfCorrectCharacters() {
        int countOfCorrectCharacters = 0;

        char[] generatedArray = getGeneratedSting().toCharArray();
        char[] userArray = getUserString().toCharArray();

        for (int index = 0; index < Math.min(getGeneratedSting().length(), getUserString().length()); index++) {
            if (generatedArray[index] == userArray[index]) {
                countOfCorrectCharacters += 1;
            }
        }
        if ((getGeneratedSting().length() - getUserString().length()) != 0) {
            countOfCorrectCharacters -= Math.abs(getGeneratedSting().length() - getUserString().length());
        }

        setCountOfCorrectCharacters(countOfCorrectCharacters);
    }
}
