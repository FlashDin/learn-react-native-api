package com.testapp0.testapp0api.components;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QueryHelper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JSONObject execFunction(String schema, String pkg, String func, String proc, Map<String, Object> par) {
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);
        if (!schema.isEmpty() || schema != null) {
            jdbcCall.withSchemaName(schema);
        }
        if (!pkg.isEmpty() || pkg != null) {
            jdbcCall.withCatalogName(pkg);
        }
        if (func.isEmpty() || func != null) {
            jdbcCall.withFunctionName(func);
        } else {
            jdbcCall.withProcedureName(proc);
        }
        Map<String, Object> map = jdbcCall.execute(par);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map);
        return jsonObject;
    }

    public Map<String, Object> execQuerySelect(String query) {
        Map<String, Object> map = jdbcTemplate.queryForMap(query);
        return map;
    }

}
