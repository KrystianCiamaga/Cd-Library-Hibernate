import lombok.Getter;

@Getter
public enum Genre {

ROCK("Rock"),
    HIPHOP("Hip hop"),
    ELECTRO("Electro"),
    REGGAE("Reggae");

    private String description;

    Genre(String description) {
        this.description = description;
    }

}
