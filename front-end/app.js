const express = require('express')
const app = express()
const port = 3000
const path = require('path');

// ---------------- Welcome -------------------

app.use(express.static("images"));

app.get('/welcome', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/welcome/welcome.html'));
});

app.get('/welcome.css', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/welcome/welcome.css'));
});

app.get('/welcome.js', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/welcome/welcome.js'));
});

// ---------------- Language -------------------

app.get('/language', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/language/language.html'));
});

app.get('/language.css', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/language/language.css'));
});

app.get('/language.js', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/language/language.js'));
});


// ---------------- Homepage -------------------

app.get('/homepage', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/homepage/homepage.html'));
});

app.get('/homepage.css', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/homepage/homepage.css'));
});

app.get('/homepage.js', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/homepage/homepage.js'));
});








app.listen(port, () => console.log(`Example app listening on port ${port}!`))