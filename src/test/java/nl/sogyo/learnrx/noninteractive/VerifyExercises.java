package nl.sogyo.learnrx.noninteractive;

public class VerifyExercises extends Verify {

    private Exercises exercises = new Exercises();

    @Override
    public Exercises getExercise() {
        return exercises;
    }
}
