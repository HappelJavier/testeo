

$(document).ready( function(){
	console.log("test");
	
	var summonername = "lukeix";
  	var api_key1= "RGAPI-6ec690fb-60ce-4da3-a3ad-8b1dd6519921";
  	var headers1 = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36",
    "Accept-Language": "es-ES,es;q=0.9,en;q=0.8",
    "Accept-Charset": "application/x-www-form-urlencoded; charset=UTF-8",
    "Origin": "https://developer.riotgames.com",
    "X-Riot-Token": "RGAPI-6ec690fb-60ce-4da3-a3ad-8b1dd6519921",
 	 }
  	var settings = {
    "async": true,
    "dataType": "json",
    "type": "POST",
    "url": "https://la2.api.riotgames.com/lol/summoner/v4/summoners/by-name/lukeix",
    "headers": headers1,
  };
  $.ajax(settings).done(function (response) {
    console.log(response);
  });
	
	
	/*$.ajax({
            url: 'https://la2.api.riotgames.com/lol/summoner/v4/summoners/by-name/lukeix',
            headers: {
              "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36",
              "Accept-Language": "es-ES,es;q=0.9,en;q=0.8",
              "Accept-Charset": "application/x-www-form-urlencoded; charset=UTF-8",
              "Origin": "https://developer.riotgames.com",
              "X-Riot-Token": "RGAPI-6ec690fb-60ce-4da3-a3ad-8b1dd6519921"         
            },
            
            type: 'POST',
            //beforeSend: function(xhr){xhr.setRequestHeader('X-Test-Header', 'test-value');},
            dataType: 'json',
            data: {

            },
            success: function (json) {
				console.log(json);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error getting Summoner data!");
            }
        });*/
	
});