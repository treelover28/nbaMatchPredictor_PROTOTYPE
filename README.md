# NBA Match Predictor &copy; 

**Author:** Khai H Lai

**Last Updated:** 9/3/2019

**Changelog:** 
* Added hashCode() and equals() to class Team.
* Added webscraping functionality using JSoup library

**Language:** Java
![NBA Finals 2019](https://user-images.githubusercontent.com/50902696/64215334-f46c7e80-ce4f-11e9-9d50-25ddd49c66da.jpg)
This simple program uses Monte Carlo simulation to:
 * predict the result of an NBA match.
 * output each team's probability of winning the matchup.

Has **basic UI** that allows users to type in the names of the teams they wish to simulate the match-up with.
![Text-based UI](https://user-images.githubusercontent.com/50902696/64215182-3e089980-ce4f-11e9-9293-4595691ae68e.PNG)

### Procedure Description
The simulator uses library Jsoup to scrape data from Basketball Reference NBA 2019 Ranking and Team Rankings. It then uses Monte-Carlo simulation (with added random statistical variations applied on the procedure described on Basketball Distribution) to give the probability of each team winning the match-up.

### Next update
* Make this program into a webapp that can be easily used and accessed by the public.
* Make this program into a browser extension that automatically fetch from that day's NBA schedule and output predictions.
* Goal for completion: December 1, 2019
