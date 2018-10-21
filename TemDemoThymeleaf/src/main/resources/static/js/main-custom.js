function saveCountry() {
	var country = new Object();

	country.name = $('.myForm #name').val();
	country.capital = $('.myForm #capital').val();
	country.id = $('.myForm #idCountry').val();

	if (country.id != "") {
		
		country.id = parseInt($('.myForm #idCountry').val());

		$.put("/update?id="+country.id, country,function(data) {
			vide();
			notification(data);
			location.reload();
		},'application/json');
	} else {
		$.post("/save", country).done(function(data) {
			vide();
			notification(data);
			location.reload();
		});
	}

}

vide();
getPersonnes();

function vide() {
	$('.myForm #name').val('');
	$('.myForm #capital').val('');
	$('.myForm #idCountry').val('');
}

function showDetails(personne) {
	console.log(personne);
}


function notification(msg) {
	new PNotify({
		title : 'Notification',
		text : msg,
		type : 'success',
		styling : 'bootstrap3'
	});
	setTimeout(function() {
		PNotify.removeAll();
	}, 9000);
}

function deleteCountry() {
	var deleteHref = $('#delRef').val();
	$.ajax({
		url : deleteHref,
		type : 'DELETE',
		success : function(result) {
			location.reload();
			$("#exampleModalCenter .modalClose").click();
			notification(result);
		}
	});
}

function getPersonnes() {
	$.get("/getAllPersonnes").done(function(data) {
		if(data.length>0){
            $.each(data, function(index, record){
                    var row = $("<tr />");
                    $("<td />").text(index+1).appendTo(row);
                    $("<td />").text(record.nom).appendTo(row);
                    $("<td />").text(record.prenom).appendTo(row);
                    $("<td />").text(record.dateNaissance).appendTo(row);
                    $("<td />").text(record.lieuNaissance).appendTo(row);
                    $("<td />").text(record.telephone).appendTo(row);
                    $("<td />").text(record.sexe).appendTo(row);
                    $("<td />").text(record.nationalite).appendTo(row);
                    $("<td />").text(record.country).appendTo(row);
                    $('#dataTable tbody').append(row);
            });
        }
		
	});
}

function resetCountry() {
	$('.sBtn').show('fast');
	$('.uBtn').hide(1000);
}

function updateCountry(data) {
	$.ajax({
		url : '/update',
		type : 'PUT',
		data : JSON.stringify(data),
		success : function(result) {
			location.reload();
			notification(result);
		}
	});
}

$.put = function(url, data, callback, type){
	 
	  if ( $.isFunction(data) ){
	    type = type || callback,
	    callback = data,
	    data = {}
	  }
	 
	  return $.ajax({
	    url: url,
	    type: 'PUT',
	    success: callback,
	    data: JSON.stringify(data),
	    contentType: type
	  });
	}
	
		
	$.delete = function(url, data, callback, type){
	 
	  if ( $.isFunction(data) ){
	    type = type || callback,
	        callback = data,
	        data = {}
	  }
	 
	  return $.ajax({
	    url: url,
	    type: 'DELETE',
	    success: callback,
	    data: JSON.stringify(data),
	    contentType: type
	  });
	}