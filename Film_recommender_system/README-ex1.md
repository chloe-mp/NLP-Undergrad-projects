# 🎬 TD4 Exercise 1 – Movie Plot Preprocessing and Jaccard Similarity

This notebook demonstrates how to preprocess movie plot summaries using basic Natural Language Processing (NLP) techniques and compute the Jaccard similarity between them.

---

## 📝 Exercise Objective

> **Goal:** Load and clean movie plot data from a JSON file, tokenize and lemmatize it, and compute similarity scores between the processed texts.

---

## 🔍 Steps Performed

1. **Load movie data** from a `.json` file containing `Title` and `Plot`.
2. Define a function `nlp()` to apply a basic NLP pipeline:
   - Remove punctuation
   - Tokenize the text
   - Remove English stop words
   - Lemmatize each token
3. Apply this function to all plot summaries in the dataset.
4. Compute the **Jaccard similarity** between two selected movie plots based on their token sets.

---

## 🛠 Technologies Used

- Python
- `json`, `string`
- `nltk` (tokenization, stopwords, lemmatization)

---

## 🧪 Results

After processing the text and removing stopwords and punctuation, the notebook compares token sets of two movies and computes their **Jaccard similarity**.

**Example result:**

```text
Movie 1: The Matrix
Movie 2: Inception
Jaccard Similarity: 0.078
```

> Interpretation: A low similarity score suggests that, despite both being science fiction films, the vocabulary used in their plots is quite distinct. Jaccard similarity is sensitive to vocabulary overlap, so small scores reflect little intersection between the token sets.

---

## ▶️ Run Instructions

Open the notebook in Jupyter and run the cells. Ensure you have installed the required libraries:

```bash
pip install nltk
```

---

## 👩‍💻 Author

Created by **Chloé Petridis** as part of a university NLP assignment (TD4 - Exercise 1).
