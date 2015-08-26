	function setLocale(locale)
		{
			window.location.assign(title+'/login.jsp?locale='+locale);
		}
						
		function loginButtonClick()
		{ 
			
			$('#logoimagediv').css('display','');
			$('#logoimage').addClass("spinner-icon");
			var version=navigator.appVersion.split(';')[1];
			if(hasValue(version)){
				if((version.indexOf("MSIE")>-1)){
					$('#logoimage').attr("src","../images/loader1.gif");
				}
			}
		var version=navigator.appVersion.split(';')[1];
		
		if(document.forms['htmlForm'].elements['j_username'].value == "")
		{
				document.getElementById("login_error").innerHTML ="<font color=\"red\">Please enter your credentials.</font>"; 
				$('#logoimagediv').css('display','none');
				$('#logoimage').removeClass("spinner-icon");
				$('#logoimage').attr("src","../images/logo-small.png");
			}
		else{
			if(hasValue(version)){
				if((version.indexOf("MSIE 9.0")>-1)){
					var username=	$('#htmlForm #j_username').val();
					var password=	$('#htmlForm #j_password').val();
					if(password=="Password"&&username=="Username")
						{
							document.getElementById("login_error").innerHTML ="<font color=\"red\">Please enter your credentials.</font>"; 
							$('#logoimagediv').css('display','none');
							$('#logoimage').removeClass("spinner-icon");
							$('#logoimage').attr("src","../images/logo-small.png");	
						}
						else
				document.forms['htmlForm'].submit();
				}else
				document.forms['htmlForm'].submit();
				}
		else
				document.forms['htmlForm'].submit();
		}}

		function getErrorMessage(error_type)
		{
			if(error_type == 1)
			{
				return "<font color=\"red\">Invalid credentials, please try again.</font>";
					
			}
			else if(error_type == 2){
				return "<font color=\"red\">Your account is locked, please contact administrator.</font>";
			}
			else if(error_type == 3){
				return "<font color=\"red\">Invalid credentials, please try again.</font>";
			}
			else if(error_type == 4){
				return "<font color=\"red\">Your account is disabled, please contact administrator.</font>";
			}
			else if(error_type == 5){
				return "<font color=\"red\">Your account is blocked, please contact administrator.</font>";
			}

			return "";
		}

		function get_url_parameter( param )
		{
			param = param.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
			var r1 = "[\\?&]"+param+"=([^&#]*)";
			var r2 = new RegExp( r1 );
			var r3 = r2.exec( window.location.href );
			if( r3 == null ) 
				return "";
			else 
				return r3[1];
		}

		/*check the value*/
		function hasValue (val)
		{
			return (val != null && val != undefined && val != "null" &&  val != "undefined" &&  val != "");
		}

		/*this function is to open the forgot password window*/	
		function openForgotPassword()
		{
			$('#login-box').css('display','none');
			$('#forgot-box').css('display','');
			$('#openForget').css('display','none');
			$('#back2Login').css('display','');
		}

		/*this function is to open the login window again*/
		function openLoginPassword()
		{
			$('#login-box').css('display','');
			$('#forgot-box').css('display','none');
			$('#openForget').css('display','');
			$('#back2Login').css('display','none');
		}		
		
function defaultLoginPageCall(){
				var error = getErrorMessage(errorType);
				if(hasValue(error)){
				document.getElementById("login_error").innerHTML = error;
				$('#logoimagediv').css('display','none');
				$('#logoimage').removeClass("spinner-icon");
					$('#logoimage').attr("src","../images/logo-small.png");
				}

			$("#or-div").css("display","none");
			$("#ordiv").css("display","none");
			$("#forgot_form").validationEngine();
			if(BrowserDetect.browser == "Explorer")
				$('#confirm_span').css("margin-top","-11%");
			if(BrowserDetect.browser == "Chrome")
				$('#confirm_span').css("margin-top","-4%");
			if(BrowserDetect.browser == "Firefox")
				$('#confirm_span').css("margin-top","-11%");
			$('.alphanumericallow').alphanumeric({allow:"/^[+]?\d*\._?\d*$/%!&@#~(){},<>|:;"});

		    $('#j_password').keypress(function(event) {
			if (event.keyCode == 13) {
				loginButtonClick();
			}
		    });

	var version=navigator.appVersion.split(';')[1];
		if(hasValue(version)){
			if((version.indexOf("MSIE 9.0")>-1)){
	$(function() {
	var input = document.createElement("input");
    if(('placeholder' in input)==false) { 
		$('[placeholder]').focus(function() {
			var i = $(this);
			if(i.val() == i.attr('placeholder')) {
				i.val('').removeClass('placeholder');
				if(i.hasClass('password')) {
					i.removeClass('password');
					this.type='password';
				}			
			}
		}).blur(function() {
			var i = $(this);	
			if(i.val() == '' || i.val() == i.attr('placeholder')) {
				if(this.type=='password') {
					i.addClass('password');
					this.type='text';
				}
				i.addClass('placeholder').val(i.attr('placeholder'));
			}
		}).blur().parents('form').submit(function() {
			$(this).find('[placeholder]').each(function() {
				var i = $(this);
				if(i.val() == i.attr('placeholder'))
					i.val('');
			})
		});
	}
});
}
}
	
}
