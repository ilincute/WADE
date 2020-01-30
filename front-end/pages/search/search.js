const api = "http://35.239.236.67:80/core/allExponates";

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

function expo() {


  let apiLogin = api;
  fetchApi(apiLogin, "POST", {})
      .then(response => {
        return response.json();
      }).then(function (data) {
        let target = document.getElementById('search_text').value;
        $("#search_cards").html("");
        for (let i = 0; i < data.length; ++i) {
          if (data[i].name.toLowerCase().includes(target.toLowerCase())) {
            $("#search_cards").append('                     <div class="card">\n' +
                '                          <div class="card-title">\n' +
                '                              <h1>' + data[i].name+ '</h1>\n' +
                '                          </div>\n' +
                '                          <div class="card-image">\n' +
                '                              <img class="image" src="' + data[i].image + '" />\n' +
                '                          </div>\n' +
                '                      </div>');
          }

        }
      }).catch((error) => {
        console.log(error);
      })
}

var s = $('input'),
    f  = $('form'),
    a = $('.after'),
		m = $('h4');

s.focus(function(){
  if( f.hasClass('open') ) return;
  f.addClass('in');
  setTimeout(function(){
    f.addClass('open');
    f.removeClass('in');
  }, 1300);
});

a.on('click', function(e){
  e.preventDefault();
  if( !f.hasClass('open') ) return;
   s.val('');
  f.addClass('close');
  f.removeClass('open');
  setTimeout(function(){
    f.removeClass('close');
  }, 1300);
})

f.submit(function(e){
  e.preventDefault();
  expo();
});

