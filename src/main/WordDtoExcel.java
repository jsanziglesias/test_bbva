package main;

import java.util.ArrayList;
import java.util.List;

import dtos.WordDto;

public class WordDtoExcel {

	
	
	public static byte[] createExcelFromWordDto(List<WordDto> dtos){
		ArrayList<ArrayList<String>> obj = new ArrayList<>();
		ArrayList<String> header = new ArrayList<String>();
		header.add("Words");
		header.add("Unique");
		header.add("Weight");
		obj.add(header);
		for(WordDto dto: dtos){
			ArrayList<String> row = new ArrayList<String>();
			row.add(dto.getWord());
			row.add(dto.getUnique().toString().toUpperCase());
			row.add(dto.getWeight().toString());
			obj.add(row);
		}
		return ApachePOIExcelWrite.createExcel(toArray2D(obj));
	}
	
	
	private static Object[][] toArray2D(ArrayList<ArrayList<String>> arrayList){
		Object[][] array = new Object[arrayList.size()][];
		for (int i = 0; i < arrayList.size(); i++) {
			ArrayList<String> row = arrayList.get(i);
			array[i] = row.toArray(new String[row.size()]);
		}
		return array;
	}
}
