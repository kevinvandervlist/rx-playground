package nl.sogyo.learnrx.noninteractive;

public class VerifyExcercises extends Verify {

    private Excercises excercises = new Excercises();

    @Override
    public Excercises getExcercise() {
        return excercises;
    }
}
