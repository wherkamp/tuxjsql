package me.kingtux.tuxjsql.core.test.builders;

import me.kingtux.tuxjsql.core.TuxJSQL;
import me.kingtux.tuxjsql.core.TuxJSQLBuilder;
import me.kingtux.tuxjsql.core.builders.SQLBuilder;
import org.junit.jupiter.api.Test;

public class TestMain {
    public static void main(String[] args) {
        SQLBuilder builder = TuxJSQLBuilder.getBuildByKey("TEST-SQLBUILDER");
        System.out.println("Able to get "+ builder.name());
    }

}
