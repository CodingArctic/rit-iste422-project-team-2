import java.util.StringTokenizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EdgeField {
   private int numFigure, tableID, tableBound, fieldBound, dataType, varcharValue;
   private String name, defaultValue;
   private boolean disallowNull, isPrimaryKey;
   private static String[] strDataType = {"Varchar", "Boolean", "Integer", "Double"};
   public static final int VARCHAR_DEFAULT_LENGTH = 1;
   public static Logger logger = LogManager.getLogger(EdgeField.class);
   
   public EdgeField(String inputString) {
      try {
      StringTokenizer st = new StringTokenizer(inputString, EdgeConvertFileParser.DELIM);
      numFigure = Integer.parseInt(st.nextToken());
      name = st.nextToken();
      tableID = 0;
      tableBound = 0;
      fieldBound = 0;
      disallowNull = false;
      isPrimaryKey = false;
      defaultValue = "";
      varcharValue = VARCHAR_DEFAULT_LENGTH;
      dataType = 0;
      logger.debug("EdgeField initialized, with inputString: " + inputString);
      } catch (Exception exc) {
         logger.error("EdgeField constructor failed: " + exc);
      }
   }
   
   public int getNumFigure() {
      return numFigure;
   }
   
   public String getName() {
      return name;
   }
   
   public int getTableID() {
      return tableID;
   }
   
   public void setTableID(int value) {
      logger.debug("tableID set from " + tableID + " to " + value);
      tableID = value;
   }
   
   public int getTableBound() {
      return tableBound;
   }
   
   public void setTableBound(int value) {
      logger.debug("tableBound set from " + tableBound + " to " + value);
      tableBound = value;
   }

   public int getFieldBound() {
      return fieldBound;
   }
   
   public void setFieldBound(int value) {
      logger.debug("fieldBound set from " + fieldBound + " to " + value);
      fieldBound = value;
   }

   public boolean getDisallowNull() {
      return disallowNull;
   }
   
   public void setDisallowNull(boolean value) {
      logger.debug("disallowNull set from " + disallowNull + " to " + value);
      disallowNull = value;
   }
   
   public boolean getIsPrimaryKey() {
      return isPrimaryKey;
   }
   
   public void setIsPrimaryKey(boolean value) {
      logger.debug("isPrimaryKey set from " + isPrimaryKey + " to " + value);
      isPrimaryKey = value;
   }
   
   public String getDefaultValue() {
      return defaultValue;
   }
   
   public void setDefaultValue(String value) {
      logger.debug("defaultValue set from " + defaultValue + " to " + value);
      defaultValue = value;
   }
   
   public int getVarcharValue() {
      return varcharValue;
   }
   
   public void setVarcharValue(int value) {
      if (value > 0) {
         logger.debug("varcharValue set from " + varcharValue + " to " + value);
         varcharValue = value;
      }
   }
   public int getDataType() {
      return dataType;
   }
   
   public void setDataType(int value) {
      if (value >= 0 && value < strDataType.length) {
         logger.debug("dataType set from " + dataType + " to " + value);
         dataType = value;
      }
   }
   
   public static String[] getStrDataType() {
      return strDataType;
   }
   
   public String toString() {
      return numFigure + EdgeConvertFileParser.DELIM +
      name + EdgeConvertFileParser.DELIM +
      tableID + EdgeConvertFileParser.DELIM +
      tableBound + EdgeConvertFileParser.DELIM +
      fieldBound + EdgeConvertFileParser.DELIM +
      dataType + EdgeConvertFileParser.DELIM +
      varcharValue + EdgeConvertFileParser.DELIM +
      isPrimaryKey + EdgeConvertFileParser.DELIM +
      disallowNull + EdgeConvertFileParser.DELIM +
      defaultValue;
   }
}
