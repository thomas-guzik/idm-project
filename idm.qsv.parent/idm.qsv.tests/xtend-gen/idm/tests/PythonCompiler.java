package idm.tests;

import com.google.common.io.Files;
import idm.qsv.QuerySeparatedValues;
import idm.qsv.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PythonCompiler {
  private QuerySeparatedValues qsv;
  
  PythonCompiler(final QuerySeparatedValues q) {
    this.qsv = q;
  }
  
  public void compileAndRun() throws IOException {
    String python = "";
    String nameFile = this.qsv.getHeader().getNameFile();
    Boolean hasColumnName = Boolean.valueOf(this.qsv.getHeader().isHasColumnName());
    String _python = python;
    python = (_python + "import pandas as pd\n");
    String _python_1 = python;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("df = pd.read_csv(\"");
    _builder.append(nameFile);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    python = (_python_1 + _builder);
    EList<Statement> _statements = this.qsv.getStatements();
    for (final Statement s : _statements) {
    }
    String _python_2 = python;
    python = (_python_2 + "print(df)");
    String PYTHON_OUTPUT = "foo.py";
    byte[] _bytes = python.getBytes();
    File _file = new File(PYTHON_OUTPUT);
    Files.write(_bytes, _file);
    Runtime _runtime = Runtime.getRuntime();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("python ");
    _builder_1.append(PYTHON_OUTPUT);
    Process p = _runtime.exec(_builder_1.toString());
    InputStream _inputStream = p.getInputStream();
    InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
    BufferedReader stdInput = new BufferedReader(_inputStreamReader);
    InputStream _errorStream = p.getErrorStream();
    InputStreamReader _inputStreamReader_1 = new InputStreamReader(_errorStream);
    BufferedReader stdError = new BufferedReader(_inputStreamReader_1);
    String o = null;
    while (((o = stdInput.readLine()) != null)) {
      System.out.println(o);
    }
    String err = null;
    while (((err = stdError.readLine()) != null)) {
      System.out.println(err);
    }
  }
}
