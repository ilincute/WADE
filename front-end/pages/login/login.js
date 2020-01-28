const api = "http://35.184.201.148/ra/authenticate";

function fetchApi(api, method, body) {
    const response = fetch(api, {
        method: method,
        mode: 'no-cors', // *GET, POST, PUT, DELETE, etc.
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
          'Content-Type': 'application/json'
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(body) // body data type must match "Content-Type" header
      });
    return response;
}

function login() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let apiLogin = api + "?userName=" + email + "&password=" + password;
    fetchApi(apiLogin, "POST", { email: email, password: password})
    .then(response => {

        console.log(response)
    
    }).catch((error) => {
        console.log(error);
    })
}