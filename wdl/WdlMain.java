import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WdlMain {

  public static void usage() {
    System.err.println("Usage: java ParserMain <.wdl file> <ast,parsetree,graph>");
    System.exit(-1);
  }

  public static void main(String[] args) {

    if (args.length < 2) {
      usage();
    }

    try {
      CompositeTask wdl = new CompositeTask(new File(args[0]));

      if ( args[1].equals("ast") ) {
        Ast ast = wdl.getAst();
        System.out.println(ast.toPrettyString());
      } else if ( args[1].equals("parsetree") ) {
        ParseTree tree = wdl.getParseTree();
        System.out.println(tree.toPrettyString());
      } else if ( args[1].equals("graph") ) {
      } else {
        usage();
      }
    } catch (IOException error) {
      System.err.println(error);
      System.exit(-1);
    } catch (SyntaxError error) {
      System.err.println(error);
      System.exit(-1);
    }
  }
}