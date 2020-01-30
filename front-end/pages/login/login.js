const api = "http://35.239.236.67:80/core/authenticate";

function setCookie(c_name, value, exdays) {
    let exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    let c_value = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toUTCString());
    document.cookie = c_name + "=" + c_value;
}

function getCookie(c_name) {
    let i, x, y, ARRcookies = document.cookie.split(";");
    for (i = 0; i < ARRcookies.length; i++) {
        x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
        y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
        x = x.replace(/^\s+|\s+$/g, "");
        if (x == c_name) {
            return unescape(y);
        }
    }
}

function fetchApi(api, method, body) {
    const response = fetch(api, {
        method: method,
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(body) // body data type must match "Content-Type" header
      });
    return response;
}

function login() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let apiLogin = api + "?userName=" + email + "&password=" + password;
    console.log(apiLogin);
    fetchApi(apiLogin, "POST", { userName: email, password: password})
    .then(response => {
        return response.json();
    }).then(function (data) {
        console.log(data);
        setCookie("token", data.token, 2);
        setCookie("userId", data.userId, 2);
        setCookie("userName", data.userName, 2);
        window.location.replace("/homepage");

    }).catch((error) => {
        console.log(error);
    })
}

