$(document).ready(function() {	
	$('#dReport').load("Design_report.html");
	$('#aManual').load("Administration_manual.html");
	$('#dManual').load("Development_manual.html");
	$('#wRules').load("Work_rules.html");
	$('#dReport').hide();
	$('#aManual').hide();
	$('#dManual').hide();
	$('#wRules').hide();

	$.ajax({
		type: 'GET',
		url: '/getTable',
	}).done(function(result) {
		if(result.length > 10){
			for(var i = 0; i < 10; i++){
				$('#' + (i + 1)).html(result.charAt(i)).attr('class', 'alert alert-success');
			}
			$('#gameStatus').html(result.substring(9));
			$('#play').attr('disabled', true);
		}
		else{
			for(var i = 0; i < 10; i++){
				$('#' + (i + 1)).html(result.charAt(i)).attr('class', 'alert alert-success');
			}
		}
	}).fail(function() {
		$('#bla').html('Failed to load table! \n Contact team caps lock for support.').attr('class', 'alert alert-danger');
	});
	

	var form = $('#pInput');
	form.submit(function( event ) {
		var number = $("#xIn").val();
		$('#xIn').val('');
		$.ajax({
			type: form.attr('method'),
			url: form.attr('action'),
			data: 'xIn=' + number
		}).done(function(result) {
			if(result.length > 10){
				for(var i = 0; i < 10; i++){
					$('#' + (i + 1)).html(result.charAt(i)).attr('class', 'alert alert-success');
				}
				$('#gameStatus').html(result.substring(9));
				$('#play').attr('disabled', true);
			}
			else{
				for(var i = 0; i < 10; i++){
					$('#' + (i + 1)).html(result.charAt(i)).attr('class', 'alert alert-success');
				}
			}
			$.ajax({
				type: 'GET',
				url: '/player'
			}).done(function(result) {
				$('#pRound').html(result);
			}).fail(function() {
				$('#error').html('Failed to load player! \n Contact team caps lock for support.').attr('class', 'alert alert-danger'.delay(2000).fadeOut());
			});	

		}).fail(function() {
			$('#error').html('Error, illegal position...').attr('class', 'alert alert-danger').delay(2000).fadeOut();
		});
		event.preventDefault();
	});


	$.ajax({
		type: 'GET',
		url: '/player'
	}).done(function(result) {
		$('#pRound').html(result);
	}).fail(function() {
		$('#error').html('Failed to load player! \n Contact team caps lock for support.').attr('class', 'alert alert-danger').delay(2000).fadeOut();
	});

	var resetGame = $('#resetGame');
	resetGame.click( function() {
		$.ajax({
			type: resetGame.attr('method'),
			url: resetGame.attr('action')
		}).done(function(result) {
			$('#gameStatus').html("");
			$('#play').attr('disabled', false);
			for(var i = 0; i < 10; i++){
				
				$('#' + (i + 1)).html(result.charAt(i)).attr('class', 'alert alert-success');
			}

			$.ajax({
					type: 'GET',
					url: '/player'
				}).done(function(result) {
					$('#pRound').html(result);
				}).fail(function() {
					$('#error').html('Failed to load player! \n Contact team caps lock for support.').attr('class', 'alert alert-danger');
				});

		}).fail(function() {
			$('#error').html('Error, illegal position...').attr('class', 'alert alert-danger');
		});
	})
	
	var docDesButton = $('#docDesButton');
	docDesButton.click( function () {
		var doc = document.getElementById("dReport");
		if ($('#dReport').is(":visible")) {
			$('#dReport').hide();;
		} else {
			$('#dReport').show();
		}
	})
});