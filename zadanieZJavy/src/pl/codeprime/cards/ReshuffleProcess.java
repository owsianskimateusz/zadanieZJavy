package pl.codeprime.cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import pl.codeprime.cards.utils.CommonUtils;
import pl.codeprime.cards.utils.ValidatorUtils;

/**
 * 
 * @author Mateusz Owsianski
 *
 */
public class ReshuffleProcess 
{
	
	List<Integer> enteredVauesInShuffle;
	BufferedReader br;
	
	
	public ReshuffleProcess(BufferedReader br) throws IOException 
	{
		super();
		this.br = br;
		enteredVauesInShuffle = new ArrayList<>();
	}

	public void run(int numberOfTests) throws IOException
	{
		ReshuffleVO shuffle1 = obtainShuffle();
		ReshuffleVO shuffle2 = obtainShuffle();
		BitSet result = CommonUtils.obtainSameValues(shuffle1.obtainSelectedRow(), shuffle2.obtainSelectedRow());
		System.out.println(CommonUtils.obtainResult(result, numberOfTests+1));
	}
	
	private ReshuffleVO obtainShuffle() throws IOException 
	{
		String numberOfRowStr = CommonUtils.readAndCheckFromInput(br, 1, 4, false);
		Integer[][] rows = new Integer[ValidatorUtils.MAX__SIZE_CARDS][ValidatorUtils.MAX_CARDS];
		
		for(int i=0;i<4;i++)
		{
			rows[i] = readRow(br);
		}
		
		enteredVauesInShuffle = new ArrayList<>();
		ReshuffleVO reshuffleVo = new ReshuffleVO();
		reshuffleVo.setNumberOfRow(CommonUtils.convertStringToInt(numberOfRowStr));
		reshuffleVo.setRows(rows);
		
		return reshuffleVo;
	}
	
	private Integer[] readRow(BufferedReader br) throws IOException
	{
		String row = CommonUtils.readAndCheckFromInput(br, 1, 16,true);
		Integer[] array = CommonUtils.convertToArray(row);
		if(ValidatorUtils.containsValues(enteredVauesInShuffle, array))
		{
			System.err.println(ValidatorUtils.reasonForIncorrectArrays());
			readRow(br);
		}
		else
		{
			enteredVauesInShuffle.addAll(CommonUtils.asList(array));
		}
		
		return array;
	}
}
