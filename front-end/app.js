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
app.use(express.static("pages/search"));
app.use(express.static("pages/museums/art-museum"));
app.use(express.static("pages/museums/ethnographic-museum"));
app.use(express.static("pages/museums/history-museum"));
app.use(express.static("pages/museums/science-museum"));
app.use(express.static("pages/museums/exhibit-qr-code"));
app.use(express.static("pages/buy-ticket"));


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


// ---------------- Art museum -------------------

app.get('/art-museum', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/art-museum/art-museum.html'));
});

// ---------------- Ethnographic museum -------------------

app.get('/ethnographic-museum', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/ethnographic-museum/ethnographic-museum.html'));
});

// ---------------- History museum -------------------

app.get('/history-museum', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/history-museum/history-museum.html'));
});

// ---------------- Science museum -------------------

app.get('/science-museum', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/science-museum/science-museum.html'));
});


// ---------------- Sign-up -------------------

app.get('/sign-up', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/sign-up/sign-up.html'));
});

// ---------------- Search -------------------

app.get('/search', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/search/search.html'));
});

// ---------------- Exhibit QR Code -------------------

app.get('/exhibit-qr-code', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/museums/exhibit-qr-code/exhibit-qr-code.html'));
});

// ---------------- Buy-ticket -------------------

app.get('/buy-ticket', function(req,res) {
    res.sendFile(path.join(__dirname+'/pages/buy-ticket/buy-ticket.html'));
});

app.post('/login', function (req, res) {
    // we'll replace this with calls to the apis
    var post = req.body;
    if (post.user === 'john' && post.password === 'johnspassword') {
        req.session.user_id = johns_user_id_here;
        res.redirect('/homepage');
    } else {
        res.send('Bad user/pass');
    }
});




app.listen(port, () => console.log(`Example app listening on port ${port}!`))
