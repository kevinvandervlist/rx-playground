package nl.sogyo.learnrx.data.V2;

import java.util.ArrayList;
import java.util.List;

public class MovieListV2 {

    public final String name;
    public final List<ReleaseV2> releases;

    public MovieListV2(String name) {
        this.name = name;
        this.releases = new ArrayList<>();
    }
}
