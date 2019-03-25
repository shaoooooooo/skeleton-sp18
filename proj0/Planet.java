public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double big_g = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {}
	public Planet(Planet[] allPlanets) {}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double force = big_g * p.mass * this.mass/calcDistance(p)/calcDistance(p);
		return force;
	}

	public double calcForceExertedByX(Planet p) {
		double forceByX = 0;		
		if (this.equals(p)) {
			return 0;
		}
		forceByX = calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
		return forceByX;
	}

	public double calcForceExertedByY(Planet p) {
		double forceByY = 0;		
		if (this.equals(p)) {
			return 0;
		}
		forceByY = calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
		return forceByY;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double forceNetByX = 0;
		for (int i = 0; i < allPlanets.length; i += 1) {
			forceNetByX = calcForceExertedByX(allPlanets[i]) + forceNetByX;
		}
		return forceNetByX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double forceNetByY = 0;
		for (int j = 0; j < allPlanets.length; j += 1) {
			forceNetByY = calcForceExertedByY(allPlanets[j]) + forceNetByY;
		}
		return forceNetByY;
	}

	public void update(double dt, double fx, double fy) {
		xxVel = xxVel + dt * fx / mass;
		yyVel = yyVel + dt * fy / mass;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
}