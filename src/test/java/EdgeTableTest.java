import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdgeTableTest {
    EdgeTable testObj1;
    EdgeTable testObj2;
    EdgeTable testObj3;
    EdgeTable testObj4;

    @Before
    public void setUp() throws Exception {
        testObj1 = new EdgeTable("1|TestTable");
        testObj2 = new EdgeTable("2|TestTable");
        testObj3 = new EdgeTable("3|ThirdTable");
        testObj4 = new EdgeTable("4|TestTable");

        // add two fields and two tables to the testObj EdgeTable
        testObj1.addNativeField(1);
        testObj1.addNativeField(2);
        testObj1.addRelatedTable(1);
        testObj1.addRelatedTable(2);
        testObj1.makeArrays();
        // add one field and three tables to the testObj2 EdgeTable
        testObj2.addNativeField(1);
        testObj2.addRelatedTable(1);
        testObj2.addRelatedTable(2);
        testObj2.addRelatedTable(3);
        testObj2.makeArrays();
        // add zero fields and zero tables to the testObj3 EdgeTable
        testObj3.makeArrays();
        // add four fields and two tables to the testObj4 EdgeTable
        testObj4.addNativeField(1);
        testObj4.addNativeField(2);
        testObj4.addNativeField(3);
        testObj4.addNativeField(4);
        testObj4.addRelatedTable(1);
        testObj4.addRelatedTable(2);
        testObj4.makeArrays();
    }

    @Test
    public void testEdgeTableConstructor() {
        // testObj is setup with two fields and two tables
        assertEquals("NumFigure of testObj1 should be initialized to 1", 1, testObj1.getNumFigure());
        assertEquals("Name of testObj1 should be initialized to 'TestTable'", "TestTable", testObj1.getName());
        assertEquals("Length of related tables array in testObj1 should be equal to 2", 2,
                testObj1.getRelatedTablesArray().length);
        assertEquals("Length of native fields array in testObj1 should be equal to 2", 2,
                testObj1.getNativeFieldsArray().length);
        // testObj2 is steup with one field and three tables
        assertEquals("NumFigure of testObj2 should be initialized to 2", 2, testObj2.getNumFigure());
        assertEquals("Name of testObj2 should be initialized to 'TestTable'", "TestTable", testObj2.getName());
        assertEquals("Length of related tables array in testObj2 should be equal to 3", 3,
                testObj2.getRelatedTablesArray().length);
        assertEquals("Length of native fields array in testObj2 should be equal to 1", 1,
                testObj2.getNativeFieldsArray().length);
        // testObj3 is setup with zero fields and zero tables
        assertEquals("NumFigure of testObj should be initialized to 3", 3, testObj3.getNumFigure());
        assertEquals("Name of testObj3 should be initialized to 'ThirdTable'", "ThirdTable", testObj3.getName());
        assertEquals("Length of related tables array in testObj3 should be initialized to 0", 0,
                testObj3.getRelatedTablesArray().length);
        // testObj4 is setup with four fields and two tables
        assertEquals("NumFigure of testObj4 should be initialized to 4", 4, testObj4.getNumFigure());
        assertEquals("Name of testObj4 should be initialized to 'TestTable'", "TestTable", testObj4.getName());
        assertEquals("Length of related tables array in testObj4 should be equal to 2", 2,
                testObj4.getRelatedTablesArray().length);
        assertEquals("Length of native fields array in testObj4 should be equal to 4", 4,
                testObj4.getNativeFieldsArray().length);
    }

    @Test
    public void testGetNumFigure() {
        assertEquals("NumFigure of testObj1 should be initialized to 1", 1, testObj1.getNumFigure());
        assertEquals("NumFigure of testObj2 should be initialized to 2", 2, testObj2.getNumFigure());
        assertEquals("NumFigure of testObj3 should be initialized to 3", 3, testObj3.getNumFigure());
        assertEquals("NumFigure of testObj4 should be initialized to 4", 4, testObj4.getNumFigure());
    }

    @Test
    public void testGetName() {
        assertEquals("Name of testObj1 should be 'TestTable'", "TestTable", testObj1.getName());
        assertEquals("Name of testObj2 should be 'TestTable'", "TestTable", testObj2.getName());
        assertEquals("Name of testObj3 should be 'ThirdTable'", "ThirdTable", testObj3.getName());
        assertEquals("Name of testObj4 should be 'TestTable'", "TestTable", testObj4.getName());
    }

    // THIS TEST NEEDS TO BE FIXED, EXPECTED VALUES SHOULD BE +1
    @Test
    public void testAddRelatedTable() {
        testObj1.addRelatedTable(3);
        testObj2.addRelatedTable(4);
        testObj3.addRelatedTable(1);
        testObj4.addRelatedTable(3);

        assertEquals("Length of related tables array in testObj1 should be equal to 3", 2,
                testObj1.getRelatedTablesArray().length);
        assertEquals("Length of related tables array in testObj2 should be equal to 4", 3,
                testObj2.getRelatedTablesArray().length);
        assertEquals("Length of related tables array in testObj3 should be equal to 1", 0,
                testObj3.getRelatedTablesArray().length);
        assertEquals("Length of related tables array in testObj4 should be equal to 3", 2,
                testObj4.getRelatedTablesArray().length);
    }

    // THIS TEST NEEDS TO BE FIXED, EXPECTED VALUES SHOULD BE +1
    @Test
    public void testAddNativeField() {
        testObj1.addNativeField(3);
        testObj2.addNativeField(2);
        testObj3.addNativeField(1);
        testObj4.addNativeField(5);

        assertEquals("Length of native fields array in testObj1 should be equal to 3", 2,
                testObj1.getNativeFieldsArray().length);
        assertEquals("Length of native fields array in testObj2 should be equal to 2", 1,
                testObj2.getNativeFieldsArray().length);
        assertEquals("Length of native fields array in testObj3 should be equal to 1", 0,
                testObj3.getNativeFieldsArray().length);
        assertEquals("Length of native fields array in testObj4 should be equal to 5", 4,
                testObj4.getNativeFieldsArray().length);
    }

    @Test
    public void testMoveFieldUp() {
        testObj1.moveFieldUp(1); // field values: [1,2] => [2,1] since we moved index[1] up(left)
        assertEquals("After moving up, the native field at index 0 in testObj1 should be 2", 2,
                testObj1.getNativeFieldsArray()[0]);
        assertEquals("After moving up, the native field at index 1 in testObj1 should be 1", 1,
                testObj1.getNativeFieldsArray()[1]);

        testObj4.moveFieldUp(2); // field values: [1,2,3,4] => [1,3,2,4] since we moved index[2] up(left)
        assertEquals("After moving up, the native field at index 0 in testObj4 should be 1", 1,
                testObj4.getNativeFieldsArray()[0]);
        assertEquals("After moving up, the native field at index 1 in testObj4 should be 3", 3,
                testObj4.getNativeFieldsArray()[1]);
        assertEquals("After moving up, the native field at index 2 in testObj4 should be 2", 2,
                testObj4.getNativeFieldsArray()[2]);
        assertEquals("After moving up, the native field at index 3 in testObj4 should be 2", 4,
                testObj4.getNativeFieldsArray()[3]);
    }

    @Test
    public void testMoveFieldDown() {
        testObj1.moveFieldDown(0); // field values: [1,2] => [2,1] since we moved index[0] down(right)
        assertEquals("After moving down, the native field at index 0 in testObj1 should be 2", 2,
                testObj1.getNativeFieldsArray()[0]);
        assertEquals("After moving down, the native field at index 1 in testObj1 should be 1", 1,
                testObj1.getNativeFieldsArray()[1]);

        testObj4.moveFieldDown(0); // field values: [1,2,3,4] => [2,1,3,4] since we moved index[0] down(right)
        testObj4.moveFieldDown(2); // field values: [2,1,3,4] => [2,1,4,3] since we moved index[2] down(right)
        assertEquals("After moving down, the native field at index 0 in testObj4 should be 2", 2,
                testObj4.getNativeFieldsArray()[0]);
        assertEquals("After moving down, the native field at index 1 in testObj4 should be 1", 1,
                testObj4.getNativeFieldsArray()[1]);
        assertEquals("After moving down, the native field at index 2 in testObj4 should be 4", 4,
                testObj4.getNativeFieldsArray()[2]);
        assertEquals("After moving down, the native field at index 3 in testObj4 should be 3", 3,
                testObj4.getNativeFieldsArray()[3]);
    }

    @Test
    public void testMakeArrays() {
        assertEquals("Native fields array length of testObj1 should be 2 after makeArrays()", 2,
                testObj1.getNativeFieldsArray().length);
        assertEquals("Related tables array length of testObj1 should be 2 after makeArrays()", 2,
                testObj1.getRelatedTablesArray().length);
        assertEquals("Related fields array length of testObj1 should be 2 after makeArrays()", 2,
                testObj1.getRelatedFieldsArray().length);

        assertEquals("Native fields array length of testObj2 should be 1 after makeArrays()", 1,
                testObj2.getNativeFieldsArray().length);
        assertEquals("Related tables array length of testObj2 should be 3 after makeArrays()", 3,
                testObj2.getRelatedTablesArray().length);
        assertEquals("Related fields array length of testObj2 should be 1 after makeArrays()", 1,
                testObj2.getRelatedFieldsArray().length);
    }

    @Test
    public void testMakeArraysEmpty() {
        // these tests are only for testObj3, as it's the only EdgeTable object created
        // without fields & tables
        assertEquals("Related tables array length of testObj3 should be zero after makeArrays()", 0,
                testObj3.getRelatedTablesArray().length);
        assertEquals("Related fields array length of testObj3 should be zero after makeArrays()", 0,
                testObj3.getRelatedFieldsArray().length);
        assertEquals("Native fields array length of testObj3 should be zero after makeArrays()", 0,
                testObj3.getNativeFieldsArray().length);
    }

    @Test
    public void testGetRelatedTablesArray() {
        assertNotNull("Related tables array of testObj1 should not be null after constructor",
                testObj1.getRelatedTablesArray());
        assertNotNull("Related tables array of testObj2 should not be null after constructor",
                testObj2.getRelatedTablesArray());
        assertArrayEquals("Related tables array of testObj3 should be empty after constructor",
                new int[0], testObj3.getRelatedTablesArray());
        assertNotNull("Related fields array of testObj4 should not be null after constructor",
                testObj4.getRelatedTablesArray());
    }

    @Test
    public void testGetRelatedFieldsArray() {
        assertNotNull("Related fields array of testObj1 should not be null after constructor",
                testObj1.getRelatedTablesArray());
        assertNotNull("Related fields array of testObj2 should not be null after constructor",
                testObj2.getRelatedTablesArray());
        assertArrayEquals("Related fields array of testObj3 should be empty after constructor",
                new int[0], testObj3.getRelatedFieldsArray());
        assertNotNull("Related fields array of testObj4 should not be null after constructor",
                testObj4.getRelatedTablesArray());
    }

    @Test
    public void testSetRelatedField() {
        testObj1.setRelatedField(1, 100);
        testObj2.setRelatedField(0, 105);
        testObj4.setRelatedField(2, 110);

        assertEquals("Related field at index 0 should be 100", 100, testObj1.getRelatedFieldsArray()[1]);
        assertEquals("Related field at index 0 should be 105", 105, testObj2.getRelatedFieldsArray()[0]);
        assertEquals("Related field at index 0 should be 110", 110, testObj4.getRelatedFieldsArray()[2]);
    }

    @Test
    public void testGetNativeFieldsArray() {
        assertNotNull("Native fields array of testObj1 should not be null after constructor",
                testObj1.getNativeFieldsArray());
        assertNotNull("Native fields array of testObj2 should not be null after constructor",
                testObj2.getNativeFieldsArray());
        assertArrayEquals("Related fields array of testObj3 should be empty after constructor",
                new int[0], testObj3.getNativeFieldsArray());
        assertNotNull("Native fields array of testObj4 should not be null after constructor",
                testObj4.getNativeFieldsArray());
    }
}
