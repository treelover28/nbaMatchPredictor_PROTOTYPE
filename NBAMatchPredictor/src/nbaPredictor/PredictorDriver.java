package nbaPredictor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * Khai Lai © 
 * 6/20/2019 
 * NBA Match Predictor version 1.00 
 * https://github.com/treelover28
 */
public class PredictorDriver 
{
	public static void main(String[] args)
	{
		try
		{
			ArrayList<Team> nba = new ArrayList<>();
			Scanner readIn = new Scanner(new FileInputStream(new File("teamRatings.csv")));
			// skip header line
			readIn.nextLine();
			// read in data
			while (readIn.hasNextLine())
			{
				String[] data = readIn.nextLine().split(",");
				String name = data[0];
				double offRating = Double.parseDouble(data[1]);
				double defRating = Double.parseDouble(data[2]);
				double pace = Double.parseDouble(data[3]);
				nba.add(new Team(name, offRating, defRating, pace));
			}
			readIn.close();
			
			// Basic UI 
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Teams' abbreviations");
			System.out.println("GSW: Golden State Warriors \t\tHOU: Houston Rockets"
					+ "\nMIL: Milwaukee Bucks \t\t\tPOR: Portland Trail Blazers"
					+ "\nSAS: San Antonio Spurs \t\t\tTOR: Toronto Raptors"
					+ "\nPHI: Philadelphia Sixers \t\tBOS: Boston Celtics"
					+ "\nLAC: Los Angeles Clippers \t\tDEN: Denver Nuggets"
					+ "\nUTA: Utah Jazz \t\t\t\tNOP: New Orleans Pelicans"
					+ "\nWAS: Washington Wizards \t\tMIN: Minnesota Timberwolves"
					+ "\nCHA: Charlotte Hornets \t\t\tSAC: Sacramento Kings"
					+ "\nOKC: Oklahoma City Thunders \t\tIND: Indiana Pacers"
					+ "\nBKN: Brooklyn Nets \t\t\tDAL: Dallas Mavericks"
					+ "\nDET: Detroit Pistons \t\t\tORL: Orlando Magics"
					+ "\nATL: Atlanta Hawks \t\t\tLAL: Los Angeles Lakers"
					+ "\nMIA: Miami Heats \t\t\tCLE: Cleveland Cavaliers"
					+ "\nMEM: Memphis Grizzlies \t\t\tPHX: Phoenix Suns"
					+ "\nCHI: Chicago Bulls \t\t\tNYK: New York Knicks");
			System.out.println("Type 'teams' to show the list of teams' abbreviations.");
			System.out.println("Type 'quit' to exit the program.");
			while(true)
			{
				System.out.println("Type the two teams' abbreviations you want to matchup separated by a comma: DEN,LAL");
				String[] teams = keyboard.nextLine().split(",");
				int team1, team2;
				// switch team abbreviation to get team's index in ArrayList
				switch (teams[0].trim().toLowerCase())
				{
					case "gsw":
						team1 = 0;
						break;
					case "hou":
						team1 = 1;
						break;
					case "mil":
						team1 = 2;
						break;
					case "por":
						team1 = 3;
						break;
					case "sas":
						team1 = 4;
						break;
					case "tor":
						team1 = 5;
						break;
					case "phi":
						team1 = 6;
						break;
					case "bos":
						team1 = 7;
						break;
					case "den":
						team1 = 8;
						break;
					case "lac":
						team1 = 9;
						break;
					case "uta":
						team1 = 10;
						break;
					case "nop":
						team1 = 11;
						break;
					case "was":
						team1 = 12;
						break;
					case "min":
						team1 = 13;
						break;
					case "cha":
						team1 = 14;
						break;
					case "sac":
						team1 = 15;
						break;
					case "okc":
						team1 = 16;
						break;
					case "ind":
						team1 = 17;
						break;
					case "bkn":
						team1 = 18;
						break;
					case "dal":
						team1 = 19;
						break;
					case "orl":
						team1 = 20;
						break;
					case "det":
						team1 = 21;
						break;
					case "atl":
						team1 = 22;
						break;
					case "lal":
						team1 = 23;
						break;
					case "cle":
						team1 = 24;
						break;
					case "mia":
						team1 = 25;
						break;
					case "mem":
						team1 = 26;
						break;
					case "phx":
						team1 = 27;
						break;
					case "chi":
						team1 = 28;
						break;
					case "nyk":
						team1 = 29;
						break;
					case "teams":
						System.out.println("GSW: Golden State Warriors \t\tHOU: Houston Rockets"
								+ "\nMIL: Milwaukee Bucks \t\t\tPOR: Portland Trail Blazers"
								+ "\nSAS: San Antonio Spurs \t\t\tTOR: Toronto Raptors"
								+ "\nPHI: Philadelphia Sixers \t\tBOS: Boston Celtics"
								+ "\nLAC: Los Angeles Clippers \t\tDEN: Denver Nuggets"
								+ "\nUTA: Utah Jazz \t\t\t\tNOP: New Orleans Pelicans"
								+ "\nWAS: Washington Wizards \t\tMIN: Minnesota Timberwolves"
								+ "\nCHA: Charlotte Hornets \t\t\tSAC: Sacramento Kings"
								+ "\nOKC: Oklahoma City Thunders \t\tIND: Indiana Pacers"
								+ "\nBKN: Brooklyn Nets \t\t\tDAL: Dallas Mavericks"
								+ "\nDET: Detroit Pistons \t\t\tORL: Orlando Magics"
								+ "\nATL: Atlanta Hawks \t\t\tLAL: Los Angeles Lakers"
								+ "\nMIA: Miami Heats \t\t\tCLE: Cleveland Cavaliers"
								+ "\nMEM: Memphis Grizzlies \t\t\tPHX: Phoenix Suns"
								+ "\nCHI: Chicago Bulls \t\t\tNYK: New York Knicks");
						continue;
					case "quit":
						System.out.println("Program has terminated.");
						System.exit(0);
					default:
						continue; // does nothing is team is not recognized
				}
				switch (teams[1].trim().toLowerCase())
				{
					case "gsw":
						team2 = 0;
						break;
					case "hou":
						team2 = 1;
						break;
					case "mil":
						team2 = 2;
						break;
					case "por":
						team2 = 3;
						break;
					case "sas":
						team2 = 4;
						break;
					case "tor":
						team2 = 5;
						break;
					case "phi":
						team2 = 6;
						break;
					case "bos":
						team2 = 7;
						break;
					case "den":
						team2 = 8;
						break;
					case "lac":
						team2 = 9;
						break;
					case "uta":
						team2 = 10;
						break;
					case "nop":
						team2 = 11;
						break;
					case "was":
						team2 = 12;
						break;
					case "min":
						team2 = 13;
						break;
					case "cha":
						team2 = 14;
						break;
					case "sac":
						team2 = 15;
						break;
					case "okc":
						team2 = 16;
						break;
					case "ind":
						team2 = 17;
						break;
					case "bkn":
						team2 = 18;
						break;
					case "dal":
						team2 = 19;
						break;
					case "orl":
						team2 = 20;
						break;
					case "det":
						team2 = 21;
						break;
					case "atl":
						team2 = 22;
						break;
					case "lal":
						team2 = 23;
						break;
					case "cle":
						team2 = 24;
						break;
					case "mia":
						team2 = 25;
						break;
					case "mem":
						team2 = 26;
						break;
					case "phx":
						team2 = 27;
						break;
					case "chi":
						team2 = 28;
						break;
					case "nyk":
						team2 = 29;
						break;
					case "quit":
						System.out.println("Program has terminated.");
						System.exit(0);
					case "teams":
						System.out.println("GSW: Golden State Warriors \t\tHOU: Houston Rockets"
								+ "\nMIL: Milwaukee Bucks \t\t\tPOR: Portland Trail Blazers"
								+ "\nSAS: San Antonio Spurs \t\t\tTOR: Toronto Raptors"
								+ "\nPHI: Philadelphia Sixers \t\tBOS: Boston Celtics"
								+ "\nLAC: Los Angeles Clippers \t\tDEN: Denver Nuggets"
								+ "\nUTA: Utah Jazz \t\t\t\tNOP: New Orleans Pelicans"
								+ "\nWAS: Washington Wizards \t\tMIN: Minnesota Timberwolves"
								+ "\nCHA: Charlotte Hornets \t\t\tSAC: Sacramento Kings"
								+ "\nOKC: Oklahoma City Thunders \t\tIND: Indiana Pacers"
								+ "\nBKN: Brooklyn Nets \t\t\tDAL: Dallas Mavericks"
								+ "\nDET: Detroit Pistons \t\t\tORL: Orlando Magics"
								+ "\nATL: Atlanta Hawks \t\t\tLAL: Los Angeles Lakers"
								+ "\nMIA: Miami Heats \t\t\tCLE: Cleveland Cavaliers"
								+ "\nMEM: Memphis Grizzlies \t\t\tPHX: Phoenix Suns"
								+ "\nCHI: Chicago Bulls \t\t\tNYK: New York Knicks");
						continue;
					default:
						continue; // does nothing is team is not recognized		
				}
				if (team1 == team2) // if both are the same team, prompt users to choose two different teams
				{
					System.out.println("Cannot match a team up against itself! Please choose two different teams to simulate matchup.");
					continue;
				}
				Match match = new Match(nba.get(team1), nba.get(team2));
				HashMap<String, Double> res = match.simulateNMatch(10000);
				for (String team : res.keySet())
				{
					System.out.print(team + ": " + res.get(team) + "% chance of winning |\t");
				}
				System.out.println();
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}	
	}
}
