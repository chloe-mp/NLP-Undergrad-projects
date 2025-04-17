# 🎵 TD4 Exercise 2 – Music Recommendation System Using TF-IDF

This notebook demonstrates a simple content-based recommendation system by comparing song lyrics using **TF-IDF** and **cosine similarity**.

---

## 📝 Exercise Objective

> **Goal:** Load the lyrics of four songs and compute their pairwise similarities using TF-IDF to simulate a content-based music recommendation.

---

## 🔍 Steps Performed

1. Load song lyrics from `.txt` files into a dictionary.
2. Use `TfidfVectorizer` to convert the lyrics into a term-document matrix.
3. Calculate **cosine similarity** between all songs.
4. Rank the most similar songs for each one.
5. Compare results to YouTube's real recommendation order.

---

## 🛠 Technologies Used

- Python
- `scikit-learn` (`TfidfVectorizer`)
- Cosine similarity metric

---

## 🧪 Results

The TF-IDF model generates a matrix where each song is compared to the others.

**Example similarity matrix:**

|             | Song A | Song B | Song C | Song D |
|-------------|--------|--------|--------|--------|
| **Song A**  | 1.00   | 0.82   | 0.34   | 0.28   |
| **Song B**  | 0.82   | 1.00   | 0.39   | 0.27   |
| **Song C**  | 0.34   | 0.39   | 1.00   | 0.79   |
| **Song D**  | 0.28   | 0.27   | 0.79   | 1.00   |

**Observation:**
- Song A and B are the most similar pair → possibly by the same artist or theme
- Song C and D are also close in content
- Recommender ranks the top match per song based on these values

**Conclusion:**
> The model produces results that align with YouTube's suggested songs, confirming that TF-IDF and cosine similarity can effectively recommend songs based on their lyrics. This supports the hypothesis that YouTube uses a content-based or hybrid recommendation system.

---

## ▶️ Run Instructions

Open the notebook in Jupyter and run the cells. Required library:

```bash
pip install scikit-learn
```

---

## 👩‍💻 Author

Created by **Chloé Petridis** as part of a university NLP and recommendation system assignment (TD4 - Exercise 2).
