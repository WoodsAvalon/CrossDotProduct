package CrossDotProduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import phillips.math.vector.Calculus;
import phillips.math.vector.Vector3D;

/**
 * This program calculates the cross and dot product between two vectors.
 * The vectors can either be supplied by being typed in or supplied in a text file.
 * If supplied in a file, the output can either be displayed or written to a file.
 */
public class CrossDotProduct {
	
	public static void main(String[] args) {
		new VectorProgram();		
	}
	
	/**
	 * VectorProgram uses a CLI to request two vectors in a x,y,z format, using the Vector3D object. It
	 * then calculates the dot and cross product of the two vectors by calling the calculation functions
	 * from the Calculus class. It then displays the dot and cross product in the CLI.
	 */
	static class VectorProgram {
		Vector3D vectorOne,vectorTwo;
		Calculus math;

		/**
		 * Reads CLI input and returns it as a String.
		 * 
		 * @return	String, the input supplied by the user.
		 */
		String readInput() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try
		    {
		      return br.readLine().strip();
		    }
		    catch (IOException ex)
		    {
		      System.out.println(ex);
		    }
			
			return null;
		}
		
		/**
		 * Calls readInput and then formats the string into an array and then
		 * 
		 * @param message	String, message displayed when requesting the input.
		 * @param vector	Vector3D, the vector that input is stored in.
		 */
		void readVector(String message, Vector3D vector) {
			while (true) {
				System.out.print(message);
				String input[] = readInput().split(",");
			
				if (input.length == 3) {
					vector.setX(Integer.parseInt(input[0]));
					vector.setY(Integer.parseInt(input[1]));
					vector.setZ(Integer.parseInt(input[2]));
					break;
				}
				else if(input.length < 3) { System.out.println("Not enough values supplied."); }
				else { System.out.println("Too many values supplied."); }
			}
		}
		
		/**
		 * Default constructor of VectorProgram, creates the two vectors and calculus object, requests vectors
		 * and then calculates and displays the dot and cross product of the two vectors.
		 */
		VectorProgram() {
			vectorOne = new Vector3D();
			vectorTwo = new Vector3D();
			math = new Calculus();
			
			System.out.println("Please enter two vectors in a x,y,z format.");
			readVector("Enter the first vector: ", vectorOne);
			readVector("Enter the second vector: ", vectorTwo);
			System.out.println("Dot Product: " + math.CalculateDotProduct(vectorOne, vectorTwo));
			System.out.println("Cross Product: " + math.CalculateCrossProduct(vectorOne, vectorTwo));
		}
	}
}
