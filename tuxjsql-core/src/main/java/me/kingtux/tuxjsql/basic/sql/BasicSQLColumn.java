package me.kingtux.tuxjsql.basic.sql;

import me.kingtux.tuxjsql.core.sql.SQLColumn;
import me.kingtux.tuxjsql.core.sql.SQLDataType;
import me.kingtux.tuxjsql.core.sql.SQLTable;

import java.util.List;

public abstract class BasicSQLColumn implements SQLColumn {
    protected String name, defaultValue;
    private List<String> dataTypeRules;
    private boolean notNull, unique, autoIncrement, primaryKey;
    private SQLColumn foreignKey;
    private SQLTable table;
    private SQLDataType type;
    public BasicSQLColumn(){

    }
    public BasicSQLColumn(String name, String defaultValue, List<String> dataTypeRules, boolean notNull, boolean unique, boolean autoIncrement, boolean primaryKey, SQLColumn foreignKey, SQLTable table, SQLDataType type) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.dataTypeRules = dataTypeRules;
        this.notNull = notNull;
        this.unique = unique;
        this.autoIncrement = autoIncrement;
        this.primaryKey = primaryKey;
        this.foreignKey = foreignKey;
        this.table = table;
        this.type = type;
    }

    protected String buildDataType() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String defaultValue() {
        return defaultValue;
    }

    @Override
    public boolean unique() {
        return unique;
    }

    @Override
    public boolean notNull() {
        return notNull;
    }

    @Override
    public boolean autoIncrement() {
        return autoIncrement;
    }

    @Override
    public boolean primaryKey() {
        return primaryKey;
    }

    @Override
    public boolean isForeignKey() {
        return foreignKey != null;
    }

    @Override
    public SQLColumn foreignKey() {
        return foreignKey;
    }

    @Override
    public SQLTable getTable() {
        return table;
    }

    @Override
    public SQLDataType getDataType() {
        return type;
    }

    @Override
    public List<String> dataTypeRules() {
        return dataTypeRules;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setDataTypeRules(List<String> dataTypeRules) {
        this.dataTypeRules = dataTypeRules;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setForeignKey(SQLColumn foreignKey) {
        this.foreignKey = foreignKey;
    }

    public void setTable(SQLTable table) {
        this.table = table;
    }

    public void setType(SQLDataType type) {
        this.type = type;
    }
}
