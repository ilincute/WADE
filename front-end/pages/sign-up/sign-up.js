const api = "http://35.239.236.67:80/core/register";

function fetchApi(api, method, body) {
    const response = fetch(api, {
        method: method,
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(body)
    });
    return response;
}

function signup() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let userName = document.getElementById("userName").value;
    let fullName = document.getElementById("fullName").value;

    let apiLogin = api + "?email=" + email + "&password=" + password + "&userName=" + userName + "&lastName=" + fullName;
    console.log(apiLogin);
    fetchApi(apiLogin, "POST", { userName: email, password: password})
        .then(response => {
            return response.json();
        }).then(function (data) {
            console.log(data);
            if (data.status == "valid") {
                location.replace("/homepage");
            }
        }).catch((error) => {
            console.log(error);
        });
}
