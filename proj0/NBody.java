public class NBody {
	
	public static double readRadius(String filename) {
		In in = new In(filename);
		int planet_number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename) {
		In in = new In(filename);
		int planet_number = in.readInt();
		Planet[] allPlanets = new Planet[planet_number];		
		double trash2 = in.readDouble();
		for (int i = 0; i < planet_number; i+=1) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			allPlanets[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return allPlanets;
	}

}
