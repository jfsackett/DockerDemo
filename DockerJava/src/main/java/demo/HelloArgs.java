package demo;

/** Simple program to demonstrate command line argument use in Docker. */
public class HelloArgs {

	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(String.format("Hello %s !!", arg));
		}
	}

}
