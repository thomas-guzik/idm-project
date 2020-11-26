package idm.compiler;

import com.google.common.io.Files;
import idm.compiler.TerminalOutput;
import idm.qsv.Column;
import idm.qsv.ColumnName;
import idm.qsv.Columns;
import idm.qsv.Header;
import idm.qsv.Lines;
import idm.qsv.Print;
import idm.qsv.QuerySeparatedValues;
import idm.qsv.Selector;
import idm.qsv.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class BashCompiler {
  private QuerySeparatedValues qsv;
  
  private String csvDataVariable;
  
  private String separator;
  
  private Boolean hasColumnName;
  
  private String[] cols;
  
  private String[] lines;
  
  public BashCompiler() {
  }
  
  public BashCompiler(final QuerySeparatedValues q) {
    this.qsv = q;
  }
  
  public BashCompiler setQsv(final QuerySeparatedValues q) {
    this.qsv = q;
    return this;
  }
  
  public TerminalOutput run(final String code) {
    return this.executeOnFile(code, "tmp.sh");
  }
  
  public String compile() {
    String code = "";
    String _code = code;
    String _compile = this.compile(this.qsv.getHeader());
    code = (_code + _compile);
    EList<Statement> _statements = this.qsv.getStatements();
    for (final Statement s : _statements) {
      String _code_1 = code;
      String _compile_1 = this.compile(s);
      code = (_code_1 + _compile_1);
    }
    return code;
  }
  
  public String compile(final Header header) {
    String code = "";
    String nameFile = this.qsv.getHeader().getNameFile();
    this.hasColumnName = Boolean.valueOf(header.isHasColumnName());
    this.separator = ",";
    String _code = code;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("OLD_IFS=$IFS");
    code = (_code + _builder);
    if ((this.hasColumnName).booleanValue()) {
      String _code_1 = code;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("IFS=\"");
      _builder_1.append(this.separator);
      _builder_1.append("\" read -a columnNames <<< head -1 ");
      _builder_1.append(nameFile);
      code = (_code_1 + _builder_1);
    }
    String _code_2 = code;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("f=cat   ");
    _builder_2.append(nameFile);
    code = (_code_2 + _builder_2);
    return code;
  }
  
  public String compile(final Statement statement) {
    return null;
  }
  
  public String compile(final Print print) {
    this.compile(print.getSelector());
    return "rien";
  }
  
  public Object compile(final Selector selector) {
    Object _xblockexpression = null;
    {
      Columns columnSelection = selector.getColumnSelection();
      Lines lineSelection = selector.getLineSelection();
      if ((columnSelection == null)) {
        this.cols = new String[] {};
      } else {
        final Consumer<Column> _function = (Column e) -> {
          this.compile(e);
        };
        columnSelection.getColumns().forEach(_function);
      }
      Object _xifexpression = null;
      if ((lineSelection == null)) {
        _xifexpression = null;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String compile(final Column c) {
    return InputOutput.<String>println("what happend ?");
  }
  
  public Object compile(final ColumnName c) {
    return null;
  }
  
  public TerminalOutput executeOnFile(final String code, final String filename) {
    try {
      byte[] _bytes = code.getBytes();
      File _file = new File(filename);
      Files.write(_bytes, _file);
      Runtime _runtime = Runtime.getRuntime();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("bash ");
      _builder.append(filename);
      Process p = _runtime.exec(_builder.toString());
      InputStream _inputStream = p.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader stdInput = new BufferedReader(_inputStreamReader);
      InputStream _errorStream = p.getErrorStream();
      InputStreamReader _inputStreamReader_1 = new InputStreamReader(_errorStream);
      BufferedReader stdError = new BufferedReader(_inputStreamReader_1);
      String o = null;
      String output = "";
      while (((o = stdInput.readLine()) != null)) {
        {
          String _output = output;
          output = (_output + (o + "\n"));
          InputOutput.<String>println(o);
        }
      }
      String err = null;
      String error = "";
      while (((err = stdError.readLine()) != null)) {
        {
          String _error = error;
          error = (_error + (err + "\n"));
          InputOutput.<String>println(err);
        }
      }
      return new TerminalOutput(output, error);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
