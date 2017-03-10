var Ajax;
if (Ajax && (Ajax != null)) {
	Ajax.Responders.register({
	  onCreate: function() {
        if($('spinner') && Ajax.activeRequestCount>0)
          Effect.Appear('spinner',{duration:0.5,queue:'end'});
	  },
	  onComplete: function() {
        if($('spinner') && Ajax.activeRequestCount==0)
          Effect.Fade('spinner',{duration:0.5,queue:'end'});
	  }
	});
}
/*
function loginComplete() {
	if($('memberWelcome')!=null) { 
		$('visitormenu').hide()
		//$('usermenu').hide()
		$('mainmenu').show() 
		$('visitorBrandingWidget').hide()
		$('userBrandingWidget').hide()
		$('memberBrandingWidget').show()
		$('visitorDialogWidget').hide()
		$('userDialogWidget').hide()
		$('memberDialogWidget').show()
		$('visitorScoreWidget').hide()
		$('userScoreWidget').hide()
		$('memberScoreWidget').show()
		$('visitorNewsWidget').hide()
		$('userNewsWidget').hide()
		$('memberNewsWidget').show()
	}
	else {
		if ($('userWelcome')!=null) {
			$('visitormenu').hide()
			// $('usermenu').show()
			$('mainmenu').show() 
			$('visitorBrandingWidget').hide()
			$('userBrandingWidget').show()
			$('memberBrandingWidget').hide()
			$('visitorDialogWidget').hide()
			$('userDialogWidget').show()
			$('memberDialogWidget').hide()
			$('visitorScoreWidget').hide()
			$('userScoreWidget').show()
			$('memberScoreWidget').hide()
			$('visitorNewsWidget').hide()
			$('userNewsWidget').show()
			$('memberNewsWidget').hide()
		}
		else {
			$('visitormenu').show()
			//$('usermenu').hide()
			$('mainmenu').hide() 
			$('visitorBrandingWidget').show()
			$('userBrandingWidget').hide()
			$('memberBrandingWidget').hide()
			$('visitorDialogWidget').show()
			$('userDialogWidget').hide()
			$('memberDialogWidget').hide()
			$('visitorScoreWidget').show()
			$('userScoreWidget').hide()
			$('memberScoreWidget').hide()
			$('visitorScoreWidget').show()
			$('userScoreWidget').hide()
			$('memberScoreWidget').hide()
		}
	}
}
*/

