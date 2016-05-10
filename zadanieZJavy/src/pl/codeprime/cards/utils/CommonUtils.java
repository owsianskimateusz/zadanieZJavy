package pl.codeprime.cards.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author codeprime
 *
 */
public class CommonUtils 
{

	static String regex1 ="[0-9]";
	String amountRegex = "{1,4}";
	static String regexMoreThanOneWhitespace ="[0-9, \\s]{2,}";
	
	
	public static boolean isEmpty(String line)
	{
		return line == null || line.isEmpty();
	}
	
	public static boolean isNotEmpty(String line)
	{
		boolean isEmptyLine = isEmpty(line);
		boolean isNotEmpty = !isEmptyLine;

		return isNotEmpty;
	}
	
	public static Integer[] convertToArray(String line)
	{
		line = removeMoreWhitespace(line);
		String[] split = line.split(" ");
		boolean isCorrect = split != null && split.length == ValidatorUtils.MAX_CARDS;
		Integer[] row = new Integer[ValidatorUtils.MAX_CARDS];
		
		if(isCorrect)
		{
			for(int i=0;i<ValidatorUtils.MAX_CARDS;i++)
			{
				row[i] = CommonUtils.convertStringToInt(split[i]);
			}
		}
		else
		{
			System.out.println(" nie poprawnie wprowadzono parametry ");
		}
		
		
		
		return row;
	}
	
	public static String removeMoreWhitespace(String line)
	{
		StringBuilder lineBuilder = new StringBuilder();
		
		if(line.matches(regexMoreThanOneWhitespace))
		{
			String[] split = line.split(" ");
			for(String splitedValue : split)
			{
				if(CommonUtils.isNotEmpty(splitedValue))
				{
					lineBuilder.append(splitedValue).append(" ");
				}
			}
		}
		else
		{
			lineBuilder.append(line);
		}
		
		return lineBuilder.toString();
	}
	
	public static int convertStringToInt(String valueToconvert)
	{
		int parseInt = 0;
		try
		{
			parseInt = Integer.parseInt(valueToconvert);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			parseInt = -1;
		}
		
		return parseInt;
	}
	
	@SuppressWarnings("resource")
	public static int readFromInputAsInt()
	{
		return new Scanner(System.in).nextInt();
	}
	
	@SuppressWarnings("resource")
	public static String readFromInputAsString()
	{
		return new Scanner(System.in).nextLine();
	}
	
	public static BufferedReader readerInput()
	{
		return  new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static BitSet obtainSameValues(Integer[] integers, Integer[] integers2)
	{
		BitSet bs1	 = convertToBitSet(integers);
		BitSet bs2 = convertToBitSet(integers2);
		
		bs1.and(bs2);
		return bs1;
	}
	
	
	public static String readAndCheckFromInput(BufferedReader readFromInput, int minRow, int maxRow, boolean inputAsArray) throws IOException
	{
		String value = null;
		
		boolean isCorrect = true;
		do
		{
			value = readFromInput.readLine();
			isCorrect = inputAsArray ? checkAndObtainArray(value) != null : ValidatorUtils.isInRange(convertStringToInt(value), minRow, maxRow) ;
			
			if(!isCorrect)
			{
				System.out.println(ValidatorUtils.reasonForIncorrectNumber(minRow, maxRow));
			}
		}while (!isCorrect) ;
		
		return value;
	}
	
	public static Integer[] checkAndObtainArray(String valueAsArray)
	{
		Integer[] array = convertToArray(valueAsArray);
		boolean inRange = ValidatorUtils.isInRange(array);
		
		return inRange ? array : null;
	}
	
	public static String obtainResult(BitSet resultSet, int numberOfTest)
	{
		String result = null;
		if(resultSet != null)
		{
			int length = resultSet.toLongArray().length;
			if(length == 1)
			{
				result = String.valueOf(resultSet.stream().findFirst().getAsInt());
			}
			else if(length > 1)
			{
				result ="Kiepski Magik";
			}
			else if(length == 0)
			{
				result = " Ochotnik oszukiwal ";
			}
		}
		return String.format("Przypadek #%d: %s", numberOfTest, result);
	}
	
	public static <X> List<X> asList(X[] x)
	{
		List<X> list = new ArrayList<X>();
		for(X value : x)
		{
			list.add(value);
		}
		
		return list;
	}
	
	public static BitSet convertToBitSet(Integer[] integers)
	{
		BitSet bs = new BitSet();
		for(int vallue : integers)
		{
			bs.set(vallue);
		}
		
		return bs;
	}
	
	public static <X> boolean checkContainsValue(List<X> list, X x)
	{
		return list.contains(x);
	}
}
