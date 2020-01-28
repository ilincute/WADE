const express = require('express')
const app = express()
const port = 3000
const path = require('path');

// ---------------- Welcome -------------------

app.use(express.static("images"));
app.use(express.static("shared"));
app.use(express.static("pages/welcome"));
app.use(express.static("pages/language"));
app.use(express.static("pages/homepage"));
app.use(express.static("pages/me"));
app.use(express.static("pages/authentication"));
app.use(express.static("pages/login"));
app.use(express.static("pages/sign-up"));
app.use(express.static("pages/museums"));
app.use(express.static("pages/floor-plan"));

app.get('/welcome', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/welcome/welcome.html'));
});

// ---------------- Language -------------------

app.get('/language', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/language/language.html'));
});


// ---------------- Homepage -------------------

app.get('/homepage', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/homepage/homepage.html'));
});

// ---------------- Me -------------------

app.get('/me', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/me/me.html'));
});

// ---------------- Authentication -------------------

app.get('/authentication', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/authentication/authentication.html'));
});

// ---------------- Login -------------------

app.get('/login', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/login/login.html'));
});


// ---------------- Museums -------------------

app.get('/museums', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/museums.html'));
});


// ---------------- Sign-up -------------------

app.get('/sign-up', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/sign-up/sign-up.html'));
});

// ---------------- Floor-Plan -------------------

app.get('/floor-plan', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/floor-plan/floor-plan.html'));
});

// ---------------- Search -------------------

app.get('/search', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/search/search.html'));
});








app.listen(port, () => console.log(`Example app listening on port ${port}!`))