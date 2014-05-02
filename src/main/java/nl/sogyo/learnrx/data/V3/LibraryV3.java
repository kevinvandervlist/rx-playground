package nl.sogyo.learnrx.data.V3;

import java.util.ArrayList;
import java.util.List;

public class LibraryV3 {

    public static final ReleaseV3 DieHard = new ReleaseV3(
            70111470,
            "Die Hard");

    public static final ReleaseV3 BadBoys = new ReleaseV3(
            654356453,
            "Bad Boys");

    public static final ReleaseV3 TheChamber = new ReleaseV3(
            65432445,
            "The Chamber");

    public static final ReleaseV3 Fracture = new ReleaseV3(
            675465,
            "Fracture");

    public static List<ReleaseV3> getReleases() {
        List<ReleaseV3> releases = new ArrayList<>();

        releases.add(DieHard);
        releases.add(BadBoys);
        releases.add(TheChamber);
        releases.add(Fracture);

        return releases;
    }
}
