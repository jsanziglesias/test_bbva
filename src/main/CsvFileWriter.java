package main;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import dtos.WordDto;

public class CsvFileWriter {

    //Delimiter used in CSV file

    private static final String COMMA_DELIMITER = ",";
    
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header

    private static final String FILE_HEADER = "Words,Unique,Weight";

  
   public static void writeCsvFile(String path, List<WordDto> dtos) {

	   PrintWriter pw = null;
	   try {
	       pw = new PrintWriter(new File(path));
	       StringBuilder sb = new StringBuilder();
            //Write the CSV file header

            sb.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            
            sb.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (WordDto dto : dtos) {

                sb.append(dto.getWord());

                sb.append(COMMA_DELIMITER);

                sb.append(dto.getUnique().toString().toUpperCase());

                sb.append(COMMA_DELIMITER);

                sb.append(dto.getWeight().toString());
                sb.append(NEW_LINE_SEPARATOR);

            }
            pw.write(sb.toString());
            pw.close();


        } catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            System.out.println("CSV file was created successfully !!!");

             

        }

    }

}
