package main;

//public class MyMockito extends AbstractList<String> {
public class MyMockito  {
    private int privateCount = 7;
    public int publicCount = 17;

    public int size() {
        System.out.println(("in size()!"));
        privateCount++;
        return 0;
    }

    public int getCount() {
        System.out.println("in getCount()");
        return privateCount;
    }

    public static boolean staticMethod(){
        System.out.println("in static()");
        return true;
    }
}