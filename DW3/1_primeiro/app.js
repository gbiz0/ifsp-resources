const express = require('express');
require('dotenv').config();

const app = express();
const port = process.env.PORT;

app.get('/', (req, res) => {
  res.send(`Welcome to ${process.env.APP_NAME}!`);
});

app.listen(port, () => {
  console.log(`${process.env.APP_NAME} is running on port ${port}`);
});
