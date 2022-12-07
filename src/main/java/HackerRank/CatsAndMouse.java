package HackerRank;

public class CatsAndMouse {

    //https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

    static String catAndMouse(int x, int y, int z) {

        int catATime = Math.abs(z-x);
        int catBTime = Math.abs(z-y);
        if(catATime < catBTime) return "Cat A";
        else if (catATime > catBTime) return "Cat B";
        else return "Mouse C";
    }
}
