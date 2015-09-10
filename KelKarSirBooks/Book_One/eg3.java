
/*
 *  Polymorphism : -
 *  Polymorphism is a mechanism that is achieved by method-
 *  overriding.
 *
 */

class Calculator {
    public int add(int e, int f){
        System.out.println("Sum is "+(e+f));
    }
    public int add(int e, int f, int g){
        System.out.println("Sum is "+(e+f+g));
    }
}

class eg3psp{
	public static void main(String gg[]) {
        Calculator c = new Calculator();
        c.add(10,40);
        c.add(30,40,50);
	}
}