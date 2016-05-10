package pl.codeprime.cards.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Mateusz Owsianski
 *
 */
public class ValidatorUtils 
{

	public static final int MAX__SIZE_CARDS = 4;
	public static final int MAX_CARDS = 4;
	public static final String EMPTY = "";
	
	public static boolean isInRange(int numberOfRow, int minRow, int maxRow)
	{
		return numberOfRow >=minRow && numberOfRow <= maxRow;
	}
	
	public static String reasonForIncorrectArrays()
	{
		return "Prosze wprowadzic liczby od 1 do 16 tak aby w macierzy 4x4 nie powtarzaly sie.";
	}
	
	public static String reasonForIncorrectNumber(int minRow, int maxRow)
	{
		return String.format("Prosze wprowadzic ponownie wartosc z przedzialu od %d do %d", minRow, maxRow);
	}
	
	/**
	 * Default value for  minRow is 1 and maxRow is 16.
	 * @param values
	 * @return
	 */
	public static boolean isInRange(Integer[] values)
	{
		List<Boolean> isRangeList = new ArrayList<>();
		isRangeList.addAll(CommonUtils.asList(values).stream().map(value -> value != null ? ValidatorUtils.isInRange(value, 1, 16) : Boolean.FALSE).collect(Collectors.toList()));
		
		isRangeList.add(values.length == 4);
		boolean i  = isRangeList.contains(Boolean.FALSE);
		
		return !i;
	}
	
	public static boolean containsValues(List<Integer> list, Integer[] row)
	{
		List<Boolean> isContainsList = new ArrayList<>();
		for(int value : row)
		{
			isContainsList.add(list.contains(value));
		}
		
		return !isContainsList.contains(Boolean.FALSE);
	}
}
