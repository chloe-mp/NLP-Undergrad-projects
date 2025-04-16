# 🧠 RDF Data Exploration with Apache Jena (Java and SPARQL)

This Java project demonstrates how to load and query RDF data using the [Apache Jena](https://jena.apache.org/) framework. The RDF data models a simple family ontology (e.g., Person, Man, Woman, Father, Mother), and the application extracts meaningful insights using SPARQL queries.

---

## 📁 Project Structure

- **`pom.xml`**  
  Maven configuration file that includes dependencies for:
  - Apache Jena
  - Jackson Databind (JSON processing)
  - Apache Commons Compress
  - JUnit (testing)
  - Logback (logging)

- **`App.java`**  
  Main class that:
  - Loads RDF data from a file.
  - Runs a series of SPARQL queries to:
    - List all instances of `Man`, `Woman` (with age), `Father`, `Mother`, `Grandfather`, `Brother`, and `Sister`.
    - Display people with age greater than 20 (limited to 3).

- **`SparqlExample.java`**  
  A simple example that queries the RDF model for people and their names.

- **`AppTest.java`**  
  A placeholder unit test (always passes).

- **`TD11.rdf`**  
  The RDF file representing a family ontology used for querying.

---

## 🔧 How to Run

1. **Install Maven** if not already installed.

2. **Update the RDF file path** in `App.java` and `SparqlExample.java`:
   ```java
   String filePath = "/path/to/your/TD11.rdf";

3. **Compile the project:
   'nvm compile'

4. **Run the application:
   mvn exec:java -Dexec.mainClass="sparql.App"

5. **Run tests:
   nvm test

  ## Features
  
RDF file parsing using Apache Jena

SPARQL query execution with filters and unions

Console output of query results

Clean and modular code structure

Maven support for easy dependency management and build

## 📌 Example Queries

Some SPARQL queries used in the project include:

Listing all men with their names

Listing women with their age

Listing persons older than 20 (limited to 3)

Listing fathers, mothers, grandfathers, brothers, and sisters using property relationships

## 🚀 Possible Improvements

Make the RDF path configurable via CLI or properties file

Add unit tests for SPARQL methods

Integrate with a web framework (e.g., Spring Boot) to expose queries via REST API

Visualize RDF data and query results


