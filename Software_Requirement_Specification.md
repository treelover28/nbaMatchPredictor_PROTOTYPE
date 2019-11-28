# Software Requirement Specification
### NBA Match Predictor (version 3)
Implemented using: Python Eve. , MongoDB, Beautiful Soup, ...[insert more as project progresses] 

## Specifications:
1. Set up backend server using MongoDB to store team statistics
    - [x]  **Deadline: 11/25/2019** 
    - [x] Set up endpoints 
    - [x] Set up endpoints' schemas 
  
2. Implement scraping function using Beautiful Soup:
    - [ ]  **Deadline: 11/28/2019** 
    - [x] Ability to scrape team statistics on NBA Reference, Team Ranking
    - [x] Ability to scrape game schedule on a specified date 
    - [ ] Ability to scrape individual statistics in a specified season
    - [ ] Ability to scrape matchup's rosters for a specific game in the past
    
3. Implement a Neural Network to predict matchup winner, by training from individual players ' statistics:
    - [ ]  **Deadline: 12/5/2019** 
    - [ ] Scrape games from the past 5 seasons. Store in some endpoints ?
    - [ ] Train using matchup's rosters and individual players ' stats ?
    - [ ] Use own Neural Network implementation or consider TensorFlow, Scikit-Learn

4. Have a professional U.I/ Interactive Front End
    - [ ]  **Deadline: 12/12/2019** 
    - [ ] Consider bootstrapping (?)
    - [ ] Or try to implement own frontend using HTML/CSS/React
    - [ ] Host live website on an actual online server. Look into Docker, Heroku, Digital Ocean.

5. Set up accounts/ email-list (Optional): 
    - [ ]  **Deadline: 12/20/2019** 
    - [ ] Send registered users email of predictions.
    - [ ] Store user logins, authentication,.. somehow
        - [ ] Look into hashing function for password storage
        - [ ] Set up auto-mailing server (?) 


