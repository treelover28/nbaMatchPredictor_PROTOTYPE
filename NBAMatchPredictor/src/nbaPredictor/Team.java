package nbaPredictor;
/*
 * Khai Lai © 
 * 6/20/2019 
 * NBA Match Predictor version 1.00 
 * https://github.com/treelover28
 */
public class Team 
{
	private String name;
	private double offensiveRating;
	private double defensiveRating;
	private double pace;
	
	public Team(String name, double offensiveRating, double defensiveRating, double pace)
	{
		this.name = name;
		this.offensiveRating = offensiveRating;
		this.defensiveRating = defensiveRating;
		this.pace = pace;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Team: " + name + " | Offensive Rating: " + offensiveRating + " | Defensive Rating: " + defensiveRating + 
				" | Pace: " + pace);
		return sb.toString();
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getOffRating()
	{
		return offensiveRating;
	}
	
	public double getDefRating()
	{
		return defensiveRating;
	}
	
	public double getPace()
	{
		return pace;
	}
}
