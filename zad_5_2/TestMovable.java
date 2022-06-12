package zad_5_2;

public class TestMovable {
    public static void main(String[] args) {

        MovablePoint move = new MovablePoint(0, 0);
        move.moveDown();
        System.out.println(move);
        move.moveRight();
        System.out.println(move);
        move.moveUp();
        System.out.println(move);
        move.moveLeft();
    }
}
