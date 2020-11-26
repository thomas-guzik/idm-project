package idm.compiler;

@SuppressWarnings("all")
public class TerminalOutput {
  private String output;
  
  private String error;
  
  public TerminalOutput(final String stdOut, final String stdErr) {
    this.output = stdOut;
    this.error = stdErr;
  }
  
  public String getOutput() {
    return this.output;
  }
  
  public String getError() {
    return this.error;
  }
}
