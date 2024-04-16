import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EdgeTable {
   private int numFigure;
   private String name;
   private List<Integer> relatedTables;
   private List<Integer> nativeFields;
   private int[] relatedFields;
   private static final Logger logger = LogManager.getLogger(EdgeTable.class);

   public EdgeTable(String inputString) {
      try {
         StringTokenizer st = new StringTokenizer(inputString, EdgeConvertFileParser.DELIM);
         numFigure = Integer.parseInt(st.nextToken());
         name = st.nextToken();
         relatedTables = new ArrayList<>();
         nativeFields = new ArrayList<>();
         logger.debug("EdgeTable initialized, with inputString: " + inputString);
      } catch (Exception exc) {
         logger.error("EdgeTable constructor failed: ", exc);
      }
   }

   public int getNumFigure() {
      return numFigure;
   }

   public String getName() {
      return name;
   }

   public void addRelatedTable(int relatedTable) {
      logger.debug("Adding related table " + relatedTable);
       relatedTables.add(relatedTable);
    }

    public int[] getRelatedTablesArray() {
         return relatedTables.stream().mapToInt(Integer::intValue).toArray();
      }

      public int[] getRelatedFieldsArray() {
         return relatedFields;
      }

      public void setRelatedField(int index, int relatedValue) {
         logger.debug("Adding related field " + relatedValue + " at " + index);
         relatedFields[index] = relatedValue;
      }

      public int[] getNativeFieldsArray() {
        return nativeFields.stream().mapToInt(Integer::intValue).toArray();
     }

     public void addNativeField(int value) {
        logger.debug("Adding native field " + value);
       nativeFields.add(value);
    }

    public void moveFieldUp(int index) {
       if (index == 0) {
          return;
       }
       swapFields(index, index - 1);
       logger.debug("EdgeTable Field moved up by " + index);
    }

     public void moveFieldDown(int index) {
        if (index == nativeFields.size() - 1) {
           return;
        }
       swapFields(index, index + 1);
       logger.debug("EdgeTable Field moved down by " + index);
    }

     private void swapFields(int index1, int index2) {
        int tempNative = nativeFields.get(index1);
        nativeFields.set(index1, nativeFields.get(index2));
        nativeFields.set(index2, tempNative);

       int tempRelated = relatedFields[index1];
       relatedFields[index1] = relatedFields[index2];
       relatedFields[index2] = tempRelated;
    }

     public void makeArrays() {
        relatedFields = new int[nativeFields.size()];
        logger.debug("Converted ArrayList into int[]");
     }

    @Override
     public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Table: ").append(numFigure).append("\r\n");
       sb.append("{\r\n");
       sb.append("TableName: ").append(name).append("\r\n");
       sb.append("NativeFields: ").append(joinIntegers(nativeFields)).append("\r\n");
       sb.append("RelatedTables: ").append(joinIntegers(relatedTables)).append("\r\n");
       sb.append("RelatedFields: ").append(joinIntegers(relatedFields)).append("\r\n");
       sb.append("}\r\n");

       return sb.toString();
    }

    private String joinIntegers(List<Integer> list) {
       StringBuilder result = new StringBuilder();
       for (int i = 0; i < list.size(); i++) {
          result.append(list.get(i));
          if (i < list.size() - 1) {
             result.append(EdgeConvertFileParser.DELIM);
          }
         }
         return result.toString();
      }

      private String joinIntegers(int[] array) {
         StringBuilder result = new StringBuilder();
         for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
               result.append(EdgeConvertFileParser.DELIM);
            }
         }
        return result.toString();
     }
}
