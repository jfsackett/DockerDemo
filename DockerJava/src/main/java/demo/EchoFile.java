package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/** Simple echo program to demonstrate file access in Docker. */
public class EchoFile {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage:\ndocker.EchoFile <filename>");
			System.exit(1);
		}
		System.out.println(String.format("Echo file: %s%n", args[0]));
		File file = new File(args[0]);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
