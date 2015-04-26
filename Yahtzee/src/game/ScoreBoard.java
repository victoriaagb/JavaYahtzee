package game;

/** Manages each score in a Yahtzee game
 * 
* @class PlayGround.java
* @authors Victoria Garcia, Brian Rosfelder
* @date 04/26/2015
* 
*/
public class ScoreBoard {
	
	private int [] scores;
	
	public ScoreBoard(){
		
		scores = new int[13];
		for (int i = 0; i < 13; i++)
		{
			scores[i] = 0;
		}
	}
	
	public int getScore(int n)
	{
		return scores[n];
	}
	
	public void setScore(int n, int score)
	{
		scores[n] = score;
	}

	public int count(int n, Die [] dice)
	{
		int num = 0;
		for (int i = 0; i < 5; i++)
			if (dice[i].getValue() == n)
				num++;
		return num * n;
	}	
	
	public boolean yahtzee(Die [] dice)
	{
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
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
	
	// find num of a kind
	public int numberOfAKind(int n, Die [] dice)
	{
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
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
	
	// brute force calculation, but it gets the job done.
	public boolean fullHouse(Die [] dice)
	{
		boolean answer = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
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
	
	// 4 for small, 5 for large
	public boolean numStraight(int n, Die [] dice)
	{
		boolean answer = false;
		int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
		
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
		if (n == 4)
			answer = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1) ||
			 		(twos >= 1 && threes >= 1 && fours >= 1 &&	fives >= 1) ||
					  (threes >= 1 && fours >= 1 && fives >= 1 && sixes >= 1);
		
		if (n == 5)
			answer = (ones >= 1 && twos >= 1 && threes >= 1 && fours >= 1 &&
					fives >= 1) || (twos >= 1 && threes >= 1 && fours >= 1 &&
						fives >= 1 && sixes >= 1);
		
		return answer;
	}

	public int chance(Die [] dice)
	{
		int total=0;
		for(int i = 0; i < 5; i++){
			total += dice[i].getValue();
		}
		return total;
	}
	
	public int topScore()
	{
		int topScore = 0;
		for (int i = 0; i < 6; i++)
			topScore += scores[i];
		return topScore;
	}
	
	public int bonusScore()
	{
		if (bonus())
			return 35;
		return 0;
	}
	
	public int totaltopScore()
	{
		return topScore() + bonusScore();
	}
	
	public int bottomScore()
	{
		int bottomScore = 0;
		for (int i = 6; i < scores.length; i++)
			bottomScore += scores[i];
		return bottomScore;
 	}

	public int grandTotal()
	{
		return totaltopScore() + bottomScore();
	}

	public boolean bonus()
	{
		return topScore() >= 63;
	}
}
