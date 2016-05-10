package pl.codeprime.cards;

import java.io.BufferedReader;
import java.io.IOException;

import pl.codeprime.cards.utils.CommonUtils;

public class RunMain 
{
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader readInput = CommonUtils.readerInput();
		String amountTestsStr = CommonUtils.readAndCheckFromInput(readInput, 1, 100,false);
		int amountTests = CommonUtils.convertStringToInt(amountTestsStr);
		
		ReshuffleProcess process = new ReshuffleProcess(readInput);
		for(int i=0;i<amountTests;i++)
		{
			process.run(i);
		}
	}
	
}
