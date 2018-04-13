package Library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class CD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String CdTitle;


    public CD() {
    }

    public CD(String tytul) {
        super();
        this.CdTitle = tytul;

    }



}
