import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EdgeConvertFileParserTest {
    EdgeConvertFileParser testParser;
    EdgeTable table1;

    @Before
    public void mkTestParser() {
        testParser = new EdgeConvertFileParser(new File("TestSave.sav"));
        table1 = testParser.getEdgeTables()[0];
    }

    @Test
    public void testTableNameOk() {
        String tableName = "TEST";
        assertTrue("Test table name is " + table1.getName() + ", expected " + tableName, table1.getName().equals(tableName));
    }

    @Test
    public void testTableNativeFieldsOk() {
        int[] correctNativeFields = {2,3,4,5};
        int[] tableNativeFields = new int[4];
        int i = 0;
        for (int j : table1.getNativeFieldsArray()) {
            tableNativeFields[i] = j;
            i++;
        }
        assertArrayEquals("Test table field IDs do not match expected", correctNativeFields, tableNativeFields);
    }

    @Test
    public void testNoRelations() {
        int[] noRelsExpected = {0,0,0,0};
        //Different methods used because fields requires an array of zeros, tables uses an empty array
        assertTrue("Test table has related tables, none expected", table1.getRelatedTablesArray().length == 0);
        assertArrayEquals("Test table has related fields, none expected", noRelsExpected, table1.getRelatedFieldsArray());
    }

    @Test
    public void testAllFieldsCorrect() {
        // Varchar
        EdgeField varcharExpected = new EdgeField("2|TestVarchar");
        varcharExpected.setTableID(1);
        varcharExpected.setTableBound(0);
        varcharExpected.setFieldBound(0);
        varcharExpected.setDefaultValue("testVarcharText");
        varcharExpected.setVarcharValue(16);

        EdgeField varcharActual = testParser.getEdgeFields()[0];
        assertEquals("Varchar values mismatched", varcharExpected.toString(), varcharActual.toString());

        // Boolean
        EdgeField booleanExpected = new EdgeField("3|TestBoolean");
        booleanExpected.setTableID(1);
        booleanExpected.setTableBound(0);
        booleanExpected.setFieldBound(0);
        booleanExpected.setDataType(1);
        booleanExpected.setDefaultValue("true");

        EdgeField booleanActual = testParser.getEdgeFields()[1];
        assertEquals("Boolean values mismatched", booleanExpected.toString(), booleanActual.toString());

        // Integer (no default)
        EdgeField integerExpected = new EdgeField("4|TestInteger");
        integerExpected.setTableID(1);
        integerExpected.setTableBound(0);
        integerExpected.setFieldBound(0);
        integerExpected.setDataType(2);

        // Double (no default)
        EdgeField doubleExpected = new EdgeField("4|TestInteger");
        doubleExpected.setTableID(1);
        doubleExpected.setTableBound(0);
        doubleExpected.setFieldBound(0);
        doubleExpected.setDataType(3);
        doubleExpected.setDefaultValue("1.234");

        EdgeField intActual = testParser.getEdgeFields()[2];
        assertEquals("Boolean values mismatched", integerExpected.toString(), intActual.toString());
    }

    @Test
    public void testRelations() {
        EdgeTable table6 = testParser.getEdgeTables()[1];
        EdgeTable table7 = testParser.getEdgeTables()[2];

        int[] expectedTable6RelFields = {10,11};
        int[] table6RelFields = table6.getRelatedFieldsArray();
        assertArrayEquals("Table 6 (REL1) related fields do not match expected", expectedTable6RelFields, table6RelFields);   
        //first rel only 1 way, so 0 is a required placeholder to make the second pair correct
        int[] expectedTable7RelFields = {0,9};
        int[] table7RelFields = table7.getRelatedFieldsArray();
        assertArrayEquals("Table 7 (REL2) related fields do not match expected", expectedTable7RelFields, table7RelFields);   
    }
}
