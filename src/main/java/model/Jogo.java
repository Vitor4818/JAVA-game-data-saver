package model;

public class Jogo {
    private String name;          // Nome do jogo
    private String released;      // Data de lançamento
    private String description_raw;   // Descrição do jogo
    private double metacritic;       // Pontuação no Metacritic

    public Jogo(String name, double metacritic, String description_raw, String released) {
        this.name = name;
        this.metacritic = metacritic;
        this.description_raw = description_raw;
        this.released = released;
    }


    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getDescription() {
        return description_raw;
    }

    public void setDescription(String description) {
        this.description_raw = description;
    }

    public double getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "name='" + name + '\'' +
                ", released='" + released + '\'' +
                ", description='" + description_raw + '\'' +
                ", metacritic=" + metacritic +
                '}';
    }
}
