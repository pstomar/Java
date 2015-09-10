
/**     javac -> java compiler
  *     java -> java interpreter(jvm)
  *
  *     when we compile this file then java interpreter generates
  *     a file named psp.class. if a file contains more than one class
  *     then it will generate more than one .class files
  *
  *     what happens when execute command as (java file_name) ?
  *     JVM scans for file_name if not exists then will print an error
  *     message.
  *     If file exists then it will search for main method in it as
  *     name - main()
  *     parameter - String[]
  *     return type - void
  *     access - public
  *     nature - static
  */

class psp{
	public static void main(String gg[]) {
        System.out.print("Hello");
        System.out.println("God is");
        System.out.println("great");
	}
}