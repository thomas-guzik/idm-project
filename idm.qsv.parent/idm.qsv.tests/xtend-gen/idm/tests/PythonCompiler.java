package idm.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.io.Files;

import idm.qsv.QuerySeparatedValues;
import idm.qsv.Statement;

public class PythonCompiler {
	private QuerySeparatedValues qsv;

	PythonCompiler(QuerySeparatedValues q) {
		qsv = q;
	}

	public void compileAndRun() throws IOException {
		String python = "";
		
		String nameFile = qsv.getHeader().getNameFile();
		Boolean hasColumnName = qsv.getHeader().isHasColumnName();
		
		python += "import pandas as pd\n";
		python += "df = pd.read_csv(\"" + nameFile + "\")\n";
		
		for(Statement s : qsv.getStatements()) {
			// s.compile();
		}
		
		python += "print(df)";

		// serialize code into Python filename
		String PYTHON_OUTPUT = "foo.py";
		/*
		 * FileWriter fw = new FileWriter(PYTHON_OUTPUT); fw.write(pythonCode);
		 * fw.flush(); fw.close();
		 */
		// or shorter
		Files.write(python.getBytes(), new File(PYTHON_OUTPUT));

		// execute the generated Python code
		// roughly: exec "python foo.py"

		Process p = Runtime.getRuntime().exec("python " + PYTHON_OUTPUT);

		// output
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// error
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		String o;
		while ((o = stdInput.readLine()) != null) {
			System.out.println(o);
		}

		String err;
		while ((err = stdError.readLine()) != null) {
			System.out.println(err);
		}
	}
}
