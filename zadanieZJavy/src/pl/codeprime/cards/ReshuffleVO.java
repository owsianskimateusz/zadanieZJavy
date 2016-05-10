package pl.codeprime.cards;

import java.util.Arrays;

/**
 * Simple object. 
 * @author Mateusz Owsianski
 *
 */
public class ReshuffleVO 
{

	private int numberOfRow;
	private Integer rows[][];
	
	public int getNumberOfRow() 
	{
		return numberOfRow;
	}
	
	public void setNumberOfRow(int numberOfRow) 
	{
		this.numberOfRow = numberOfRow;
	}
	
	public Integer[][] getRows() 
	{
		return rows;
	}
	
	public void setRows(Integer[][] rows) 
	{
		this.rows = rows;
	}
	
	public Integer[] obtainSelectedRow()
	{
		return getRows()[getNumberOfRow()-1];
	}

	@Override
	public String toString() {
		return "ReshuffleVO [numberOfRow=" + numberOfRow + ", rows=" + Arrays.toString(rows) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfRow;
		result = prime * result + Arrays.deepHashCode(rows);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReshuffleVO other = (ReshuffleVO) obj;
		if (numberOfRow != other.numberOfRow)
			return false;
		if (!Arrays.deepEquals(rows, other.rows))
			return false;
		return true;
	}
}
