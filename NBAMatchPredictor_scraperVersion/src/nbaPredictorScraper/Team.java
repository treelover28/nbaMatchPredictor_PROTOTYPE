package nbaPredictorScraper;

import java.util.Objects;

/*
 * Khai Lai © 
 * 8/05/2019 
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
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public void setOffensiveRating(double offensiveRating) 
	{
		this.offensiveRating = offensiveRating;
	}

	public void setDefensiveRating(double defensiveRating) 
	{
		this.defensiveRating = defensiveRating;
	}

	public void setPace(double pace) 
	{
		this.pace = pace;
	}
	
	public boolean equals(Object team)
	{
		if (team == this) return true;
		
		if (!(team instanceof Team)) return false;
		
		Team t = (Team) team;
		double epsilon = 0.01;
		return this.getName() == t.getName() &&
				this.getOffRating() - t.getOffRating() <= epsilon &&
				this.getDefRating() - t.getDefRating() <= epsilon &&
				this.getPace() - t.getPace() <= epsilon;
	}
	
	public int hashCode()
	{
		return Objects.hash(name, offensiveRating, defensiveRating, pace);
	}
}
