package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class PrintSimulator {
    private int countOfCorrectCharacters;
    private double percentOfCorrectCharacters;
    private String generatedSting;
    private String userString;
    private String correctCharacters;

    public PrintSimulator(String generatedSting, String userString) {
        setGeneratedSting(generatedSting);
        setUserString(userString);
        setCountOfCorrectCharacters(calculateCountOfCorrectCharacters());
        setPercentOfCorrectCharacters(calculatePercentOfCorrectCharacters());
        setCorrectCharacters(findCorrectCharacters());
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

    public void setPercentOfCorrectCharacters(double percentOfCorrectCharacters) {
        if (percentOfCorrectCharacters < 0) {
            throw new IllegalArgumentException("Percent cannot be less than zero.");
        }
        this.percentOfCorrectCharacters = percentOfCorrectCharacters;
    }

    private void setCorrectCharacters(String correctCharacters) {
        this.correctCharacters = correctCharacters;
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

    public double getPercentOfCorrectCharacters() {
        return percentOfCorrectCharacters;
    }

    public String getCorrectCharacters() {
        return correctCharacters;
    }

    public int calculateCountOfCorrectCharacters() {
        int countOfCorrectCharacters = 0;
        List<Character> generatedList = new ArrayList<>();
        List<Character> userList = new ArrayList<>();

        for (char c : getGeneratedSting().toCharArray()) {
            generatedList.add(c);
        }
        for (char c : getUserString().toCharArray()) {
            userList.add(c);
        }

        for (int index = 0; index < Math.min(generatedList.size(), userList.size()); index++) {
            if (generatedList.get(index).equals(userList.get(index))) {
                countOfCorrectCharacters++;
            }
        }

        return countOfCorrectCharacters;
    }

    public double calculatePercentOfCorrectCharacters() {
        return ((double) getCountOfCorrectCharacters() / getGeneratedSting().length()) * 100;
    }

    public String findCorrectCharacters() {
        StringBuilder correctChars = new StringBuilder();
        List<Character> generatedList = new ArrayList<>();
        List<Character> userList = new ArrayList<>();

        for (char c : getGeneratedSting().toCharArray()) {
            generatedList.add(c);
        }
        for (char c : getUserString().toCharArray()) {
            userList.add(c);
        }

        for (int index = 0; index < Math.min(generatedList.size(), userList.size()); index++) {
            if (generatedList.get(index).equals(userList.get(index))) {
                correctChars.append(generatedList.get(index));
            }
        }

        return correctChars.toString();
    }

    @Override
    public String toString() {
        return
                "Generated string: " + getGeneratedSting() + "\n" +
                        "Your string: " + getUserString() + "\n" +
                        "Count of correct characters: " + getCountOfCorrectCharacters() + "\n" +
                        "Percent of correct characters: " + String.format("%.2f",  getPercentOfCorrectCharacters()) + "%" + "\n" +
                        "Correct characters: " + getCorrectCharacters();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintSimulator that = (PrintSimulator) o;
        return countOfCorrectCharacters == that.countOfCorrectCharacters && Objects.equals(generatedSting, that.generatedSting) && Objects.equals(userString, that.userString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfCorrectCharacters, generatedSting, userString);
    }
}
