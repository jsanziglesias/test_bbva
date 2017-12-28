package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.IOUtils;

import dtos.WordDto;

public class Main {

	private static String INPUT_PATH = "src/atdd/challenge_tests.csv";
	private static String OUTPUT_PATH = "src/atdd/challenge_sorted.csv";
	
	
	public static void main(String[] args) {

		StringManipulator stringManipulator = new StringManipulator();
		List<String> strList = readFromXls();
		List<WordDto> dtos = new ArrayList<WordDto>();
		List<String> sortList =stringManipulator.sortStrings( strList );
		
		for(String str: sortList){
			WordDto dto= new WordDto();
			dto.setUnique(stringManipulator.hasUniqueChars(str));
			dto.setWeight(stringManipulator.getWeight(str));
			dto.setWord(stringManipulator.cleanString(str));
			dtos.add(dto);			
		}
		writeToXls(dtos);
	}
	
	
	
	private static List<String> readFromXls(){
		return CSVReader.readCSV(INPUT_PATH);
	}
	
	private static void writeToXls(List<WordDto> dtos){
		byte[] aux = WordDtoExcel.createExcelFromWordDto(dtos);
		dumpToDisk(aux);
	}

	
	private static void dumpToDisk( byte[] fileContent) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(OUTPUT_PATH));
			fos.write(fileContent);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(fos);
		}
	}

}
