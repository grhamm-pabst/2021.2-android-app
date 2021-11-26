package br.ucsal.grhamm.githubrepos.model;

public class Repo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Repo() {
    }

    public Repo(String name, String description, int stargazers_count, String language) {
        this.name = name;
        this.description = description;
        this.stargazers_count = stargazers_count;
        this.language = language;
    }

    private String name;
    private String description;
    private int stargazers_count;
    private String language;
}
