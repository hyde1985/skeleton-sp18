public class NBody {
	
	  /** Return a double corresponding to the radius of the universe in that file
	   *  @param   imgFileName 
	   *  @return  return a double corresponding to the radius of the universe in that file
	   */
	   public static double readRadius(String fileName) {
		   In in = new In(fileName);
		   int num = in.readInt();
		   double radius = in.readDouble();
		   return radius;
	   }
	
}