# 📚 Projet S1 – Indexation inversée d’un corpus de textes français

This project builds a basic inverted index from a corpus of French documents. It allows identifying which files contain a given word, functioning like a simple keyword search engine.

---

## 🧠 Objective

To scan a directory of French documents and build an index that maps each word to the list of documents it appears in. This index is saved in JSON format and can be queried to find occurrences of specific terms.

---

## 🛠 Technologies Used

- Python
- `nltk` for tokenization
- `glob` for file system exploration
- `json` for saving/loading the index

---

## 🧑‍💻 How It Works

### 1. Load Documents

```python
documents = {}
for file in glob.glob("corpus_multi/fr/*/*"):
    documents[file] = lire_fichier(file)
```
> Loads the French text files into a dictionary.

---

### 2. Tokenize Words

```python
def decouper_mots(chaine):
    return set(word_tokenize(chaine, language='french'))
```
> Each document is tokenized into individual words. Duplicates are removed using `set()`.

---

### 3. Build Inverted Index

```python
index[mot].add(file)
```
> For each word in each document, a list of file paths is associated.

---

### 4. Save to JSON

```python
with open("index.json", "w") as w:
    json.dump(index_pour_json, w)
```
> The final index is saved to a file for future querying.

---

### 5. Load and Query

```python
with open("index.json") as f:
    index = json.load(f)

index["européenne"]
```
> Returns the list of files that contain the word “européenne”.

---

## 📈 Interpretation of Results

- You obtain a dictionary where each word is linked to the set of documents that contain it.
- This is useful for:
  - Quick keyword search
  - Analyzing term frequency and document occurrence
- It's a simple but efficient model for text indexing.

---

## 💡 Improvements Possible

- Count occurrences per document
- Add multi-word queries
- Use TF-IDF to rank documents by relevance

---

## 👩‍💻 Author

Created by **Chloé Petridis** as part of a university project on text processing and indexing.
