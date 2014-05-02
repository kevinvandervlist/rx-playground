package nl.sogyo.learnrx.data.V1;

import java.util.ArrayList;
import java.util.List;

public class MovieListV1 {

    public final String name;
    public final List<ReleaseV1> releases;

    public MovieListV1(String name) {
        this.name = name;
        this.releases = new ArrayList<>();
    }
}
