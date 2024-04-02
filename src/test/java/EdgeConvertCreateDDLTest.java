import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdgeConvertCreateDDLTest {

    EdgeConvertCreateDDL edgeConvertCreateDDL;

    //subclass for testing EdgeConvertCreateDDL
    private static class TestEdgeConvertCreateDDL extends EdgeConvertCreateDDL {
        public TestEdgeConvertCreateDDL(EdgeTable[] tables, EdgeField[] fields) {
            super(tables != null ? tables : new EdgeTable[0], fields != null ? fields : new EdgeField[0]);
        }
        //return null for abstract methods
        @Override
        public String getDatabaseName() {
            return null;
        }

        @Override
        public String getProductName() {
            return null;
        }

        @Override
        public String getSQLString() {
            return null;
        }

        @Override
        public void createDDL() {
        }
    }

    @Before
    public void setUp() {
        EdgeTable[] tables = {
            new EdgeTable("1|Table1"),
            new EdgeTable("2|Table2")
        };
        
        EdgeField[] fields = {
            new EdgeField("1|Field1"),
            new EdgeField("2|Field2")
        };

        edgeConvertCreateDDL = new TestEdgeConvertCreateDDL(tables, fields);
    }

    @Test
    public void testInitialize() {
        edgeConvertCreateDDL.initialize();
    
        int[] expectedNumBoundTables = {0, 0}; 
        int expectedMaxBound = 0;
    
        assertArrayEquals(expectedNumBoundTables, edgeConvertCreateDDL.numBoundTables);
        assertEquals(expectedMaxBound, edgeConvertCreateDDL.maxBound);
    
        assertEquals("MySQL", EdgeConvertCreateDDL.products[0]);
        assertNotNull(edgeConvertCreateDDL.tables); 
        assertNotNull(edgeConvertCreateDDL.fields); 
        assertEquals(2, edgeConvertCreateDDL.tables.length); 
        assertEquals(2, edgeConvertCreateDDL.fields.length); 
        assertEquals("Table1", edgeConvertCreateDDL.tables[0].getName()); 
        assertEquals("Field1", edgeConvertCreateDDL.fields[0].getName()); 
    
        //tests for handling null inputs
        EdgeConvertCreateDDL nullDDL = new TestEdgeConvertCreateDDL(null, null);
        nullDDL.initialize();
        assertNotNull(nullDDL.tables);
        assertNotNull(nullDDL.fields);
        assertEquals(0, nullDDL.tables.length);
        assertEquals(0, nullDDL.fields.length);
    }

    @Test
    public void testGetTable() {
        //test tables
        EdgeTable table1 = new EdgeTable("1|Table1");
        EdgeTable table2 = new EdgeTable("2|Table2");
        EdgeTable[] tables = {table1, table2};

        EdgeConvertCreateDDL testEdgeConvertCreateDDL = new TestEdgeConvertCreateDDL(tables, null);

        //test getting existing table
        EdgeTable retrievedTable = testEdgeConvertCreateDDL.getTable(1);
        assertEquals(table1, retrievedTable);

        //test getting tables that dont exist
        retrievedTable = testEdgeConvertCreateDDL.getTable(3);
        assertNull(retrievedTable);
    }
    @Test
    public void testGetField() {
        EdgeField field1 = new EdgeField("1|Field1");
        EdgeField field2 = new EdgeField("2|Field2");
        EdgeField[] fields = {field1, field2};

        EdgeConvertCreateDDL testEdgeConvertCreateDDL = new TestEdgeConvertCreateDDL(null, fields);

        EdgeField retrievedField = testEdgeConvertCreateDDL.getField(1);
        assertEquals(field1, retrievedField);

        retrievedField = testEdgeConvertCreateDDL.getField(3);
        assertNull(retrievedField);
    }

}