package idm.compiler;

import com.google.common.io.Files;
import idm.compiler.TerminalOutput;
import idm.qsv.Column;
import idm.qsv.ColumnNames;
import idm.qsv.ColumnNumbers;
import idm.qsv.Columns;
import idm.qsv.Condition;
import idm.qsv.Header;
import idm.qsv.Line;
import idm.qsv.LineRange;
import idm.qsv.Lines;
import idm.qsv.Print;
import idm.qsv.QuerySeparatedValues;
import idm.qsv.Selector;
import idm.qsv.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
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
    String nameFile = header.getNameFile();
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
    this.initializeVariable();
    this.compile(print.getSelector());
    return this.generatePrintCode();
  }
  
  public String[] initializeVariable() {
    String[] _xblockexpression = null;
    {
      this.cols = new String[] {};
      _xblockexpression = this.lines = new String[] {};
    }
    return _xblockexpression;
  }
  
  public String compile(final Selector selector) {
    String code = "";
    Columns columnSelection = selector.getColumnSelection();
    Lines lineSelection = selector.getLineSelection();
    if ((columnSelection != null)) {
      Column columns = columnSelection.getColumns();
      if ((columns == null)) {
        this.cols = new String[] {};
      } else {
        this.compile(columns);
      }
    }
    if ((lineSelection != null)) {
      LineRange range = lineSelection.getRange();
      Line line = lineSelection.getLine();
      Condition cond = lineSelection.getCond();
    }
    return code;
  }
  
  public String compile(final Column c) {
    return InputOutput.<String>println("what happend ?");
  }
  
  public void compile(final ColumnNames c) {
    EList<String> names = c.getNames();
    final Consumer<String> _function = (String n) -> {
      ((List<String>)Conversions.doWrapArray(this.cols)).add(n);
    };
    names.forEach(_function);
  }
  
  public void compile(final ColumnNumbers c) {
    EList<String> numbers = c.getNumbers();
    final Consumer<String> _function = (String n) -> {
      ((List<String>)Conversions.doWrapArray(this.cols)).add(n);
    };
    numbers.forEach(_function);
  }
  
  public String generatePrintCode() {
    String code = "n=0\n";
    String _code = code;
    code = (_code + "while read");
    String colCode = "";
    boolean _isEmpty = ((List<String>)Conversions.doWrapArray(this.cols)).isEmpty();
    if (_isEmpty) {
      String _code_1 = code;
      code = (_code_1 + " line\n");
      String _colCode = colCode;
      colCode = (_colCode + "echo $line\n");
    } else {
      String _colCode_1 = colCode;
      colCode = (_colCode_1 + "");
    }
    String _code_2 = code;
    code = (_code_2 + "do\n");
    boolean _isEmpty_1 = ((List<String>)Conversions.doWrapArray(this.lines)).isEmpty();
    if (_isEmpty_1) {
      String _code_3 = code;
      code = (_code_3 + colCode);
    } else {
      int _size = ((List<String>)Conversions.doWrapArray(this.lines)).size();
      boolean _equals = (_size == 1);
      if (_equals) {
        String _code_4 = code;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("if[ $n -eq ");
        String _get = this.lines[0];
        _builder.append(_get);
        _builder.append(" ]");
        code = (_code_4 + _builder);
      } else {
        String _code_5 = code;
        code = (_code_5 + "if ");
      }
      String _code_6 = code;
      code = (_code_6 + "then\n");
      String _code_7 = code;
      code = (_code_7 + colCode);
      String _code_8 = code;
      code = (_code_8 + "fi\n");
    }
    String _code_9 = code;
    code = (_code_9 + "done");
    return code;
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
