package game;

/** Manages each the scores in a Yahtzee game
 * 
* @class PlayGround.java
* @authors Victoria Garcia, Brian Rosfelder
* @date 04/26/2015
* 
*/
public class ScoreBoard {
	
	private int [] scores;
	
	/**
	 * constructor
     */
	public ScoreBoard(){
		
		scores = new int[13];
	}
	
	/** returns score of type of scores 
	 * @param position of array in scores
	 * @return score of type of scores
     */
	public int getScore(int n)
	{
		return scores[n];
	}
	
	/** sets the score of a type of score
	 * @param position of type of score in scores array
	 * @param updated score of type of score
     */
	public void setScore(int n, int score)
	{
		scores[n] = score;
	}

	/** returns the total added amount of dies with the same value
	 * @param value of dice to search for
	 * @param array of dice
	 * @return the value times the number of dice found with that value
     */
	public int count(int n, Die [] dice)
	{
		int num = 0;
		for (int i = 0; i < 5; i++)
			//calculate amount of dices with the given value
			if (dice[i].getValue() == n)
				num++;
		//multiply the value by number of dice found with that value
		return num * n;
	}	
	
	/** returns true if 5 or more dice have the same value
	 * @param array of dice
	 * @return true if all dice have same value
     */
	public boolean yahtzee(Die [] dice)
	{
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		//add amount of dice with same value
		for (int i = 0; i < 5; i++)
		{
			if (dice[i].getValue() == 1)
				ones++;
			if (dice[i].getValue() == 2)
				twos++;
			if (dice[i].getValue() == 3)
				threes++;
			if (dice[i].getValue() == 4)
				fours++;
			if (dice[i].getValue() == 5)
				fives++;
			if (dice[i].getValue() == 6)
				sixes++;
		}
		
		//check if each type add up to 5 or more
		if(ones >= 5)
			return true;
		else if(twos >= 5) 
			return true;
		else if(threes >= 5)
			return true;
		else if(fours >= 5)
			return true;
		else if(fives >= 5)
			return true;
		else if(sixes >= 5)
			return true;
		else 
			return false;
	}
	
	/** returns the amount of dice found with a particular value
	 * @param value of dice to search for
	 * @param array of dice
	 * @return amount of dice found with the value provided
     */
	public int numberOfAKind(int n, Die [] dice)
	{
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		//add amount of dice with same value
		for (int i = 0; i < 5; i++)
		{
			if (dice[i].getValue() == 1)
				ones++;
			if (dice[i].getValue() == 2)
				twos++;
			if (dice[i].getValue() == 3)
				threes++;
			if (dice[i].getValue() == 4)
				fours++;
			if (dice[i].getValue() == 5)
				fives++;
			if (dice[i].getValue() == 6)
				sixes++;
		}
		
		if(ones >= n)
			return ones;
		else if(twos >= n) 
			return twos * 2;
		else if(threes >= n)
			return threes * 3;
		else if(fours >= n)
			return fours * 4;
		else if(fives >= n)
			return fives * 5;
		else if(sixes >= n)
			return sixes * 6;
		else return 0;
	}		
	
	/** returns true if a full house was found in array of dice
	 * @param array of dice
	 * @return true if full house was found in array or dice
     */
	public boolean fullHouse(Die [] dice)
	{
		boolean answer = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		//add amount of dice with same value
		for (int i = 0; i < 5; i++)
		{
			if (dice[i].getValue() == 1)
				ones++;
			if (dice[i].getValue() == 2)
				twos++;
			if (dice[i].getValue() == 3)
				threes++;
			if (dice[i].getValue() == 4)
				fours++;
			if (dice[i].getValue() == 5)
				fives++;
			if (dice[i].getValue() == 6)
				sixes++;
		}		
		//brute force calculation
		answer = (ones == 3 && (twos == 2 || threes == 2 || fours == 2 ||
				fives == 2 || sixes == 2)) || (twos == 3 && (ones == 2 ||
				 threes == 2 || fours == 2 || fives == 2 || sixes == 2)) ||
				 (threes == 3 && (ones == 2 || twos == 2 || fours == 2 ||
				 fives == 2 || sixes == 2)) || (fours == 3 && (ones == 2 ||
				 threes == 2 || twos == 2 || fives == 2 || sixes == 2))
				 || (fives == 3 && (ones == 2 || threes == 2 || fours == 2 ||
				 twos == 2 || sixes == 2)) || (sixes == 3 && (ones == 2 ||
				 threes == 2 || fours == 2 || fives == 2 || twos == 2));
				
		return answer;
	}
	
	/** returns true if a small or large straight was found in array of dice
	 * @param 4 for small straight, 5 for large straight
	 * @param array of dice
	 * @return the value times the number of dice found with that value
     */
	public boolean numStraight(int n, Die [] dice)
	{
		boolean answer = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
		//add amount of dice with same value
		for (int i = 0; i < 5; i++)
		{
			if (dice[i].getValue() == 1)
				ones++;
			if (dice[i].getValue() == 2)
				twos++;
			if (dice[i].getValue() == 3)
				threes++;
			if (dice[i].getValue() == 4)
				fours++;
			if (dice[i].getValue() == 5)
				fives++;
			if (dice[i].getValue() == 6)
				sixes++;
		}
		//brute force for small straight 
		if (n == 4)
			answer = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1) ||
			 		(twos >= 1 && threes >= 1 && fours >= 1 &&	fives >= 1) ||
					  (threes >= 1 && fours >= 1 && fives >= 1 && sixes >= 1);
		
		//brute force for large straight
		if (n == 5)
			answer = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1 &&
					fives >= 1) || (twos >= 1 && threes >= 1 && fours >= 1 &&
						fives >= 1 && sixes >= 1);
		
		return answer;
	}
	
	/** returns the added values of dice in array
	 * @param array of dice
	 * @return total added values of dice in array
     */
	public int chance(Die [] dice)
	{
		int total=0;
		//iterate over dice array
		for(int i = 0; i < 5; i++){
			total += dice[i].getValue();
		}
		return total;
	}
	
	/** returns added scores of first 6 types of scores
	 * @return total added scores of first 6 types of score
     */
	public int topScore()
	{
		int topScore = 0;
		//iterate over first 6 scores array
		for (int i = 0; i < 6; i++)
			topScore += scores[i];
		return topScore;
	}
	
	/** returns bonus value if bonus is found
	 * @return bonus value if bonus found
     */
	public int bonusScore()
	{
		if (bonus())
			return 35;
		return 0;
	}
	
	/** returns the total score with bonus
	 * @return total topscore with bonus included
     */
	public int totaltopScore()
	{
		return topScore() + bonusScore();
	}
	
	/** returns added scores of first last remaining types of scores
	 * @return total added scores of last remaining types of sore
     */
	public int bottomScore()
	{
		int bottomScore = 0;
		for (int i = 6; i < scores.length; i++)
			bottomScore += scores[i];
		return bottomScore;
 	}

	/** returns the total score accumulated
	 * @return the total score accumulated
     */
	public int grandTotal()
	{
		return totaltopScore() + bottomScore();
	}

	/** returns true if bonus was found
	 * @return true if bonus was found
     */
	public boolean bonus()
	{
		return topScore() >= 63;
	}
}
