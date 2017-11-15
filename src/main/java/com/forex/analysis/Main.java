package com.forex.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import com.forex.analysis.calculator.mean.IMeanCalculator;
import com.forex.analysis.model.Tuple;
import com.forex.analysis.model.technical.Level;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class);
	 
	protected static final String FILE_PATH_INPUT = com.forex.analysis.util.AppProperties.getFilePathInput();
	protected static final String FILE_PATH_OUTPUT = com.forex.analysis.util.AppProperties.getFilePathOutput();
    	
	public static void main(String[] args) throws FileNotFoundException {
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

		List<Float> timeseries = new ArrayList<Float>();
        try {

            br = new BufferedReader(new FileReader(FILE_PATH_INPUT));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                timeseries.add(Float.parseFloat(data[0]));
            }

        } catch (FileNotFoundException e) {
        	logger.error("Can't find file in path: " + FILE_PATH_INPUT + " " + ExceptionUtils.getStackTrace(e));
        } catch (IOException e) {
        	logger.error("Can't parse file " + ExceptionUtils.getStackTrace(e));
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                	logger.error("Can't close file " + ExceptionUtils.getStackTrace(e));
                }
            }
        }
        SupportResistanceCalculator sda = new SupportResistanceCalculator(null, new IMeanCalculator());
        Tuple<List<Level>, List<Level>> levels = sda.identify(timeseries, 0, timeseries.size(), 5, Float.parseFloat("1.2"));

        PrintWriter pw = new PrintWriter(new File(FILE_PATH_OUTPUT));
        //write results to the file
        try {
	        StringBuilder sb = new StringBuilder();
	        if (levels.getA().size() > 0) {
		        for (Level level : levels.getA()) {
		
		            sb.append(level.getType());
		            sb.append(',');
		            sb.append(level.getLevel());
		            sb.append(',');
		            sb.append(level.getStrength());
		            sb.append('\n');
		        }
	        }
	        
	        if (levels.getB().size() > 0) {
		        for (Level level : levels.getB()) {
		
		            sb.append(level.getType());
		            sb.append(',');
		            sb.append(level.getLevel());
		            sb.append(',');
		            sb.append(level.getStrength());
		            sb.append('\n');
		        }
	        }
	
	        pw.write(sb.toString());
        } finally {
            pw.close();
        }
	}

}
