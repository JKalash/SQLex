import org.antlr.runtime.*;
import java.util.*;
import java.io.*;

public class TestSQL {
	
	//Given a string tells uf if it is convertible into a number
	public static boolean isDouble(String s) {
		try { 
			Double.parseDouble(s); 
		} catch(NumberFormatException e) { 
			return false; 
		}
		// only got here if we didn't return false
		return true;
	}
	
	//Returns the boolean result of a condition passed
	public static boolean condition_met(String attribute, String operator, String constant) {
		//Check if we are dealing with numbers
		if(isDouble(attribute)) {
			double new_attribute = Double.parseDouble(attribute);
			double new_constant = Double.parseDouble(constant);
			// '=' | '!=' | '>' | '>=' | '<' | '<=' 
			if(operator.equals("=")) 	return new_attribute == new_constant;
			if(operator.equals("!="))  return new_attribute != new_constant;
			if(operator.equals(">")) 	return new_attribute > new_constant;
			if(operator.equals(">=")) return new_attribute >= new_constant;
			if(operator.equals("<")) 	return new_attribute < new_constant;
			if(operator.equals("<=")) return new_attribute <= new_constant;
		}
		else {
			//Remove Double quotes
			constant = constant.replaceAll("\"", "");
			if(operator.equals("=")) 	return attribute.equals(constant);
			if(operator.equals("!="))  return !attribute.equals(constant);
		}

		//Something went wrong, exit with status 0
		return false;
	}
	
	//Method that outputs the row values of passed attribute list and an index
	//if index is -1 --> Print all rows
	//If attributes List contains 1 string '*' then output all attributes
	public static void printRowAtIndex(List<HashMap<String, String>> rows, List<String> attributes,  int index) {
		//Print all rows
		if (index == -1) {
			for(HashMap<String, String> row: rows) {
				//Loop over requested attributes, and print their row equivalent
				for (String passedAttribute: attributes) {
					if(passedAttribute == "*") {
						for(String key: row.keySet())
							System.out.print(row.get(key)+ "\t");
					}
					else if(row.keySet().contains(passedAttribute)) {
						System.out.print(row.get(passedAttribute)+ "\t");
					}
				}
				System.out.print("\n");
			}
			return;
		}
		
		HashMap<String, String> row = rows.get(index);
		//Loop over requested attributes, and print their row equivalent
		for (String passedAttribute: attributes) {
			if(passedAttribute == "*") {
				for(String key: row.keySet())
					System.out.print(row.get(key)+ "\t");
			}
			else if(row.keySet().contains(passedAttribute)) {
				System.out.print(row.get(passedAttribute)+ "\t");
			}
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) throws Exception {

		// Create an TLexer that feeds from that stream
	        //TLexer lexer = new TLexer(new ANTLRInputStream(System.in));
	        SQLLexer lexer = new SQLLexer(new ANTLRFileStream("input.txt"));

	        // Create a stream of tokens fed by the lexer
	        CommonTokenStream tokens = new CommonTokenStream(lexer);

	        // Create a parser that feeds off the token stream
	        SQLParser parser = new SQLParser(tokens);

		// Begin parsing at rule eval
		Hashtable<String, String> result = parser.eval();
		
		String attributesList = result.get("attribute");
		//Convert requested attribute list from a list of CSVs to an array
		List<String> attList = new ArrayList<String>(Arrays.asList(attributesList.split(", ")));
		
		List<String> attributes = null;
		BufferedReader reader = null;
	
		String fileName = result.get("table");
		File file = new File(fileName+".txt");
		//List of associative arrays that will contain all rows in the file (DB)
		List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
	
		//Try opening and reading from file
		try {
			reader = new BufferedReader(new FileReader(file));
			//Read first line from file, split on whitespace and insert resulting array into our attributes List
			attributes = new ArrayList<String>(Arrays.asList(reader.readLine().split(" ")));
		
			String text = null;
			while ((text = reader.readLine()) != null) {
				List<String> columns = new ArrayList<String>(Arrays.asList(text.split(" ")));
				HashMap<String, String> associativeRow = new HashMap<String, String>();
				for(int i=0; i<columns.size(); i++) {
					associativeRow.put(attributes.get(i), columns.get(i));
				}
				rows.add(associativeRow);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
	
		//txt file containing the DB has now been placed in in a List rows, each row being a  Hashmap (attribute_name=>value)
		//We can now output to the user what he needs
	
		//No where condition was specified
		if(result.get("where_attribute") == null)
			printRowAtIndex(rows,attList, -1);
	
		//Where condition was sepcified
		else {
			String where_attribute = result.get("where_attribute");
			String where_operator = result.get("where_operator");
			String where_constant = result.get("where_constant");
			int i = 0;
			//Loop over each row
			for(HashMap<String, String> row: rows) {
				//If condition is met, print the row
				if(condition_met(row.get(where_attribute), where_operator, where_constant)) {
					printRowAtIndex(rows, attList, i);
				}
				i++;
			}
		}
	}
}

