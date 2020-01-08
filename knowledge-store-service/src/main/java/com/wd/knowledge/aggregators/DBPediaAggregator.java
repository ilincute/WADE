package com.wd.knowledge.aggregators;

import org.apache.jena.query.*;

public class DBPediaAggregator {

    private static final String WIKIDATA_ORG_SPARQL = "https://query.wikidata.org/sparql";

    private static final String SPARQL_QUERY_TEMPLATE =
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "select ?thing " +
            "where " +
            "{ " +
            "  ?thing rdfs:label \"The Kiss\"@en" +
            "}";

    public static String query(String exponateName, String museumName) {

        Query query = QueryFactory.create(SPARQL_QUERY_TEMPLATE);

        QueryExecution qexec = QueryExecutionFactory.sparqlService(WIKIDATA_ORG_SPARQL, query);
        ResultSet resultSet = qexec.execSelect() ;

        ResultSetFormatter.out(System.out, resultSet, query);

        qexec.close() ;

        return null;
    }

    public static void main(String[] args) {
        query(null, null);
    }

}
