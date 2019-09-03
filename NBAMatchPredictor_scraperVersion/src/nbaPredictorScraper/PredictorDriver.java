package nbaPredictorScraper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
			ArrayList<Team> NBA = new ArrayList<>(30);
			// link to scrape Offensive and Defensive Ratings
			String br = "https://www.basketball-reference.com/leagues/NBA_2019_ratings.html";
			Document nbaRef = Jsoup.connect(br).get();			
			// get elements of attribute-key "data-stat" with value "team_name"
			Elements team = nbaRef.getElementsByAttributeValue("data-stat", "team_name");
			// get elements of attribute-key "data-stat" with value "off_rtg"
			Elements off = nbaRef.getElementsByAttributeValue("data-stat" , "off_rtg");
			Elements def = nbaRef.getElementsByAttributeValue("data-stat" , "def_rtg");
			
			for (int i = 1; i < team.size(); i++) 
			{
				String name = team.get(i).text();
				double offRtg = Double.parseDouble(off.get(i).text());
				double defRtg = Double.parseDouble(def.get(i).text());	
				NBA.add(new Team(name, offRtg, defRtg, 0.0));
				// add in Team objects with 0.0 pace first
			}
			
			// set the Teams' PACE factors 
			String paceURL = "https://www.teamrankings.com/nba/stat/possessions-per-game";
			Document paceDoc = Jsoup.connect(paceURL).get();			
			Elements teamABC = paceDoc.getElementsByAttribute("data-sort");
			ArrayList<String> teamName = new ArrayList<>(30);
			ArrayList<Double> pace = new ArrayList<>(30);
			
			for (int j = 0; j < teamABC.size(); j++)
			{
				// the indexing is simply due to the order of scraped elements in teamABC
				if ( j > 0 && (j - 1) % 8 == 0) teamName.add(teamABC.get(j).text());
				if ( j > 1 && (j - 2) % 8 == 0) pace.add(Double.parseDouble(teamABC.get(j).text()));
			}
			for (int i = 0; i < teamName.size(); i++)
			{
				// since the team's name on teamRankings and NBA Reference is different
				// I hard-coded the team's index to assign appropriate PACE values to correct teams
				String t = teamName.get(i);
				switch (t) 
				{
					case "Atlanta":
						NBA.get(25).setPace(pace.get(i));
						break;
					case "Okla City":
						NBA.get(8).setPace(pace.get(i));
						break;
					case "LA Lakers":
						NBA.get(21).setPace(pace.get(i));
						break;
					case "Sacramento":
						NBA.get(17).setPace(pace.get(i));
						break;
					case "Milwaukee":
						NBA.get(0).setPace(pace.get(i));
						break;
					case "Brooklyn":
						NBA.get(15).setPace(pace.get(i));
						break;
					case "LA Clippers":
						NBA.get(12).setPace(pace.get(i));
						break;
					case "Washington":
						NBA.get(24).setPace(pace.get(i));
						break;
					case "Philadelphia":
						NBA.get(10).setPace(pace.get(i));
						break;
					case "Phoenix":
						NBA.get(27).setPace(pace.get(i));
						break;
					case "Minnesota":
						NBA.get(19).setPace(pace.get(i));
						break;
					case "Golden State":
						NBA.get(1).setPace(pace.get(i));
						break;
					case "Utah":
						NBA.get(3).setPace(pace.get(i));
						break;
					case "Toronto":
						NBA.get(2).setPace(pace.get(i));
						break;
					case "New York":
						NBA.get(28).setPace(pace.get(i));
						break;
					case "Portland":
						NBA.get(5).setPace(pace.get(i));
						break;
					case "Boston":
						NBA.get(7).setPace(pace.get(i));
						break;
					case "Chicago":
						NBA.get(26).setPace(pace.get(i));
						break;
					case "Dallas":
						NBA.get(18).setPace(pace.get(i));
						break;
					case "Charlotte":
						NBA.get(22).setPace(pace.get(i));
						break;
					case "Houston":
						NBA.get(4).setPace(pace.get(i));
						break;
					case "Miami":
						NBA.get(14).setPace(pace.get(i));
						break;
					case "Detroit":
						NBA.get(16).setPace(pace.get(i));
						break;
					case "Orlando":
						NBA.get(13).setPace(pace.get(i));
						break;
					case "San Antonio":
						NBA.get(11).setPace(pace.get(i));
						break;
					case "Indiana":
						NBA.get(9).setPace(pace.get(i));
						break;
					case "Denver":
						NBA.get(6).setPace(pace.get(i));
						break;
					case "Memphis":
						NBA.get(23).setPace(pace.get(i));
						break;
					case "Cleveland":
						NBA.get(29).setPace(pace.get(i));
						break;
					case "New Orleans":
						NBA.get(20).setPace(pace.get(i));
						break;
				}	
			}

			// code to print team info for diagnostic purpose
