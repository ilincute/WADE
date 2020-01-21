package com.wd.knowledge.aggregators;

public class WikiDataPredicates {

    public static final String CREATOR = "P170";
    public static final String INSTANCE_OF_PREDICATE = "P31";

    public static final String SPARQL_QUERY_TEMPLATE_WITH_CATEGORY =
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "select ?thing " +
            "where " +
            "{ " +
            "  ?thing rdfs:label \"%s\"@en ." +
            "  ?thing wdt:%s wd:%s ." +
            "}";

    public static final String SPARQL_QUERY_TEMPLATE_FILTER_MUSEUM_EXPONATES =
            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
            "PREFIX wdt: <http://www.wikidata.org/prop/direct/>" +
            "select ?thing" +
            "where" +
            "{" +
            "    ?thing rdfs:label \"%s\"@en ." +
            "    filter exists { ?thing wdt:P195 [] } ." +
            "}";
}
