$(document).ready(function() {

	$('.table .eBtn').on('click', function(event) {
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(country, status) {
			$('.myForm #idCountry').val(country.id);
			$('.myForm #name').val(country.name);
			$('.myForm #capital').val(country.capital);
			
			var id = $('.myForm #idCountry').val();
			
			if(id!=null){
				$('.sBtn').hide(1000);
				$("#updateBtn").html('<button type="button" onclick="saveCountry()" class="btn btn-warning uBtn">Update</button>');
			}else{
				$('.eBtn').show('fast');
			}
			
		});
	});
	    
	$('.table .dBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#exampleModalCenter #delRef').attr('value', href);
		$('#exampleModalCenter').modal();

	});
	
	//$('#datatable').DataTable({});


	console.log(todos);
	console.log(userInfo);
	console.log(personnescountryJpaQuery);
	console.log(personnescountry);
	console.log(personnescountryquery);
	
});