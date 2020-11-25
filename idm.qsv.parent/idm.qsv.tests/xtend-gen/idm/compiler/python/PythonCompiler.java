package idm.compiler.python;

import com.google.common.io.Files;
import idm.qsv.Header;
import idm.qsv.QuerySeparatedValues;
import idm.qsv.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class PythonCompiler {
  private QuerySeparatedValues qsv;
  
  public PythonCompiler(final QuerySeparatedValues q) {
    this.qsv = q;
  }
  
  public void compileAndRun() throws IOException {
    String python = "";
    String _python = python;
    String _compile = this.compile(this.qsv.getHeader());
    python = (_python + _compile);
    EList<Statement> _statements = this.qsv.getStatements();
    for (final Statement s : _statements) {
      String _python_1 = python;
      Object _compile_1 = this.compile(s);
      python = (_python_1 + _compile_1);
    }
    String _python_2 = python;
    python = (_python_2 + "print(df)");
    String PYTHON_OUTPUT = "foo.py";
    this.writeToFileAndExecute(PYTHON_OUTPUT, python);
  }
  
  private String compile(final Header header) {
    String nameFile = this.qsv.getHeader().getNameFile();
    String code = "";
    String _code = code;
    code = (_code + "import pandas as pd\n");
    String _code_1 = code;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("df = pd.read_csv(\"");
    _builder.append(nameFile);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    code = (_code_1 + _builder);
    Boolean hasColumnName = Boolean.valueOf(header.isHasColumnName());
    return code;
  }
  
  private Object compile(final Statement statement) {
    return null;
  }
  
  private void writeToFileAndExecute(final String fileName, final String pythonCode) {
    try {
      byte[] _bytes = pythonCode.getBytes();
      File _file = new File(fileName);
      Files.write(_bytes, _file);
      Runtime _runtime = Runtime.getRuntime();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("python ");
      _builder.append(fileName);
      Process p = _runtime.exec(_builder.toString());
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
