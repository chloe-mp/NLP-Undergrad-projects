# 🌍 TD10 – Querying DBpedia with SPARQL and Python

This project demonstrates how to query semantic data from [DBpedia](https://dbpedia.org/) using **SPARQL** and **Python**. The notebook extracts information about people born in Los Angeles, including their names and birthdates, directly from DBpedia's public SPARQL endpoint.

---

## 📂 Files

- **`TD10.ipynb`**  
  Jupyter Notebook that performs SPARQL queries using the `SPARQLWrapper` library.

- **`TD10.rdf`**  
  RDF file 

---

## 🔧 How It Works

The notebook performs the following:

1. Installs and imports necessary libraries:
   ```python
   %pip install RDFLib
   %pip install SPARQLWrapper
   ```

2. Connects to the public SPARQL endpoint at `http://dbpedia.org/sparql`.

3. Runs a SPARQL query to fetch:
   - People (`dbo:Person`)
   - Born in Los Angeles (`dbo:birthPlace`)
   - Their name (`rdfs:label` or `foaf:name`)
   - Their birth date (`dbo:birthDate`)

4. Filters the results to English labels:
   ```sparql
   FILTER (LANG(?name) = "en")
   ```

5. Parses and prints the results as a list of celebrities.

---

## 📋 Example Output

```text
[['Leonardo DiCaprio', '1974-11-11'],
 ['Marilyn Monroe', '1926-06-01'],
 ['Katy Perry', '1984-10-25'],
 ...]
```

*(Results will vary depending on DBpedia’s live data.)*

---

## 🛠 Requirements

- Python 3.x
- Jupyter Notebook
- `SPARQLWrapper`
- (Optionally) `RDFLib`

Install dependencies with:

```bash
pip install SPARQLWrapper
```

---

## 🚀 Run the Notebook

1. Open `TD10.ipynb` in Jupyter Notebook or JupyterLab
2. Execute the cells to query DBpedia and see the results

---

## 📄 License

MIT License

---

## 👩‍💻 Author

Created by **Chloé Petridis** as part of an academic exercise on semantic web technologies.
