import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunEdgeConvert {
   public static Logger logger = LogManager.getLogger(RunEdgeConvert.class);
   public static void main(String[] args) {
      logger.info("App starting");
      EdgeConvertGUI edge = new EdgeConvertGUI();
   }
}