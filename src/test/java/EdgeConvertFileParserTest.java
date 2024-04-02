import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EdgeConvertFileParserTest {
    EdgeConvertFileParser testParser;
    EdgeTable testTable;

    @Before
    public void mkTestParser() {
        testParser = new EdgeConvertFileParser(new File("TestSave.sav"));
        testTable = testParser.getEdgeTables()[0];
    }

    @Test
    public void testTableNameOk() {
        String tableName = "TEST";
        assertTrue("Test table name is " + testTable.getName() + ", expected " + tableName, testTable.getName().equals(tableName));
    }

    @Test
    public void testTableNativeFieldsOk() {
        int[] correctNativeFields = {2,3,4,5};
        int[] tableNativeFields = new int[4];
        int i = 0;
        for (int j : testTable.getNativeFieldsArray()) {
            tableNativeFields[i] = j;
            i++;
        }
        assertArrayEquals("Test table field IDs do not match expected", correctNativeFields, tableNativeFields);
    }

    @Test
    public void testNoRelations() {
        assertArrayEquals("Test table has related tables, none expected", new int[0], testTable.getRelatedTablesArray());
        assertArrayEquals("Test table has related fields, none expected", new int[0], testTable.getRelatedFieldsArray());
    }

    /*@Test
    public void testVarcharField() {
        int[] correctVarcharField = {};
        int[] tableNativeFields = new int[4];
        int i = 0;
        for (int j : testTable.getNativeFieldsArray()) {
            tableNativeFields[i] = j;
            i++;
        }
        testParser.getEdgeFields()[2].
        assertArrayEquals("Test table field IDs do not match expected", correctVarcharField, tableVarcharField);
    }*/
}
