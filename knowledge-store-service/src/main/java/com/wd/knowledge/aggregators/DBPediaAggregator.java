package com.wd.knowledge.aggregators;

import org.apache.jena.query.*;

import java.util.Iterator;

import static com.wd.knowledge.aggregators.WikiDataPredicates.INSTANCE_OF_PREDICATE;
import static com.wd.knowledge.aggregators.WikiDataPredicates.SPARQL_QUERY_TEMPLATE_FILTER_MUSEUM_EXPONATES;


public class DBPediaAggregator {

    private static final String WIKIDATA_ORG_SPARQL = "https://query.wikidata.org/sparql";


//
//    public static String query(String exponateName, String museumName) {
//
//        Query query = QueryFactory.create(SPARQL_QUERY_TEMPLATE);
//
//        QueryExecution qexec = QueryExecutionFactory.sparqlService(WIKIDATA_ORG_SPARQL, query);
//        ResultSet resultSet = qexec.execSelect() ;
//
////        ResultSetFormatter.out(System.out, resultSet, query);
//
//        while (resultSet.hasNext()) {
//            QuerySolution result = resultSet.next();
//
//
//            for (Iterator<String> it = result.varNames(); it.hasNext(); ) {
//                String varName = it.next();
//                System.out.println(result.get(varName));
//            }
//            System.out.println("=======================================");
//        }
//
//
//        qexec.close() ;
//3
//        return null;
//    }

    public static String queryMueumExponates(String exponateName) {

        String sparqlQuery = String.format(SPARQL_QUERY_TEMPLATE_FILTER_MUSEUM_EXPONATES, exponateName);

        System.out.println(sparqlQuery);

        Query query = QueryFactory.create(sparqlQuery);

        QueryExecution qexec = QueryExecutionFactory.sparqlService(WIKIDATA_ORG_SPARQL, query);
        ResultSet resultSet = qexec.execSelect() ;

        while (resultSet.hasNext()) {
            QuerySolution result = resultSet.next();

            for (Iterator<String> it = result.varNames(); it.hasNext(); ) {
                String varName = it.next();
                System.out.println(result.get(varName));
            }
        }

        qexec.close() ;

        return null;
    }

    public static void main(String[] args) {

        queryMueumExponates("The Kiss");

    }

}
