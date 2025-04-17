package sparql;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.query.ResultSetFormatter;

public class App {
    public static void main(String[] args) {
        Model model = createModel();

        // Lister toutes les instances de la classe Homme
        listHommes(model);

        // Lister toutes les instances de la classe Femme, pour chaque instance afficher son âge.
        listFemmes(model);

        // La liste des personnes (limitée à 3) à un âge supérieur a 20
        listPersonsAgeGreaterThan20(model);

        // Lister toutes les instances de la classe Père.
        listPeres(model);

        // Lister toutes les instances de la classe Mère.
        listMeres(model);

        // Lister toutes les instances de la classe Grand Père.
        listGrandPeres(model);

        // Lister toutes les instances de la classe Frère.
        listFreres(model);

        // Lister toutes les instances de la classe Soeur.
        listSoeurs(model);
    }

    private static Model createModel() {
        String filePath = "/Users/chloe/Documents/toto/L3S2/TD11.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(filePath);
        return model;
    }

    private static void listHommes(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT ?homme ?nom WHERE {\n" +
            "  ?homme rdf:type ex:Homme.\n" +
            "  ?homme ex:nom ?nom.\n" +
            "}";
        execQueryAndPrintResults(model, queryString, "Homme", "Nom");
    }

    private static void listFemmes(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT ?femme ?age WHERE {\n" +
            "  ?femme rdf:type ex:Femme.\n" +
            "  ?femme ex:age ?age.\n" +
            "}";
        execQueryAndPrintResults(model, queryString, "Femme", "Age");
    }

    private static void listPersonsAgeGreaterThan20(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT ?personne ?age WHERE {\n" +
            "  ?personne rdf:type ex:Personne.\n" +
            "  ?personne ex:age ?age.\n" +
            "  FILTER(?age > 20)\n" +
            "}\n" +
            "LIMIT 3";
        execQueryAndPrintResults(model, queryString, "Personne", "Age");
    }
    
    private static void listPeres(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT DISTINCT ?pere WHERE {\n" +
            "  { ?fille rdf:type ex:Femme . ?fille ex:estFilleDe ?pere . ?pere rdf:type ex:Homme . }\n" +
            "  UNION\n" +
            "  { ?fils rdf:type ex:Homme . ?fils ex:estFilsDe ?pere . ?pere rdf:type ex:Homme . }\n" +
            "}";
        execQueryAndPrintResults(model, queryString, "Père", null);
    }
    
    private static void listMeres(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT DISTINCT ?mere WHERE {\n" +
            "  { ?fille rdf:type ex:Femme . ?fille ex:estFilleDe ?mere . ?mere rdf:type ex:Femme . }\n" +
            "  UNION\n" +
            "  { ?fils rdf:type ex:Homme . ?fils ex:estFilsDe ?mere . ?mere rdf:type ex:Femme . }\n" +
            "}";
        execQueryAndPrintResults(model, queryString, "Mère", null);
    }
    
    private static void listGrandPeres(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT DISTINCT ?grandPere WHERE {\n" +
            "  ?personne rdf:type ex:Personne .\n" +
            "  ?personne ex:estEnfantDe ?parent .\n" +
            "  ?parent ex:estEnfantDe ?grandPere .\n" +
            "  ?grandPere rdf:type ex:Homme .\n" +
            "}";
        execQueryAndPrintResults(model, queryString, "Grand-père", null);
    }
    
    private static void listFreres(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT DISTINCT ?frere WHERE {\n" +
            "  ?frere rdf:type ex:Homme .\n" +
            "  ?frere ex:estEnfantDe ?parent .\n" +
            "  ?sibling ex:estEnfantDe ?parent .\n" +
            "  FILTER(?frere != ?sibling)\n" +
        "}";
    execQueryAndPrintResults(model, queryString, "Frère", null);
}

    private static void listSoeurs(Model model) {
        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
            "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n" +
            "SELECT DISTINCT ?soeur WHERE {\n" +
            "  ?soeur rdf:type ex:Femme .\n" +
            "  ?soeur ex:estEnfantDe ?parent .\n" +
            "  ?sibling ex:estEnfantDe ?parent .\n" +
            "  FILTER(?soeur != ?sibling)\n" +
        "}";
    execQueryAndPrintResults(model, queryString, "Soeur", null);
}

    private static void execQueryAndPrintResults(Model model, String queryString, String label1, String label2) {
    Query query = QueryFactory.create(queryString);
    QueryExecution qe = QueryExecutionFactory.create(query, model);
    ResultSet results = qe.execSelect();

    // Utilisez ResultSetFormatter pour afficher les résultats sous forme de tableau
    ResultSetFormatter.out(System.out, results, query);
    qe.close();
    }   
}


