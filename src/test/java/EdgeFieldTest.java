import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class EdgeFieldTest {
    EdgeField edgeField;
    EdgeField edgeField2;

    @Before
    public void before() {
        edgeField = new EdgeField("1|testFieldName|2|1|false|true");
        edgeField2 = new EdgeField("2|anotherTestFieldName|10|4|true|false");
    }

    @Test
    public void testGetNumFigure () {
        assertEquals("numFigure should be set to 1", 1, edgeField.getNumFigure());
    }

    @Test
    public void testGetName () {
        assertEquals("name should be set to 'testFieldName'", "testFieldName", edgeField.getName());
    }

    @Test
    public void testGetTableID () {
        assertEquals("tableID should be set to 0", 0, edgeField.getTableID());
    }

    @Test
    public void testGetTableBound () {
        assertEquals("tableBound should be set to 0", 0, edgeField.getTableBound());
    }

    @Test
    public void testGetFieldBound () {
        assertEquals("fieldBound should be set to 0", 0, edgeField.getFieldBound());
    }

    @Test
    public void testGetDisallowNull () {
        assertEquals("disallowNull should be set to false", false, edgeField.getDisallowNull());
    }
    
    @Test
    public void testGetIsPrimaryKey () {
        assertEquals("isPrimaryKey should be set to false", false, edgeField.getIsPrimaryKey());
    }

    @Test
    public void testGetDefaultValue () {
        assertEquals("defaultValue should be blank", "", edgeField.getDefaultValue());
    }

    @Test
    public void testGetVarcharValue () {
        assertEquals("varcharValue should be set to 1", 1, edgeField.getVarcharValue());
    }

    @Test
    public void testGetDataType () {
        assertEquals("dataType should be set to 0", 0, edgeField.getDataType());
    }

    @Test
    public void testGetNumFigure2 () {
        assertEquals("numFigure should be set to 2", 2, edgeField2.getNumFigure());
    }

    @Test
    public void testGetName2 () {
        assertEquals("name should be set to 'testFieldName'", "anotherTestFieldName", edgeField2.getName());
    }

    @Test
    public void testGetTableID2 () {
        assertEquals("tableID should be set to 0", 0, edgeField2.getTableID());
    }

    @Test
    public void testGetTableBound2 () {
        assertEquals("tableBound should be set to 0", 0, edgeField2.getTableBound());
    }

    @Test
    public void testGetFieldBound2 () {
        assertEquals("fieldBound should be set to 0", 0, edgeField2.getFieldBound());
    }

    @Test
    public void testGetDisallowNull2 () {
        assertEquals("disallowNull should be set to false", false, edgeField2.getDisallowNull());
    }
    
    @Test
    public void testGetIsPrimaryKey2 () {
        assertEquals("isPrimaryKey should be set to false", false, edgeField2.getIsPrimaryKey());
    }

    @Test
    public void testGetDefaultValue2 () {
        assertEquals("defaultValue should be blank", "", edgeField2.getDefaultValue());
    }

    @Test
    public void testGetVarcharValue2 () {
        assertEquals("varcharValue should be set to 1", 1, edgeField2.getVarcharValue());
    }

    @Test
    public void testGetDataType2 () {
        assertEquals("dataType should be set to 0", 0, edgeField2.getDataType());
    }

    @Test
    public void testSetTableID() {
        edgeField.setTableID(2);
        assertEquals("tableID should be set to 2", 2, edgeField.getTableID());
    }

    @Test
    public void testSetTableBound() {
        edgeField.setTableBound(5);
        assertEquals("tableBound should be set to 5", 5, edgeField.getTableBound());
    }

    @Test
    public void testSetFieldBound() {
        edgeField.setFieldBound(2);
        assertEquals("fieldBound should be set to 2", 2, edgeField.getFieldBound());
    }

    @Test
    public void testSetDisallowNull() {
        edgeField.setDisallowNull(true);
        assertEquals("disallowNull should be set to true", true, edgeField.getDisallowNull());
    }

    @Test
    public void testSetIsPrimaryKey() {
        edgeField.setIsPrimaryKey(true);
        assertEquals("isPrimaryKey should be set to true", true, edgeField.getIsPrimaryKey());
    }

    @Test
    public void testSetDefaultValue() {
        edgeField.setDefaultValue("default");
        assertEquals("defaultValue should be set to 'default'", "default", edgeField.getDefaultValue());
    }

    @Test
    public void testSetVarcharValue() {
        edgeField.setVarcharValue(10);
        assertEquals("varcharValue should be set to 10", 10, edgeField.getVarcharValue());
    }

    @Test
    public void testSetDataType() {
        edgeField.setDataType(1);
        assertEquals("dataType should be set to 1", 1, edgeField.getDataType());
    }

    @Test
    public void testSetTableID2() {
        edgeField2.setTableID(15);
        assertNotEquals("tableID should not be set to 0", 0, edgeField2.getTableID());
    }

    @Test
    public void testSetTableBound2() {
        edgeField2.setTableBound(10);
        assertNotEquals("tableBound should not be set to 0", 0, edgeField2.getTableBound());
    }

    @Test
    public void testSetFieldBound2() {
        edgeField2.setFieldBound(5);
        assertNotEquals("fieldBound should not be set to 0", 0, edgeField2.getFieldBound());
    }

    @Test
    public void testSetDisallowNull2() {
        edgeField2.setDisallowNull(true);
        assertNotEquals("disallowNull should not be set to false", false, edgeField2.getDisallowNull());
    }

    @Test
    public void testSetIsPrimaryKey2() {
        edgeField2.setIsPrimaryKey(true);
        assertNotEquals("isPrimaryKey should not be set to false", false, edgeField2.getIsPrimaryKey());
    }

    @Test
    public void testSetDefaultValue2() {
        edgeField2.setDefaultValue("default");
        assertNotEquals("defaultValue should not be blank", "", edgeField2.getDefaultValue());
    }

    @Test
    public void testSetVarcharValue2() {
        edgeField2.setVarcharValue(10);
        assertNotEquals("varcharValue should not be set to 1", 1, edgeField2.getVarcharValue());
    }

    @Test
    public void testSetDataType2() {
        edgeField2.setDataType(1);
        assertNotEquals("dataType should not be set to 0", 0, edgeField2.getDataType());
    }

}
