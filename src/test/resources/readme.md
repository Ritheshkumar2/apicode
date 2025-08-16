Simple Product API

Overview

A tiny REST API built with Node.js + Express for practicing API testing.
It stores products in memory (an array), so data resets whenever the server restarts.

Base URL (local): http://localhost:3000
Content type: application/json

Prerequisites
Node.js (LTS recommended)
npm

Setup & Run
# 1) create project
mkdir product-api && cd product-api

# 2) init & install deps
npm init -y
npm install express body-parser

# 3) create server file
# paste your code into server.js
# 4) run
node server.js
# Server running at http://localhost:3000

Add requests:

GET http://localhost:3000/api/products
POST http://localhost:3000/api/products
Body → raw → JSON → {"name":"Shoes"}
DELETE http://localhost:3000/api/products/T-Shirt
Check Status, Body, and Headers in responses.