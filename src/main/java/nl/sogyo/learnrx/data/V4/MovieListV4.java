package nl.sogyo.learnrx.data.V4;

import java.util.ArrayList;
import java.util.List;

public class MovieListV4 {

    public final String name;
    public final List<ReleaseV4> releases;

    public MovieListV4(String name) {
        this.name = name;
        this.releases = new ArrayList<>();
    }
}
