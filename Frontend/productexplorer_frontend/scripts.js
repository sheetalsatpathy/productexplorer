// Helper function to create cards
function createCard(className, content) {
  const card = document.createElement("div");
  card.className = className;
  card.innerHTML = content;
  return card;
}

// Load Products
async function loadProducts() {
  try {
    const res = await fetch("http://localhost:8080/api/products");
    const products = await res.json();

    const container = document.getElementById("products-container") || 
                      document.getElementById("all-products-container");
    if (!container) return;

    container.innerHTML = ""; 

    products.forEach(p => {
      const card = createCard("product-card", `
        <h3>${p.title}</h3>
        <p>Source ID: ${p.sourceId || "-"}</p>
        <p>Category: ${p.category ? p.category.name : "No category"}</p>
        <p class="price">${p.currency || "₹"} ${p.price || "0.00"}</p>
        <p><a href="${p.sourceUrl}" target="_blank">View Product</a></p>
        <img src="Assets/${p.imageUrl || 'placeholder.jpg'}" alt="${p.title}" style="max-width:150px;"/>
        <p><small>Last scraped: ${p.lastScrapedAt || "N/A"}</small></p>
      `);
      container.appendChild(card);
    });
  } catch (err) {
    console.error("Error loading products:", err);
  }
}

// Load Categories
async function loadCategories() {
  try {
    const res = await fetch("http://localhost:8080/api/categories");
    const categories = await res.json();

    const container = document.getElementById("categories-container");
    if (!container) return;

    container.innerHTML = "";

    categories.forEach(c => {
  const card = createCard("category-card", `
    <h3>${c.title}</h3>
    <p>Slug: ${c.slug || "-"}</p>
    <p>Products Count: ${c.productCount || 0}</p>
    <p>Navigation ID: ${c.navigation ? c.navigation.id : "-"}</p>
    <p>Parent ID: ${c.parent ? c.parent.id : "-"}</p>
    <p>Last Scraped: ${c.lastScrapedAt || "-"}</p>
  `);
  container.appendChild(card);
});

  } catch (err) {
    console.error("Error loading categories:", err);
  }
}
// Load Reviews
async function loadReviews() {
  try {
    const res = await fetch("http://localhost:8080/api/reviews");
    const reviews = await res.json();

    const container = document.getElementById("reviews-container");
    if (!container) return;

    container.innerHTML = "";

    reviews.forEach(r => {
      const card = createCard("review-card", `
        <h3>Review ID: ${r.id}</h3>
        <p>Product: ${r.product ? r.product.title : "Unknown Product"}</p>
        <p>Author: ${r.author || "Anonymous"}</p>
        <p>Rating: ⭐ ${r.rating || "-"}</p>
        <p>${r.text || "No review text."}</p>
        <p><small>Created: ${r.createdAt || "-"}</small></p>
      `);
      container.appendChild(card);
    });
  } catch (err) {
    console.error("Error loading reviews:", err);
  }
}

// Load View History
async function loadHistory() {
  try {
    const res = await fetch("http://localhost:8080/api/history");
    const history = await res.json();

    const container = document.getElementById("history-container");
    if (!container) return;

    container.innerHTML = "";

    history.forEach(h => {
      const card = createCard("history-card", `
        <h3>History ID: ${h.id}</h3>
        <p>User: ${h.userId || "-"}</p>
        <p>Session: ${h.sessionId || "-"}</p>
        <p>Created: ${h.createdAt || "-"}</p>
      `);
      container.appendChild(card);
    });
  } catch (err) {
    console.error("Error loading history:", err);
  }
}

// Detect page and load data
document.addEventListener("DOMContentLoaded", () => {
  const path = window.location.pathname;

  if (path.includes("index.html")) {
    loadProducts();
  } else if (path.includes("categories.html")) {
    loadCategories();
  } else if (path.includes("products.html")) {
    loadProducts();
  } else if (path.includes("reviews.html")) {
    loadReviews();
  } else if (path.includes("history.html")) {
    loadHistory();
  }
});
