package nl.sogyo.learnrx.data;

import java.util.ArrayList;
import java.util.List;

public class Rating {

    public final double rating;

    public static List<Rating> ratingFactory(double... ratings) {
        List<Rating> _ratings = new ArrayList<Rating>(ratings.length);

        for (int i = 0; i < ratings.length; i++) {
            _ratings.add(new Rating(ratings[i]));
        }

        return _ratings;
    }

    private Rating(double rating) {
        this.rating = rating;
    }
}
