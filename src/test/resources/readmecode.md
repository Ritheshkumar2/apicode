console.log('Running testProduct.js with PORT = 5000');
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT = 5000;
;

// Parses JSON request bodies: {"name":"Shoes"}
app.use(bodyParser.json());

// In-memory data store (resets on restart)
let products = ["Laptop", "Mobile", "T-Shirt"];

// GET /api/products -> list all products
app.get('/api/products', (req, res) => {
  res.json(products);
});

// POST /api/products -> add a product by name
app.post('/api/products', (req, res) => {
  const { name } = req.body;             // expects JSON with { "name": "..." }
  if (!name) {
    return res.status(400).json({ error: "Product name is required" });
  }
  products.push(name);
  res.json({ message: `${name} added successfully!`, products });
});

// DELETE /api/products/:name -> delete by exact name
app.delete('/api/products/:name', (req, res) => {
  const { name } = req.params;
  const index = products.indexOf(name);
  if (index > -1) {
    products.splice(index, 1);
    return res.json({ message: `${name} deleted successfully!`, products });
  }
  res.status(404).json({ error: `${name} not found!` });
});

// Start server
app.listen(PORT, () => {
  console.log(`🚀 Server running at http://localhost:${PORT}`);
});


// PUT /api/products/:oldName -> update to new name
app.put('/api/products/:oldName', (req, res) => {
  const { oldName } = req.params;
  const { newName } = req.body;
  const index = products.indexOf(oldName);

  if (index === -1) {
    return res.status(404).json({ error: `${oldName} not found!` });
  }
  if (!newName) {
    return res.status(400).json({ error: "New product name is required" });
  }

  products[index] = newName;
  res.json({ message: `${oldName} updated to ${newName}`, products });
});

