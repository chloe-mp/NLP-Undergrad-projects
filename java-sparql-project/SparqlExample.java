package sparql;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

public class SparqlExample {

    public static void main(String[] args) {

        // Définir les préfixes utilisés dans les requêtes SPARQL
        String prefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                        "PREFIX ex: <http://www.semanticweb.org/chloe/ontologies/2023/3/untitled-ontology-46#>\n";

        // Définir la requête SPARQL
        String queryString = prefix +
                "SELECT ?personne ?nom WHERE {\n" +
                "  ?personne rdf:type ex:Personne.\n" +
                "  ?personne ex:nom ?nom.\n" +
                "}";

        // Créer un objet Query à partir de la chaîne de requête SPARQL
        Query query = QueryFactory.create(queryString);

        // Créer un objet QueryExecution à partir de la requête et du modèle RDF
        try(QueryExecution qe = QueryExecutionFactory.create(query, createModel())) {

            // Exécuter la requête et obtenir le résultat sous forme de ResultSet
            ResultSet results = qe.execSelect();

            // Parcourir le ResultSet et afficher les résultats
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                RDFNode personne = soln.get("personne");
                RDFNode nom = soln.get("nom");
                System.out.println("Personne: " + personne.toString() + ", Nom: " + nom.toString());
            }
        }
    }

    // Méthode utilitaire pour créer un modèle RDF à partir d'un fichier
    private static Model createModel() {
        String filePath = "/path/to/your/rdf/file.rdf";
        Model model = ModelFactory.createDefaultModel();
        model.read(filePath);
        return model;
    }
}

