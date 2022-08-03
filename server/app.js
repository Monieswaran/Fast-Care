const express = require('express');
const indexRouter = require('./routes/index');
const app = express();

const { sequelize } = require('./models')

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/', indexRouter);


sequelize.sync({ force: false, alter: false }).then(() => {
    app.listen(3000, () => {
        console.log("Server is running in http://localhost:3000")
    })
});