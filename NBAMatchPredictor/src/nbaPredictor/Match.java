package nbaPredictor;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

/*
 * Khai Lai © 
 * 6/20/2019 
 * NBA Match Predictor version 1.00 
 * https://github.com/treelover28
 */
public class Match 
{
	private String name1;
	private String name2;
	private double OffRating1;
	private double OffRating2;
	private double DefRating1;
	private double DefRating2;
	private double pace1;
	private double pace2;
	private double point1;
	private double point2;
	private final double leaguePace = 100.0;
	private final double leagueOffRating = 110.4;
	
	
	public Match(Team team1, Team team2)
	{
		// get home team stats
		name1= team1.getName();
		OffRating1 = team1.getOffRating();
		DefRating1 = team1.getDefRating();
		pace1 = team1.getPace();
		
		// get away team stats
		name2= team2.getName(); 
		OffRating2 = team2.getOffRating();
		DefRating2 = team2.getDefRating();
		pace2 = team2.getPace();
	}
	
	private HashMap<String, Double> simulateMatch()
	{
		HashMap<String, Double> result = new HashMap<>();
		
		// offensive and defensive efficiencies has random -5% to 5% variations
		double ortg1 = OffRating1 * (1 + (new Random().nextInt(5+ 1 -(-5)) + (-5))/100.0);
		double drtg1 = DefRating1 * (1 + (new Random().nextInt(5+ 1 -(-5)) + (-5))/100.0);
		double ortg2 = OffRating2 * (1 + (new Random().nextInt(5+ 1 -(-5)) + (-5))/100.0);
		double drtg2 = DefRating2 * (1 + (new Random().nextInt(5+ 1 -(-5)) + (-5))/100.0);
		
		// Multiple teams' paces together and divide by league's average pace to find predicted game pace
		double gamePace = (pace1 * pace2) / leaguePace;
		
		// for each team, multiply their Offense with Opponent defense and divide by league average Offensive Rating per game
		double ppp1 = (ortg1 * drtg2)/ leagueOffRating;
		double ppp2 = (ortg2 * drtg1)/ leagueOffRating;
		// multiply predicted PPP by predicted game pace, and divide by 100 to get final score
		point1 = (int) (ppp1 * gamePace / 100);
		point2 = (int) (ppp2 * gamePace / 100);
		
		if (point1 == point2) // if points are equal, re-simulate
		{
			this.simulateMatch();
		}
		
		result.put(name1, point1);
		result.put(name2, point2);
		return result;
	}
	
	public HashMap<String, Double> simulateNMatch(int repetition)
	{
		int sum1 = 0;
		int sum2 = 0;
		double count1 = 0;
		double count2 = 0;
		
		HashMap<String, Double> sim = new HashMap<>();
		
		for (int i = 0; i < repetition; i++)
		{
			sim = simulateMatch();
			double score1 = sim.get(name1);
			double score2 = sim.get(name2);
			if (score1 > score2) // add up numbers of win per team
			{
				count1++;
			}
			else if (score1 < score2)
			{
				count2++;
			}
			else // if tie, re-simulate match
			{
				// re-simulate
				System.out.println("Resimulate");
				i--;
				continue;
			}
			sum1 += score1;
			sum2 += score2;
		}
		System.out.println(name1 + ": " + sum1/repetition + " , " + name2 + ": " + sum2/repetition);
		
		// put percentage as 2 decimal places
		DecimalFormat twodp = new DecimalFormat("#.00");
		double ratio1 = Double.valueOf(twodp.format(count1/repetition * 100));
		double ratio2 = Double.valueOf(twodp.format(count2/repetition * 100));
		sim.put(name1, ratio1);
		sim.put(name2, ratio2);
		
		return sim;
	}
	
	
}