//			for (int i = 0; i < NBA.size(); i++)
//			{
//				System.out.println(i + " | " + NBA.get(i));
//			}
			
		
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
						team1 = 1;
						break;
					case "hou":
						team1 = 4;
						break;
					case "mil":
						team1 = 0;
						break;
					case "por":
						team1 = 5;
						break;
					case "sas":
						team1 = 11;
						break;
					case "tor":
						team1 = 2;
						break;
					case "phi":
						team1 = 10;
						break;
					case "bos":
						team1 = 7;
						break;
					case "den":
						team1 = 6;
						break;
					case "lac":
						team1 = 12;
						break;
					case "uta":
						team1 = 3;
						break;
					case "nop":
						team1 = 20;
						break;
					case "was":
						team1 = 24;
						break;
					case "min":
						team1 = 19;
						break;
					case "cha":
						team1 = 22;
						break;
					case "sac":
						team1 = 16;
						break;
					case "okc":
						team1 = 8;
						break;
					case "ind":
						team1 = 9;
						break;
					case "bkn":
						team1 = 15;
						break;
					case "dal":
						team1 = 18;
						break;
					case "orl":
						team1 = 13;
						break;
					case "det":
						team1 = 16;
						break;
					case "atl":
						team1 = 25;
						break;
					case "lal":
						team1 = 21;
						break;
					case "cle":
						team1 = 29;
						break;
					case "mia":
						team1 = 14;
						break;
					case "mem":
						team1 = 23;
						break;
					case "phx":
						team1 = 27;
						break;
					case "chi":
						team1 = 26;
						break;
					case "nyk":
						team1 = 28;
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
						team2 = 1;
						break;
					case "hou":
						team2 = 4;
						break;
					case "mil":
						team2 = 0;
						break;
					case "por":
						team2 = 5;
						break;
					case "sas":
						team2 = 11;
						break;
					case "tor":
						team2 = 2;
						break;
					case "phi":
						team2 = 10;
						break;
					case "bos":
						team2 = 7;
						break;
					case "den":
						team2 = 6;
						break;
					case "lac":
						team2 = 12;
						break;
					case "uta":
						team2 = 3;
						break;
					case "nop":
						team2 = 20;
						break;
					case "was":
						team2 = 24;
						break;
					case "min":
						team2 = 19;
						break;
					case "cha":
						team2 = 22;
						break;
					case "sac":
						team2 = 16;
						break;
					case "okc":
						team2 = 8;
						break;
					case "ind":
						team2 = 9;
						break;
					case "bkn":
						team2 = 15;
						break;
					case "dal":
						team2 = 18;
						break;
					case "orl":
						team2 = 13;
						break;
					case "det":
						team2 = 16;
						break;
					case "atl":
						team2 = 25;
						break;
					case "lal":
						team2 = 21;
						break;
					case "cle":
						team2 = 29;
						break;
					case "mia":
						team2 = 14;
						break;
					case "mem":
						team2 = 23;
						break;
					case "phx":
						team2 = 27;
						break;
					case "chi":
						team2 = 26;
						break;
					case "nyk":
						team2 = 28;
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
				Match match = new Match(NBA.get(team1), NBA.get(team2));
				HashMap<String, Double> res = match.simulateNMatch(10000);
				for (String t : res.keySet())
				{
					System.out.print(t + ": " + res.get(t) + "% chance of winning |\t");
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
